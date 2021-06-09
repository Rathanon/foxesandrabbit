package io.muic.ooc.fab;

import java.util.HashMap;
import java.util.Map;

public class AnimalFactory {

    private static Map<AnimalType, Double> probabilityMap = new HashMap<AnimalType, Double>(){{
        AnimalType[] animalTypes = AnimalType.values();
        for (int i = 0; i < animalTypes.length; i++) {
            put(animalTypes[i], animalTypes[i].getBreedingProbability());

        }
    }};


    public static Animal createAnimal(AnimalType animalType, Field field, Location location) {
        switch (animalType) {
            case RABBIT:
                return new Rabbit(true, field, location);
            case FOX:
                return new Fox(true, field, location);
            default:
                throw new IllegalArgumentException("Unknown animalType");


        }

    }
}