package com.redis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisSpring {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RedisTemplate template = (RedisTemplate) context.getBean("redisTemplate");
        ListOperations<String, String> listOps = template.opsForList();
        listOps.leftPush("site-list", "Baidu");
        // or use template directly
//        System.out.println(listOps.leftPop("site-list"));
        template.boundListOps("site-list").leftPush("Alibaba");
        for (String s : listOps.range("site-list", 0, 4)) {
            System.out.println(s);
        }
    }
}
