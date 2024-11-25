import java.util.ArrayList;
import java.util.List;

public class Field {
    private Object[][] grid;

    public Field(int row, int col) {
        grid = new Object[row][col];
    }

    public void clear(Location location) {
        grid[location.getRow()][location.getCol()] = null;
    }

    public void place(Object object, Location location) {
        grid[location.getRow()][location.getCol()] = object;
    }

    public void clearAll() {
        for (int row = 0; row < getRow(); row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = null;
            }
        }
    }

    public Object getObjectAt(Location location) {
        if (location.getRow() >= 0 && location.getRow() < getRow() && location.getCol() >= 0 && location.getCol() < getCol()) {
            return grid[location.getRow()][location.getCol()];
        } else {
            return null;
        }
    }

    public List<Location> getAllFreeAdjacentLocations(Location location) {
        List<Location> freeLocations = new ArrayList<>();
        List<Location> adjacentLocations = adjacentLocations(location);
        for (Location loc : adjacentLocations) {
            if (getObjectAt(loc) == null) {
                freeLocations.add(loc);
            }
        }
        return freeLocations;
    }

    public Location getFreeAdjacentLocations(Location location) {
        List<Location> freeLocations = getAllFreeAdjacentLocations(location);
        if (freeLocations.size() > 0) {
            return freeLocations.get(0);
        }
        return null;
    }

    public List<Location> adjacentLocations(Location location) {
        List<Location> locations = new ArrayList<>();
        if (location == null) {
            return locations;
        }
        int row = location.getRow();
        int col = location.getCol();
        if (row > 0) {
            locations.add(new Location(row - 1, col));
        }
        if (row < getRow() - 1) {
            locations.add(new Location(row + 1, col));
        }
        if (col > 0) {
            locations.add(new Location(row, col - 1));
        }
        if (col < getCol() - 1) {
            locations.add(new Location(row, col + 1));
        }
        return locations;
    }

    public int getRow() {
        return grid.length;
    }

    public int getCol() {
        return grid[0].length;
    }
}
