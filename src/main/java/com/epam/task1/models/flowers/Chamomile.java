package com.epam.task1.models.flowers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Chamomile extends Flower {

    private String numberOfFlowers;

}
