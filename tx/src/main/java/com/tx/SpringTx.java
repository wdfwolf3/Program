package com.tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTx {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TransferAccountService service = (TransferAccountService) context.getBean("transferAccountService");
        service.transfer();
    }
}
