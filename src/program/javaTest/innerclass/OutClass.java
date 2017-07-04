package program.javaTest.innerclass;

/**
 * Created by wdfwolf3 on 2017/6/24.
 */
public class OutClass {
    private int number = 0;
    private InnerClass innerClass = new InnerClass();

    public OutClass(int number) {
        this.number = number;
        System.out.println("out");
    }

    public OutClass() {
        System.out.println("outDefault");
    }

    public class InnerClass{
        public InnerClass() {
            System.out.println("inner");
        }

        public void prin(){
            number = 10;
            System.out.println(number);
        }
    }
}

class OutClassImpl extends OutClass{
    public OutClassImpl() {
        System.out.println("outImpl");
    }

    public class InnerClassImpl extends OutClass.InnerClass{
        public InnerClassImpl() {
            System.out.println("innerImpl");
        }
    }

}
