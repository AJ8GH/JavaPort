class TakeOffException extends Exception {
    TakeOffException() {
        super("Plane already airborne");
    }
}