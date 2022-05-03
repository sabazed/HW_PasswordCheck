package fop.w10pass;

public class NotEnoughLowerCase extends NotEnoughLetter {

    public NotEnoughLowerCase(int should, int is) {
        super(should, is);
    }

    @Override
    public String toString() {
        return "NotEnoughLowerCaseException:\n" + super.toString();
    }

}
