package server.model.enumerable;

public enum FuelType
{
    NITROAMINE(true),
    BERYLLIUM(true),
    KEROSENE(false),
    HYDRAZINE(false),
    XENON(false),
    ARGON(false);

    public final boolean SOLID;

    private FuelType(boolean s)
    {
        this.SOLID = s;
    }
}
