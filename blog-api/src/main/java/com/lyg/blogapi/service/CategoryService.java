package com.lyg.blogapi.service;

import com.lyg.blogapi.vo.CategoryVo;
import com.lyg.blogapi.vo.Result;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/2 21:46
 */
public interface CategoryService {

    CategoryVo findCategory(Long categoryId);

    Result findAll();

    Result findAllDetail();

    /**
     * 分类文章列表
     * @param id
     * @return
     */
    Result categoriesDetailById(Long id);
}
