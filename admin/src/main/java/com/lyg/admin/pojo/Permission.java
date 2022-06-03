package com.lyg.admin.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/5 20:20
 */
@Data
public class Permission {


//    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

    private String path;

    private String description;
}
