package server.model.physical;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import server.model.ShipDesign;

public class StarshipOnHold extends Starship
{
    private Date LAST_SERVICE;

    public StarshipOnHold(ShipDesign design)
    {
        super(design);
        this.LAST_SERVICE = new Date();
    }

    public StarshipOnHold(Starship starship)
    {
        this(starship.DESIGN);
    }

    public long getTimeSinceService()
    {
        return TimeUnit.HOURS.convert(new Date().getTime() - LAST_SERVICE.getTime(), TimeUnit.MILLISECONDS);
    }

    public void service()
    {
        this.LAST_SERVICE = new Date();
    }

    @Override
    public String toString() { return DESIGN.toString() + " (stashed)"; }

}
