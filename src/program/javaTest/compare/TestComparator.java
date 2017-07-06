package program.javaTest.compare;

import java.util.Comparator;

/**
 * Created by wdfwolf3 on 2017/2/16.
 */
public class TestComparator {
    private int age;

    public TestComparator(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }

    public String toString(){
        return age+" ";
    }
}

class TC implements Comparator<TestComparator>{
    @Override
    public int compare(TestComparator testComparator1, TestComparator testComparator2){
        if(testComparator1.getAge() < testComparator2.getAge())
            return 1;
        else
            return -1;
    }
}
