package com.epam.task1.models.flowers;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Tulip extends Flower {

    private String variety;

}
