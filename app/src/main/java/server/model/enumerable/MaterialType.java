package server.model.enumerable;

public enum MaterialType
{
    ALUMINUM(2.699, true),
    TITANIUM(4.505, true),
    PLASTEEL(1.860, true),
    POLYCARBONATE(1.220, false),
    FIBERGLASS(2.460, false);

    public final double DENSITY;
    public final boolean ISOLATOR;

    private MaterialType(double d, boolean i)
    {
        this.DENSITY = d;
        this.ISOLATOR = i;
    }
}
