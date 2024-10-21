public class Command {
    private String cmdWord;
    private String extra;

    public Command(String cmdWord, String extra) {
        this.cmdWord = cmdWord;
        this.extra = extra;
    }

    public String getCommandWord() {
        return cmdWord;
    }

    public String getExtraWord() {
        return extra;
    }

    public boolean isUnknownCommand() {
        return (cmdWord == null);
    }

    public boolean hasExtraWord() {
        return (extra != null);
    }
}
