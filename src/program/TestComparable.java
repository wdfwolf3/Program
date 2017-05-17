package program;

/**
 * Created by wdfwolf3 on 2017/2/16.
 */
public class TestComparable implements Comparable<TestComparable>{
    private int age;

    public TestComparable(int age){
        this.age = age;
    }

    @Override
    public int compareTo(TestComparable testComparable){
        if (this.age < testComparable.age)        //由高到低排序
            return 1;
        else
            return -1;
    }

    public String toString(){
        return this.age+" ";
    }
}
