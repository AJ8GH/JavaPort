class Plane {
    String status;

    Plane() {
        this.status = "Ground";
    }

    public String takeOff() {
        return this.status = "Air";
    }

    public String land() {
        return this.status = "Ground";
    }
}