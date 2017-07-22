package program.niuke;

/**
 * Created by Fung on 2017/7/10.
 */
public class FirstAppearingOnce {
    private String string = "";
    // Insert one char from stringstream
    public void Insert(char ch) {
        int index = string.indexOf(new String(new char[] { ch }));
        if (index == -1)
            string += ch;
        else if (index == string.length() - 1)
            string = string.substring(0, index);
        else
            string = string.substring(0, index) + string.substring(index + 1);
    }

    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return string.length()==0?'#':string.charAt(0);
    }

    public static void main(String[] args) {
        String string = "google";
        FirstAppearingOnce once = new FirstAppearingOnce();
        for (int i = 0; i < string.length(); i++) {
            once.Insert(string.charAt(i));
            System.out.println(once.FirstAppearingOnce());
        }
    }
}
