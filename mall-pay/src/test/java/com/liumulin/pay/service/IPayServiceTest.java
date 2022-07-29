package com.liumulin.pay.service;

import cn.hutool.core.lang.Snowflake;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Daniel Liu
 * @date 2022-07-30
 */
@SpringBootTest
class IPayServiceTest {

    @Autowired
    private IPayService payService;

    @Test
    void nativePay() {
        payService.nativePay(new Snowflake().nextIdStr(), new BigDecimal("1"));
    }
}