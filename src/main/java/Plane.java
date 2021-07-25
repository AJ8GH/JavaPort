class Plane {
    private String status = "Air";

    public String getStatus() {
        return status;
    }

    public void takeOff(Airport airport) throws Exception {
        if (status.equals("Air")) throw new TakeOffException();
        airport.takeOff(this);
        this.status = "Air";
    }

    public void land(Airport airport) throws Exception {
        if (status.equals("Ground")) throw new LandingException();
        airport.land(this);
        this.status = "Ground";
    }
}
