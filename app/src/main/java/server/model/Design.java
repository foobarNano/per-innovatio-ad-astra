package server.model;

public abstract class Design    // Klasa abstrakcyjna
{
    private static long _designCount = 0;

    protected final long ID;
    protected final String BRAND;
    protected final String MODEL;

    protected Design(String brand, String model)
    {
        this.ID = ++_designCount;
        this.BRAND = brand;
        this.MODEL = model;
    }

    @Override
    public String toString()  // Przesłonięcie metody
    {
        return "[" + BRAND + "] " + MODEL;
    }
    
    public abstract int getCreditValue();   // Polimorfizm
}
