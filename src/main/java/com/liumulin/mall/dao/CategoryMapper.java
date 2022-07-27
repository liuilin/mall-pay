package com.liumulin.mall.dao;

import com.liumulin.mall.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author liuqiang
 * @date 2022/07/27
 */
@Mapper
public interface CategoryMapper {

    /**
     * find goods category by id
     *
     * @param id id
     * @return category
     */
    @Select("select * from mall_category where id = #{id}")
    Category findById(Integer id);

}
