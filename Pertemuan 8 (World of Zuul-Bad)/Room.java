public class Room {
    public String desc;
    public Room northExit, westExit, eastExit, southExit;

    public Room(String desc) {
        this.desc = desc;
    }

    public void setExitRooms(Room north, Room east, Room south, Room west) {
        if (north != null)
            northExit = north;
        if (east != null)
            eastExit = east;
        if (south != null)
            southExit = south;
        if (west != null)
            westExit = west;
    }

    public String getDesc() {
        return desc;
    }
}
