public class Words {
    private static final String[] cmds = { "go", "quit", "help" };

    public Words() {}

    public boolean isAllowedCommand(String cmd) {
        for (String c : cmds) {
            if (c.equals(cmd))
                return true;
        }
        return false;
    }
}
