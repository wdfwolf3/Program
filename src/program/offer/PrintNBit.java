package program.offer;


import java.util.Scanner;

public class PrintNBit {
    public void printNBit(int n) {
        String string = "";
        for (int i = 0; i < n; i++)
            string += "0";
        char[] chars = string.toCharArray();
        int i = n - 1;
        while (true) {
            if (chars[i] != '9')
                chars[i] = (char) (chars[i] + 1);
            else {
                chars[i] = '0';
                int j = i - 1;
                for (; j >= 0; j--)
                    if (chars[j] != '9') {
                        chars[j] += 1;
                        break;
                    } else
                        chars[j] = '0';
                if (j < 0)
                    break;
            }
            help(chars);
        }
    }

    public void help(char[] chars) {
        int i = 0;
        for (; i < chars.length; i++)
            if (chars[i] != '0')
                break;
        System.out.println(new String(chars).substring(i));
    }

    public static void main(String[] args) {
        PrintNBit printNBit = new PrintNBit();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            printNBit.printNBitII(n);
        }
    }

    public void printNBitII(int n) {
        StringBuilder builder = new StringBuilder("0");
        while (true) {
            char c = builder.charAt(builder.length() - 1);
            if (c != '9')
                builder.setCharAt(builder.length() - 1, (char) (c + 1));
            else {
                builder.setCharAt(builder.length() - 1, '0');
                int j = builder.length() - 2;
                for (; j >= 0; j--)
                    if (builder.charAt(j) != '9') {
                        builder.setCharAt(j, (char) (builder.charAt(j) + 1));
                        break;
                    } else
                        builder.setCharAt(j, '0');
                if (j >= 0)
                    continue;
                else if (builder.length() == n)
                    break;
                else {
                    builder.insert(0, '1');
                }
            }
            System.out.println(builder.toString());
        }
    }
}
