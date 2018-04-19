package com.epam.task1.service.impl;

import com.epam.task1.models.flowers.Flower;
import com.epam.task1.service.FileService;
import com.epam.task1.service.FlowerService;
import io.vavr.control.Try;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.function.Function;
import java.util.stream.Stream;

@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FileService fileService;

    @Override
    public <T extends Flower> T getFlower(T flower) {
        Stream.of(flower.getClass().getSuperclass().getDeclaredFields(), flower.getClass().getDeclaredFields())
                .flatMap(Stream::of)
                .forEach(field -> Try.run(() -> flower.getClass().getMethod("set" +
                        StringUtils.capitalize(field.getName()), field.getType().getName().getClass())
                        .invoke(flower, fileService.readProperty(flower.getClass().getSimpleName(), field.getName())))
                        .getOrElseThrow((Function<Throwable, IllegalStateException>) IllegalStateException::new));

        return flower;
    }

}
