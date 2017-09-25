package com.frame.dubbo;

public interface DemoService {
    String sayHello(String name);

    User findUserById(long id);
}
