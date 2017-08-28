package program.offer;

import java.util.ArrayList;

/**
 * Created by Fung on 2017/7/5.
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0)
            return list;
        int flag = 0, sum = matrix.length * matrix[0].length;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        for (int k = 0, i = 0, j = 0; k < sum; k++) {
            list.add(matrix[i][j]);
            switch (flag) {
                case 0: {
                    if (j == right) {
                        flag = 1;
                        top++;
                        i++;
                    } else
                        j++;
                    break;
                }
                case 1: {
                    if (i == bottom) {
                        flag = 2;
                        right--;
                        j--;
                    } else
                        i++;
                    break;
                }
                case 2: {
                    if (j == left) {
                        flag = 3;
                        bottom--;
                        i--;
                    } else
                        j--;
                    break;
                }
                case 3: {
                    if (i == top) {
                        flag = 0;
                        left++;
                        j++;
                    } else
                        i--;
                    break;
                }
                default:
                    break;
            }
        }
        return list;
    }
}
