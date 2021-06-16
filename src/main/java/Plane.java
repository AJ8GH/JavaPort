class Plane {
    String status;

    Plane() {
        this.status = "Air";
    }

    public void takeOff(Airport airport) throws TakeOffException, AirportException {
        if (status.equals("Air")) throw new TakeOffException();
        airport.takeOff(this);
        this.status = "Air";
    }

    public void land(Airport airport) throws LandingException, CapacityException {
        if (status.equals("Ground")) throw new LandingException();
        airport.land(this);
        this.status = "Ground";
    }
}