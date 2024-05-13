package server.model.physical;

import server.model.ShipDesign;

public abstract class Starship
{
    protected final ShipDesign DESIGN;

    public Starship(ShipDesign design)
    {
        this.DESIGN = design;
    }

    public Starship(Starship starship)
    {
        this(starship.DESIGN);
    }

    public ShipDesign getShipInfo() { return DESIGN; }

    @Override
    public abstract String toString();
}
