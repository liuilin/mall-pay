package com.liumulin.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 配置了 MapperScan 包，dao 层的 mapper 就不需要 @Mapper 注解了
@MapperScan(basePackages = "com.liumulin.mall.dao")
public class MallPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallPayApplication.class, args);
    }

}
