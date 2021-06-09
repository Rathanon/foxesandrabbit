package io.muic.ooc.fab;

import java.util.List;
import java.util.Random;

public class Rabbit extends Animal {
    /**
     * Create a new rabbit. A rabbit may be created with age zero (a new born)
     * or with a random age.
     *
     * @param randomAge If true, the rabbit will have a random age.
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Rabbit(boolean randomAge, Field field, Location location) {
        super(randomAge, field, location);
    }

    /**
     * This is what the rabbit does most of the time - it runs around. Sometimes
     * it will breed or die of old age.
     *
     * @param newRabbits A list to return newly born rabbits.
     */
    public void run(List<Rabbit> newRabbits) {
        incrementAge();
        if (isAlive()) {
            giveBirth(newRabbits);
            // Try to move into a free location.
            Location newLocation = field.freeAdjacentLocation(getLocation());
            if (newLocation != null) {
                setLocation(newLocation);
            } else {
                // Overcrowding.
                setDead();
            }
        }
    }

    @Override
    protected double getBreedingProbability() {
        return 0.12;
    }

    @Override
    protected int getMaxLitterSize() {
        return 4;
    }

    @Override
    public int getMaxAge() {
        return 40;
    }

    @Override
    protected int getBreedingAge() {
        return 5;
    }

    @Override
    protected Animal createYoung(boolean randomAge, Field field, Location location) {
        return new Rabbit(randomAge, field, location);
    }
}
