package utility;

import java.io.Serializable;

public abstract class Savestate<T extends Serializable>
{
    public abstract boolean save(T object);
    public abstract T load();

    public Savestate<T> getImplementation(String target)
    {
        return new LocalSavestate<T>(target);
    }
}
