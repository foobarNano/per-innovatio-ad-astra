package server.model;

import server.model.enumerable.FuelType;

public class EngineDesign extends Design implements Physical
{
    private final FuelType FUEL;
    private final int THRUSTER_COUNT;
    private final double THRUST_S;
    private final double MASS_S;
    private final double CONSUMPTION_S;
    private int VALUE_S;

    protected EngineDesign(String brand, String model, int thruster_count, double thrust, double mass, double consumption, FuelType fuel, int value)
    {
        super(brand, model);
        this.FUEL = fuel;
        this.THRUSTER_COUNT = thruster_count;
        this.THRUST_S = thrust;
        this.MASS_S = mass;
        this.CONSUMPTION_S = consumption;
        this.VALUE_S = value;
    }

    public void setCreditValue(int value) { this.VALUE_S = value; }

    public FuelType getFuelType() { return FUEL; }
    public double getThrust() { return THRUSTER_COUNT * THRUST_S; }
    public double getFuelConsumption() { return THRUSTER_COUNT * CONSUMPTION_S; }

    @Override
    public double getMass()
    {
        return THRUSTER_COUNT * MASS_S;
    }

    @Override
    public int getCreditValue()
    {
        return THRUSTER_COUNT * VALUE_S;
    }
    
}
