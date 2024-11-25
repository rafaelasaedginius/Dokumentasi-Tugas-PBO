public class SimulatorView {
    private char[][] grid;
    private int rows;
    private int cols;

    public SimulatorView(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new char[rows][cols];
        clearGrid();
    }

    public void clearGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = '.';
            }
        }
    }

    public void setView(Class<?> animalClass, char symbol) {
        if (animalClass == Rabbit.class) {
            setSymbol(symbol);
        } else if (animalClass == Fox.class) {
            setSymbol(symbol);
        }
    }

    private void setSymbol(char symbol) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                grid[row][col] = symbol;
            }
        }
    }

    public void updateGrid(Field field) {
        clearGrid();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Object obj = field.getObjectAt(new Location(row, col));
                if (obj instanceof Rabbit) {
                    grid[row][col] = 'R';
                } else if (obj instanceof Fox) {
                    grid[row][col] = 'F';
                }
            }
        }
    }

    public void showStatus(int step, Field field) {
        System.out.println("Step: " + step);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}
