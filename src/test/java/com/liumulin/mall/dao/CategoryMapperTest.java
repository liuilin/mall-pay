package com.liumulin.mall.dao;

import com.liumulin.mall.pojo.Category;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Daniel Liu
 * @since 2022-07-27
 */
@Slf4j
@SpringBootTest
public class CategoryMapperTest {

    @Resource
    private CategoryMapper categoryMapper;

    @Test
    void findById() {
        Category category = categoryMapper.findById(100001);
        log.info("category = {}", category);
        Assertions.assertEquals("家用电器", category.getName());
    }
}