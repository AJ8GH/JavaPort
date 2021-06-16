class Plane {
    String status;

    Plane() {
        this.status = "Ground";
    }

    public void takeOff() throws TakeOffException {
        if (status.equals("Air")) throw new TakeOffException();
        this.status = "Air";
    }

    public void land(Airport airport) throws LandingException, CapacityException {
        if (status.equals("Ground")) throw new LandingException();
        airport.land(this);
        this.status = "Ground";
    }
}