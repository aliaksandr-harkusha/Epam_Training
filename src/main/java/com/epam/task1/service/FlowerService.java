package com.epam.task1.service;

import com.epam.task1.models.flowers.Flower;

public interface FlowerService {

    <T extends Flower> T getFlower(T t);

}
