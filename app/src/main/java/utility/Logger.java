package utility;

public abstract class Logger
{
    private static Logger _instance = null;

    public abstract void log(String message, Type type);

    public void log(String message) { log(message, Type.INFO); }

    public static Logger getImplementation()
    {
        if (_instance == null) _instance = new LocalLogger();
        return _instance;
    }

    public enum Type
    {
        NONE(' '),
        INFO('&'),
        WARNING('?'),
        ERROR('!');

        public final char SYMBOL;

        private Type(char symbol)
        {
            this.SYMBOL = symbol;
        }
    }
}
