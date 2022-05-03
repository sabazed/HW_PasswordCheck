package fop.w10pass;

public class Password {
    private final int nrUpperShould, nrLowerShould, nrSpecialShould,
            nrNumbersShould, lengthShould;
    private final char[] illegalChars;

    private static boolean matchesIllegalCharacter(char[] illegalChars,
                                                   char c) {
        for (int i = 0; i < illegalChars.length; i++)
            if (c == illegalChars[i])
                return true;
        return false;
    }

    public Password(int nrUpperShould, int nrLowerShould, int nrSpecialShould,
                    int nrNumbersShould, int lengthShould, char[] illegalChars) {
        this.nrUpperShould = nrUpperShould;
        this.nrLowerShould = nrLowerShould;
        this.nrSpecialShould = nrSpecialShould;
        this.nrNumbersShould = nrNumbersShould;
        this.lengthShould = lengthShould;
        this.illegalChars = illegalChars;
    }

    public void checkFormat(String pwd) throws Exception {

        int len = pwd.length();
        if (len < lengthShould) throw new NotLongEnough(lengthShould, len);

        int[] params = new int[4];
        // 0 - nums
        // 1 - specials
        // 2 - lower
        // 3 - upper
        for (char c : pwd.toCharArray()) {
            if (matchesIllegalCharacter(illegalChars, c)) throw new IllegalCharException(c);
            else if (Character.isDigit(c)) params[0]++;
            else if (!Character.isLetterOrDigit(c)) params[1]++;
            else if (Character.isLowerCase(c)) params[2]++;
            else if (Character.isUpperCase(c)) params[3]++;
        }

        if (params[0] < nrNumbersShould) throw new NotEnoughNumber(nrNumbersShould, params[0]);
        else if (params[1] < nrSpecialShould) throw new NotEnoughSpecial(nrSpecialShould, params[1]);
        else if (params[2] < nrLowerShould) throw new NotEnoughSpecial(nrLowerShould, params[2]);
        else if (params[3] < nrUpperShould) throw new NotEnoughSpecial(nrUpperShould, params[3]);

    }

}


