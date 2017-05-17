package program.jingdong;

/**
 * Created by wdfwolf3 on 2017/4/7.
 */

public class Test1 {
    public static void main(String[] args) {
//        String s = "^(1[0-1]|0[0-9]){1}(:[0-5][0-9]){1}(:[0-5][0-9]){0,1}[aA][mM]$";
//        String spm = "^(1[0-2]|0[1-9]){1}(:[0-5][0-9]){1}(:[0-5][0-9]){0,1}[pP][mM]$";
//        String s24 = "^(2[0-3]|1[0-9]|0[0-9]){1}(:[0-5][0-9]){1}(:[0-5][0-9]){0,1}$";
//
//        String he = "^((1[0-1]|0[0-9]){1}(:[0-5][0-9]){1}(:[0-5][0-9]){0,1}[aA][mM])|" +
//                "((1[0-2]|0[1-9]){1}(:[0-5][0-9]){1}(:[0-5][0-9]){0,1}[pP][mM])|" +
//                "((2[0-3]|1[0-9]|0[0-9]){1}(:[0-5][0-9]){1}(:[0-5][0-9]){0,1})$";
//
////        Pattern pattern = Pattern.compile(s);
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()){
//            String str = sc.next();
//            System.out.println(Pattern.matches(he, str));
//        }
        int i=5,j=1;
        System.out.println(i+j+"dd"+i+j);
        try{
            test("100","abc");
            test("5","0");
        }catch (Exception e){
            System.out.println("E");
        }

    }

    public static int test(String s, String t) throws Exception{
        int i,m=-1,j;
        try{
            i=Integer.parseInt(s);
            j=Integer.parseInt(t);
            m=i/j;
        }catch (NumberFormatException e){
            System.out.println("N");
        }catch (ArithmeticException e){
            System.out.println("A");
            throw new Exception("iidf");
        }finally {
            {
                System.out.println("F");
            }
        }
        return m;
    }

}
