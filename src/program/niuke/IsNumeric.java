package program.niuke;

/**
 * Created by Fung on 2017/7/10.
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0)
            return false;
        String string = new String(str);
        String[] e = string.split("e|E");
        if (e.length > 2 || string.endsWith("e") || string.endsWith("E"))
            return false;
        return isNum(e[0], false) && (e.length != 2 || isNum(e[1], true));
    }

    private boolean isNum(String string, boolean s) {
        if (string == null || string.length() == 0 || string.equals("+") || string.equals("-"))
            return false;
        int i = string.charAt(0) == '+' || string.charAt(0) == '-' ? 1 : 0;
        for (; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == '.') {
                if (s || i == string.length() - 1)
                    return false;
                else
                    s = true;
            } else if (Character.isDigit(c))
                continue;
            else
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        char[] c = "+21E".toCharArray();
        System.out.println(new IsNumeric().isNumeric(c));
        StringBuffer str = new StringBuffer();
        str.toString().replaceAll(" ", "%20");
    }
}
