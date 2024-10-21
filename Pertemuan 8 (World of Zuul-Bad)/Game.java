public class Game {
    private ParseCommand p;
    private Room curr;
    private Command cmd;

    public Game() {
        p = new ParseCommand();
        initRooms();
    }

    public void initRooms() {
        Room out, th, pb, lb, off;
        out = new Room("outside the main entrance of the university");
        th = new Room("in the lecture theatre");
        pb = new Room("in the campus pub");
        lb = new Room("in the computing lab");
        off = new Room("in the computing admin office");
        
        out.setExitRooms(null, th, lb, pb);
        th.setExitRooms(null, null, null, out);
        pb.setExitRooms(null, out, null, null);
        lb.setExitRooms(out, off, null, null);
        off.setExitRooms(null, null, null, lb);
        curr = out;
    }

    public void play() {
        welcomeMessage();
        boolean end = false;
        while (!end) {
            cmd = p.getCommand();
            end = processCommand(cmd);
        }
        endMessage();
    }

    private void welcomeMessage() {
        System.out.println();
        System.out.println("Welcome to the Adventure!");
        System.out.println("To play, please type 'go <direction>', for example: go north");
        System.out.println("Type 'help' if you need help.");
        System.out.println("Type 'quit' to quit the game.");
        printCurrRoomInfo();
    }

    private void endMessage() {
        System.out.println();
        System.out.println("Thanks for playing.");
    }

    private void printCurrRoomInfo() {
        System.out.println();
        System.out.println("You are currently at " + curr.getDesc() + ".");
        System.out.print("Possible exits: ");
        if (curr.northExit != null)
            System.out.print("north ");
        if (curr.eastExit != null)
            System.out.print("east ");
        if (curr.southExit != null)
            System.out.print("south ");
        if (curr.westExit != null)
            System.out.print("west");
        System.out.println();
    }

    private boolean processCommand(Command c) {
        boolean wantToQuit = false;
        if (c.isUnknownCommand()) {
            System.out.println();
            System.out.println("I do not know what you mean. Please enter a valid command.");
            System.out.println("Valid commands are: go, quit, help");
            return false;
        }
        String cmdWord = c.getCommandWord();
        if (cmdWord.equals("help"))
            printHelp();
        if (cmdWord.equals("go"))
            goToAnotherRoom(c);
        if (cmdWord.equals("quit")) {
            wantToQuit = quitGame(c);
        }
        return wantToQuit;
    }

    public void printHelp() {
        System.out.println("You are lost.");
        System.out.println("Please enter one of these commands: go, quit, help");
    }

    public void goToAnotherRoom(Command c) {
        if (!c.hasExtraWord()) {
            System.out.println();
            System.out.println("Where do you want to go? Please specify the direction (north, west, south, east).");
            return;
        }
        String dir = c.getExtraWord();
        Room next = null;
        if (dir.equals("north"))
            next = curr.northExit;
        else if (dir.equals("east"))
            next = curr.eastExit;
        else if (dir.equals("south"))
            next = curr.southExit;
        else if (dir.equals("west"))
            next = curr.westExit;
        else {
            System.out.println();
            System.out.println("Please enter one of these following: north, east, south, west");
            return;
        }
        if (next == null) {
            System.out.println();
            System.out.println("You can't go to the " + dir + ". There is no door here.");
            return;
        } else {
            curr = next;
            printCurrRoomInfo();
        }
    }

    private boolean quitGame(Command c) {
        if (c.hasExtraWord()) {
            System.out.println();
            System.out.println("What do you want to quit?");
            System.out.println("To quit from the game, please type 'quit' only.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}