package io.muic.ooc.fab;

import java.util.Iterator;
import java.util.List;

public class Hunter extends Animal {
    // Characteristics shared by all foxes (class variables).
    // The food value of a single rabbit. In effect, this is the
    // number of steps a hunter can go before it has to eat again.
    private static final int RABBIT_FOOD_VALUE = 9;
    private static final int FOX_FOOD_VALUE = 3;
    private static final int TIGER_FOOD_VALUE = 1;

    // The hunters's food level, which is increased by eating rabbits.
    private int foodLevel;

    /**
     * Create a Hunter. A Hunter can be created as a new born (age zero and not
     * hungry) or with a random age and food level.
     *
     * @param randomAge If true, the tiger will have random age and hunger level.
     * @param field     The field currently occupied.
     * @param location  The location within the field.
     */
    @Override
    public void initialize(boolean randomAge, Field field, Location location) {
        super.initialize(randomAge, field, location);
        foodLevel = RANDOM.nextInt(RABBIT_FOOD_VALUE);
    }

    @Override
    protected Location moveToNewLocation() {
        Location newLocation = findFood();
        if (newLocation == null) {
            // No food found - try to move to a free location.
            newLocation = field.freeAdjacentLocation(getLocation());
        }
        return newLocation;
    }


    /**
     * This is what the hunter does most of the time: it hunts for rabbits, foxes and tiger. It is immortal
     * @param newAnimal A list to return newly born foxes.
     */
    @Override
    public void act(List<Animal> newAnimal) {
//        incrementHunger();
        super.act(newAnimal);
    }

    /**
     * Make this hunter more hungry. This could result in the animals's death.
     */
//    private void incrementHunger() {
//        foodLevel--;
//        if (foodLevel <= 0) {
//            setDead();
//        }
//    }

    /**
     * Look for rabbits, foxes and tiger adjacent to the current location.
     *
     * @return Where food was found, or null if it wasn't.
     */
    private Location findFood() {
        List<Location> adjacent = field.adjacentLocations(getLocation());
        Iterator<Location> it = adjacent.iterator();
        while (it.hasNext()) {
            Location where = it.next();
            Object animal = field.getObjectAt(where);
            if (animal instanceof Rabbit) {
                Rabbit rabbit = (Rabbit) animal;
                if (rabbit.isAlive()) {
                    rabbit.setDead();
                    foodLevel = RABBIT_FOOD_VALUE;
                    return where;
                }
            } else if (animal instanceof Fox) {
                Fox fox = (Fox) animal;
                if (fox.isAlive()) {
                    fox.setDead();
                    foodLevel = FOX_FOOD_VALUE;
                    return where;
                }
            } else if (animal instanceof Tiger) {
                Tiger tiger = (Tiger) animal;
                if (tiger.isAlive()) {
                    tiger.setDead();
                    foodLevel = TIGER_FOOD_VALUE;
                    return where;
                }
            }
        }
            return null;

    }

    @Override
    public int getMaxAge() {
        return 200;
    }

    @Override
    protected double getBreedingProbability() {
        return 0.04;
    }

    @Override
    protected int getMaxLitterSize() {
        return 2;
    }

    @Override
    protected int getBreedingAge() {
        return 30;
    }

}
