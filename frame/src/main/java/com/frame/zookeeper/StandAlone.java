package com.frame.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

public class StandAlone {
    public static void main(String[] args) {
        try {
            ZooKeeper zookeeper = new ZooKeeper("127.0.0.1:2181", 30000, new StandAloneWatcher());
            String node = "/node2";
            Stat stat = zookeeper.exists(node, false);
            if (stat == null) {
                String createResult = zookeeper.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
                System.out.println(createResult);
            }
            byte[] bytes = zookeeper.getData(node, false, stat);
            System.out.println(new String(bytes));
            zookeeper.close();
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class StandAloneWatcher implements Watcher {

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("------------------------------------");
        System.out.println("path" + watchedEvent.getPath());
        System.out.println("path" + watchedEvent.getType());
        System.out.println("path" + watchedEvent.getState());
        System.out.println("------------------------------------");
    }
}