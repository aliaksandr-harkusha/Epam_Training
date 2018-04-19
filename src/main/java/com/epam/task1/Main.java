package com.epam.task1;

import com.epam.task1.models.Bouquet;
import com.epam.task1.models.flowers.*;
import com.epam.task1.service.FlowerService;
import com.epam.task1.utils.FlowerUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(com.epam.task1.config.AppConfig.class);
        FlowerService flowerService = context.getBean(FlowerService.class);

        int minLength = 12;
        int maxLength = 24;

        //Create flowers
        Rose rose = flowerService.getFlower(new Rose());
        Chamomile chamomile = flowerService.getFlower(new Chamomile());
        Lilac lilac = flowerService.getFlower(new Lilac());
        Tulip tulip = flowerService.getFlower(new Tulip());
        Violet violet = flowerService.getFlower(new Violet());

        //Create bouquet
        Bouquet bouquet = new Bouquet(new ArrayList<>(Arrays.asList(chamomile, lilac, rose, tulip, violet)));

        System.out.println("The bouquet contains: ");
        bouquet.getFlowerList().forEach(System.out::println);

        System.out.println("\nBouquet total price: " + FlowerUtil.getTotalCostOfFlowers(bouquet.getFlowerList()));

        System.out.println("\nFlowers in the current bouquet according to the level of freshness: ");
        FlowerUtil.sortFlowersByFreshness(bouquet.getFlowerList()).forEach(System.out::println);

        System.out.println("\nFlowers with length of stem between " + minLength + " and " + maxLength + ":");
        FlowerUtil.findFlowersByLength(bouquet.getFlowerList(), minLength, maxLength).forEach(System.out::println);
    }

}
