package program.javaTest.generics;

/**
 * Created by wdfwolf3 on 2017/6/28.
 */
public class Generics<T> {
    T t;

    public Generics() {
    }

    public Generics(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
