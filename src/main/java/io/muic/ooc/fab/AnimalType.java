package io.muic.ooc.fab;

import java.awt.*;

public enum AnimalType {
    RABBIT(0.08, Rabbit.class, Color.ORANGE),
    FOX(0.02, Fox.class, Color.BLUE);

    private double breedingProbability;

    private Class animalClass;

    private Color color;


    AnimalType(double breedingProbability, Class animalClass, Color color) {
        this.breedingProbability = breedingProbability;
        this.animalClass = animalClass;
        this.color = color;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }

    public Class getAnimalClass() {
        return animalClass;
    }

    public Color getColor() {
        return color;
    }
}
