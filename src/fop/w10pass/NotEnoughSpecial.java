package fop.w10pass;

public class NotEnoughSpecial extends NotEnoughException {

    public NotEnoughSpecial(int should, int is) {
        super(should, is);
    }

    @Override
    public String toString() {
        return "NotEnoughSpecialException:\n" + super.toString();
    }

}
