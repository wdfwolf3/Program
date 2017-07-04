package program.javaTest.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wdfwolf3 on 2017/6/15.
 */
public class Soft {
    public static void main(String[] args) {
        Object object = new Object();
        WeakReference<Object> softReference = new WeakReference(object);
        ReferenceQueue referenceQueue = new ReferenceQueue();
        PhantomReference phantomReference = new PhantomReference(object, referenceQueue);
        //永远返回null
        System.out.println(phantomReference.get());
        //查看原对象是否被gc回收
        System.out.println(phantomReference.isEnqueued());
        object = null;
//        System.out.println(phantomReference.isEnqueued());
        System.out.println(softReference.get());
        List<Double[]> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        while (true){
            if ((referenceQueue.poll()) == null){
                Double[] d = new Double[10000];
                list.add(d);
            }else {
                System.out.println(softReference.get());
                break;
            }
        }
        System.out.println(System.currentTimeMillis() - start + "ms被回收");
        if (referenceQueue.poll() instanceof PhantomReference){
            System.out.println(referenceQueue.poll().getClass().getName());
        }

    }
}
