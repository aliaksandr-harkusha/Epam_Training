package com.epam.task1.models;

import com.epam.task1.models.flowers.Flower;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Bouquet {

    private List<Flower> flowerList;

}
