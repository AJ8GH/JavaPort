class Plane {
    String status;

    Plane() {
        this.status = "Ground";
    }

    public String takeOff() {
        return this.status = "Air";
    }

    public String land() throws LandingException {
        if (status.equals("Ground")) throw new LandingException();

        return this.status = "Ground";
    }
}