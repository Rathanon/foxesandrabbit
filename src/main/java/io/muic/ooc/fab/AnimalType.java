package io.muic.ooc.fab;

public enum AnimalType {
    RABBIT(0.08),
    FOX(0.02);

    private double breedingProbability;

    AnimalType(double breedingProbability) {
        this.breedingProbability = breedingProbability;
    }

    public double getBreedingProbability() {
        return breedingProbability;
    }
}
