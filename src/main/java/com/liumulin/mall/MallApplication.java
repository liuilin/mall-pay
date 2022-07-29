package com.liumulin.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// 配置了 MapperScan 包，dao 层的 mapper 就不需要 @Mapper 注解了
@MapperScan(basePackages = "com.liumulin.mall.dao")
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
