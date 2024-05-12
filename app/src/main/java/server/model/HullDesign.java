package server.model;

import server.model.enumerable.MaterialType;

public class HullDesign extends Design implements Physical  // Dziedziczenie wieloaspektowe
{
    private final static int MASS_CONSTANT = 765;   // Atrybut klasowy

    private final double LENGTH;
    private final MaterialType MATERIAL;
    private final double MASS;  // Atrybut wyliczalny
    private int VALUE;

    protected HullDesign(String brand, String model, MaterialType material, double length, int value)
    {
        super(brand, model);
        this.MATERIAL = material;
        this.LENGTH = length;
        this.VALUE = value;
        this.MASS = length * material.DENSITY * MASS_CONSTANT;
    }

    public void setCreditValue(int value) { this.VALUE = value; }

    public MaterialType getMaterial() { return MATERIAL; }
    public double getLength() { return LENGTH; }

    @Override
    public int getCreditValue()
    {
        return VALUE;
    }
    
    @Override
    public double getMass()
    {
        return MASS;
    }

    @Override
    public String toString()
    {
        return super.toString() + " class hull";
    }
}
