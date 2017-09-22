package com.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

//@Transactional
public class TransferAccountService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void transfer() {
        String sql1 = "update bank set rmb=rmb-500 where id=1 ";
        String sql2 = "update bank set rmb=rmb+500 where id=2 ";
        jdbcTemplate.update(sql1);
        jdbcTemplate.update(sql2);
    }
}
