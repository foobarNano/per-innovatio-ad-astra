package utility;

public final class LocalLogger extends Logger
{
    @Override
    public void log(String message, Type type)
    {
        System.out.println(String.format("[%s] %s", type.SYMBOL, message));
    }

}
