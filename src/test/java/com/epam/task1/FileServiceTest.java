package com.epam.task1;

import com.epam.task1.models.flowers.Rose;
import com.epam.task1.service.FileService;
import com.epam.task1.service.FlowerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FileServiceTest extends Assert {

    private ApplicationContext context = new AnnotationConfigApplicationContext(com.epam.task1.config.AppConfig.class);
    private FileService fileService = context.getBean(FileService.class);
    private FlowerService flowerService = context.getBean(FlowerService.class);

    private Rose rose;

    @Before
    public void initRose() {
        rose = flowerService.getFlower(new Rose());
    }

    @Test
    public void readProperty() throws Exception {
        Assert.assertEquals(fileService.readProperty("Rose", "color"), rose.getColor());
    }

}
