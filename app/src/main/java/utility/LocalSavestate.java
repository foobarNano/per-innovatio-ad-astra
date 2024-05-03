package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class LocalSavestate<T extends Serializable> extends Savestate<T>
{
    private final String _FILENAME;

    public LocalSavestate(String filename)
    {
        this._FILENAME = filename;
    }

    @Override
    public boolean save(T object)
    {
        FileOutputStream stream = null;
        ObjectOutputStream out = null;
        try
        {
            stream = new FileOutputStream(_FILENAME);
            out = new ObjectOutputStream(stream);

            out.writeObject(object);

            out.close();
            stream.close();

            return true;
        }
        catch (IOException e)
        {
            String error = String.format("Failed to save '%s': %s", object.getClass().getName(), e.getMessage());
            Logger.getImplementation().log(error, Logger.Type.ERROR);

            try
            {
                if (out != null) out.close();
                if (stream != null) stream.close();
            }
            catch (IOException e1) {}   // No need to handle, it's already clear something went wrong.
        }
        
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T load()
    {
        T object = null;
        FileInputStream stream = null;
        ObjectInputStream in = null;
        try
        {
            stream = new FileInputStream(_FILENAME);
            in = new ObjectInputStream(stream);

            object = (T) in.readObject();

            in.close();
            stream.close();

            return object;
        }
        catch (IOException | ClassNotFoundException | ClassCastException e)
        {
            String error = String.format("Failed to load serializable: %s", e.getMessage());
            Logger.getImplementation().log(error, Logger.Type.ERROR);

            try
            {
                if (in != null) in.close();
                if (stream != null) stream.close();
            }
            catch (IOException e1) {}   // No need to handle, it's already clear something went wrong.
        }
        
        return null;
    }

}
