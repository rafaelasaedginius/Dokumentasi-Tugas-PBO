import java.util.List;
import java.util.Random;

public abstract class Animal {
    protected int age;
    protected boolean isAlive;
    protected Location currentLocation;
    protected Field animalField;
    protected static final Random random = new Random();

    public Animal(boolean randomAge, Field field, Location location) {
        if (randomAge) {
            this.age = random.nextInt(getMaxAge());
        } else {
            this.age = 0;
        }
        this.animalField = field;
        this.isAlive = true;
        setLocation(location);
    }

    public int getAge() {
        return age;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public Location getLocation() {
        return currentLocation;
    }

    public void setLocation(Location newLocation) {
        if (currentLocation != null) {
            animalField.clear(currentLocation);
        }
        currentLocation = newLocation;
        animalField.place(this, newLocation);
    }

    public void setDead() {
        isAlive = false;
        if (currentLocation != null) {
            animalField.clear(currentLocation);
            currentLocation = null;
        }
        animalField = null;
    }

    public boolean canBreed() {
        return age >= getBreedingAge();
    }

    protected void incrementAge() {
        age++;
        if (age > getMaxAge()) {
            setDead();
        }
    }

    protected void giveBirth(List<Animal> newAnimals) {
        if (currentLocation == null) {
            return;
        }
        List<Location> freeSpaces = animalField.getAllFreeAdjacentLocations(currentLocation);
        int offspringCount = breed();
        for (int i = 0; i < offspringCount && freeSpaces.size() > 0; i++) {
            Location loc = freeSpaces.remove(0);
            Animal baby = createYoung(animalField, loc);
            newAnimals.add(baby);
        }
    }

    protected int breed() {
        int offspringCount = 0;
        if (canBreed() && random.nextDouble() <= getBreedingProbability()) {
            offspringCount = random.nextInt(getMaxLitterSize()) + 1;
        }
        return offspringCount;
    }

    public String printLocation(Location location) {
        return String.format("(" + (location.getRow() + 1) + "," + (location.getCol() + 1) + ")");
    }

    public abstract void act(List<Animal> newAnimals);
    protected abstract int getMaxAge();
    protected abstract int getBreedingAge();
    protected abstract double getBreedingProbability();
    protected abstract int getMaxLitterSize();
    protected abstract Animal createYoung(Field field, Location location);
}
