package server.model;

import server.model.enumerable.SystemType;

public class SystemDesign extends Design
{
    private final SystemType TYPE;
    private final int VALUE;

    protected SystemDesign(String brand, String model, SystemType type, int value)
    {
        super(brand, model);
        this.TYPE = type;
        this.VALUE = value;
    }

    public SystemType getSystemType() { return TYPE; }

    @Override
    public int getCreditValue() { return VALUE; }
}
