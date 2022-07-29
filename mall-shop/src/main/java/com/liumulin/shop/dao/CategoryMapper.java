package com.liumulin.shop.dao;

import com.liumulin.shop.pojo.Category;
import org.apache.ibatis.annotations.Select;

/**
 * goods category
 *
 * @author Daniel Liu
 * @date 2022-07-28
 */
public interface CategoryMapper {

    /**
     * find goods category by id
     *
     * @param id id
     * @return category
     */
    @Select("select * from mall_category where id = #{id}")
    Category findById(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

}