package com.liumulin.mall.pojo;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class Category {

    private Integer id;

    private Integer parentId;

    private String name;

    private Integer status;

    private Integer sortOrder;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;
}