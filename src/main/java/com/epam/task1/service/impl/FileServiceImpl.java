package com.epam.task1.service.impl;

import com.epam.task1.service.FileService;
import io.vavr.control.Try;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    private static final String PROPERTY_FILE = "flowers.yml";

    @Override
    @SuppressWarnings("unchecked")
    public String readProperty(String className, String property) {
        return String.valueOf(Optional.ofNullable(Try.withResources(
                () -> new FileInputStream(getClass().getClassLoader().getResource(PROPERTY_FILE).getFile()))
                .of(fileInputStream -> (Map<String, Map<String, String>>) new Yaml().load(fileInputStream))
                .getOrElseThrow(() -> new RuntimeException(PROPERTY_FILE + " not found"))
                .get(className).get(property))
                .orElseThrow(() -> new RuntimeException(className + "." + property + " not found in " + PROPERTY_FILE)));
    }

}
