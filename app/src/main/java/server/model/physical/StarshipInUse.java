package server.model.physical;

import server.model.ShipDesign;

public class StarshipInUse extends Starship
{
    private double fuel;

    public StarshipInUse(ShipDesign design)
    {
        super(design);
    }

    public StarshipInUse(Starship starship)
    {
        super(starship);
        this.fuel = 0;
    }

    public double checkFuel()
    {
        return fuel;
    }

    public void refuel(double fuel)
    {
        this.fuel += fuel;
    }

    public void travel(int distance)
    {
        this.fuel -= distance * DESIGN.getFuelConsumption();
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toString'");
    }

}
