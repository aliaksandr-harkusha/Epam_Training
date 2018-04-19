package com.epam.task1.utils;

import com.epam.task1.models.flowers.Flower;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class FlowerUtil {

    private FlowerUtil() {
    }

    public static List<Flower> sortFlowersByFreshness(List<Flower> flowers) {
        return flowers.stream()
                .sorted(Comparator.comparing(Flower::getDaysOnSale))
                .collect(Collectors.toList());
    }

    public static List<Flower> findFlowersByLength(List<Flower> flowers, int minLength, int maxLength) {
        return flowers.stream()
                .filter(flower -> Double.parseDouble(flower.getLength()) >= minLength
                        && Double.parseDouble(flower.getLength()) <= maxLength)
                .collect(Collectors.toList());
    }

    public static double getTotalCostOfFlowers(List<Flower> flowers) {
        return flowers.stream()
                .map(Flower::getPrice)
                .mapToDouble(Double::parseDouble)
                .sum();
    }

}
