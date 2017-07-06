package program.javaTest.generics;

/**
 * Created by wdfwolf3 on 2017/6/28.
 */
public class Two<T, K> {
    T t;
    K k;

    public Two() {
    }

    public void set(T t, K k){
        this.k = k;
        this.t = t;
    }
}
