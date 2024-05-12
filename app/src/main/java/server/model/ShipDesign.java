package server.model;

import server.model.enumerable.FuelType;
import server.model.enumerable.MaterialType;

public class ShipDesign extends Design implements Physical  // Wielodziedziczenie
{
    private final String VERSION;
    private final HullDesign HULL;
    private final EngineDesign ENGINE;
    private final SystemDesign[] SYSTEMS;

    protected ShipDesign(HullDesign hull, EngineDesign engine, String version, SystemDesign... systems)
    {
        super(hull.BRAND, hull.MODEL);
        this.VERSION = version;
        this.HULL = hull;
        this.ENGINE = engine;
        this.SYSTEMS = systems;
    }

    public String getVersion() { return VERSION; }
    public MaterialType getMaterial() { return HULL.getMaterial(); }    // Dziedziczenie dynamiczne
    public double getLength() { return HULL.getLength(); }
    public FuelType getFuelType() { return ENGINE.getFuelType(); }
    public double getThrust() { return ENGINE.getThrust(); }
    public double getFuelConsumption() { return ENGINE.getFuelConsumption(); }

    public SystemDesign[] getSubsystems() { return SYSTEMS; }

    @Override
    public int getCreditValue()     // Overlapping
    {
        int system_value_total = 0;
        for (SystemDesign s : SYSTEMS) { system_value_total += s.getCreditValue(); }

        return HULL.getCreditValue() + ENGINE.getCreditValue() + system_value_total; // + ...
    }

    @Override
    public double getMass()
    {
        return HULL.getMass() + ENGINE.getMass(); // + ...
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + VERSION + " class ship";
    }
}
