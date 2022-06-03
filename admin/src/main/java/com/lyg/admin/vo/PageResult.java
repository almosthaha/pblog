package com.lyg.admin.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/5 20:22
 */
@Data
public class PageResult<T> {
    private List<T> list;

    private Long total;
}
