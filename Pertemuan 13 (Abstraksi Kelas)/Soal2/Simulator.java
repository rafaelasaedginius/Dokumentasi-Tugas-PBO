import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Iterator;

public class Simulator {
    private List<Animal> animals;
    private Field field;
    private int currentStep;
    private SimulatorView view;

    public Simulator(int row, int col) {
        if (row <= 0 || col <= 0) {
            System.out.println("The number of rows and columns must be greater than zero.");
            System.out.println("Using default values.");
            row = 10;
            col = 10;
        }
        animals = new ArrayList<>();
        field = new Field(row, col);
        view = new SimulatorView(row, col);
        reset();
    }

    public void simulate(int maxSteps) {
        for (int step = 1; step <= maxSteps; step++) {
            simulateOneStep();
            view.showStatus(step, field);
        }
    }

    public void simulateOneStep() {
        List<Animal> newAnimals = new ArrayList<>();
        List<Animal> deadAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.isAlive()) {
                animal.act(newAnimals);
            }
        }
        for (Iterator<Animal> it = animals.iterator(); it.hasNext();) {
            Animal animal = it.next();
            if (!animal.isAlive()) {
                it.remove();
                deadAnimals.add(animal);
            }
        }
        animals.addAll(newAnimals);
        view.updateGrid(field);
    }

    private void reset() {
        animals.clear();
        field.clearAll();
        addInitialAnimals();
        currentStep = 0;
    }

    private void addInitialAnimals() {
        Random rand = new Random();
        int numRabbits = 5;
        int numFoxes = 5;

        for (int i = 0; i < numRabbits; i++) {
            Location location = new Location(rand.nextInt(field.getRow()), rand.nextInt(field.getCol()));
            Rabbit rabbit = new Rabbit(false, field, location);
            animals.add(rabbit);
            field.place(rabbit, location);
        }

        for (int i = 0; i < numFoxes; i++) {
            Location location = new Location(rand.nextInt(field.getRow()), rand.nextInt(field.getCol()));
            Fox fox = new Fox(false, field, location);
            animals.add(fox);
            field.place(fox, location);
        }
    }
    public static void main(String[] args) {
        Simulator simulator = new Simulator(4, 4);

        simulator.simulate(5);
    }

}   