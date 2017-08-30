package program.javaTest.interfacetest;

/**
 * Created by wdfwolf3 on 2017/7/6.
 */
public class Expect extends POJO {
    public boolean Find(int target, int[][] array) {
        if (array == null || array.length == 0)
            return false;
        return help(target, array, 0, array[0].length - 1, 0, array.length - 1);
    }

    public boolean help(int target, int[][] array, int l, int r, int t, int b) {
        if (l == r && t == b)
            return array[t][l] == target;
        if (l > r || t > b)
            return false;
        int mid1 = (t + b) / 2, mid2 = (l + r) / 2;
        if (array[mid1][mid2] == target)
            return true;
        else if (array[mid1][mid2] > target)
            return help(target, array, l, mid2, t, mid1);
        else
            return help(target, array, l, r, mid1 + 1, b) || help(target, array, mid2 + 1, r, t, mid1);
    }

    public static void main(String[] args) {
        Expect expect = new Expect();
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean b = expect.Find(15, array);
        System.out.println(b);
    }

}
