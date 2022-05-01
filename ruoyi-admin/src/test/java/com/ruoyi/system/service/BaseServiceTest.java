package com.ruoyi.system.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Gavin Li
 * @version 1.0
 * @date 2020-10-21 15:49
 * @desc
 */
@SpringBootTest
public class BaseServiceTest {
    @BeforeEach
    public void init() {
        System.out.println("开始测试-----------------");
    }

    @AfterEach
    public void after() {
        System.out.println("测试结束-----------------");
    }
}
