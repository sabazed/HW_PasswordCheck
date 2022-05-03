package fop.w10pass;

public class NotEnoughException extends Exception {

    private final int should;
    private final int is;

    public NotEnoughException(int should, int is) {
        this.should = should;
        this.is = is;
    }

    @Override
    public String toString() {
        return "Should be " + should + " but is " + is;
    }

}
