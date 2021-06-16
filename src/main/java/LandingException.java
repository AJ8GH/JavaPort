class LandingException extends Exception {
    LandingException() {
        super("Plane already grounded");
    }
}