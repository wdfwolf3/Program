package program.offer;

public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if(rows==1 && cols==1)
            return str.length==1&&matrix[0]==str[0];
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i] == str[0] && help(matrix, rows, cols, str, i,0))
                return true;
        }
        return false;
    }

    public boolean help(char[] matrix, int rows, int cols, char[] str, int m, int index) {
        if (index == str.length)
            return true;
        if (matrix[m] != str[index])
            return false;
        char tmp = matrix[m];
        matrix[m] = '1';
        if (m>=cols && help(matrix, rows, cols, str, m-cols, index+1))
            return true;
        if (m%cols>0 && help(matrix, rows, cols, str, m-1, index+1))
            return true;
        if (m%cols<(cols-1) && help(matrix, rows, cols, str, m+1, index+1))
            return true;
        if (m<(rows-1)*cols && help(matrix, rows, cols, str, m+cols, index+1))
            return true;
        matrix[m] = tmp;
        return false;
    }

    public static void main(String[] args) {
        char[] chars = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
        char[] chars1 = "SGGFIECVAASABCEHJIGQEMS".toCharArray();
        System.out.println(new HasPath().hasPath(chars, 5, 8,chars1 ));
    }
}
