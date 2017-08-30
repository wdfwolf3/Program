package program.exam.alibaba;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main1 {
    public static Model boxTemplate = new Model();
    public static final int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
    public static Model[] items;
    public static int boxMinNum = 0;

    /** 请完成下面这个process函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    private static int process() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].price > 2000)
                return -1;
            if (items[i].length > boxTemplate.length || items[i].width > boxTemplate.width || items[i].height > boxTemplate.width)
                return -1;
        }
        List<Model> list = Arrays.asList(items);
        while (list.size() != 0) {
            int[][][][][] dp = new int[list.size()][boxTemplate.price][boxTemplate.length][boxTemplate.width][boxTemplate.height];
            List<Integer> list1 = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                for (int j = 0; j < boxTemplate.price; j++) {
                    for (int k = 0; k < boxTemplate.length; k++) {
                        for (int l = 0; l < boxTemplate.width; l++) {
                            for (int m = 0; m < boxTemplate.height; m++) {
                                if (i == 0) {
                                    if (list.get(i).price > j || list.get(i).length > k || list.get(i).width > l || list.get(i).height > m)
                                        continue;
                                    else
                                        dp[i][j][k][l][m] = 1;
                                } else {
                                    if (list.get(i).price > j || list.get(i).length > k || list.get(i).width > l || list.get(i).height > m)
                                        dp[i][j][k][l][m] = dp[i - 1][j][k][l][m];
                                    else if (dp[i - 1][j - boxTemplate.price][k - boxTemplate.length][l - boxTemplate.width][m - boxTemplate.height] > dp[i - 1][j][k][l][m]) {
                                        dp[i][j][k][l][m] = dp[i - 1][j - boxTemplate.price][k - boxTemplate.length][l - boxTemplate.width][m - boxTemplate.height];
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (Integer integer : list1)
                list.remove(integer);
            boxMinNum++;
        }
        return boxMinNum;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()) {
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for (int i = 0; i < itemNum; i++) {
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
            long startTime = System.currentTimeMillis();
            boxMinNum = Integer.MAX_VALUE;
            System.out.println(process());

        }
    }
}

class Model {
    public int price;
    public int length;
    public int width;
    public int height;
}
