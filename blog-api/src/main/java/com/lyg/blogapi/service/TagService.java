package com.lyg.blogapi.service;

import com.lyg.blogapi.vo.Result;
import com.lyg.blogapi.vo.TagVo;

import java.util.List;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/2 17:38
 */
public interface TagService {

    List<TagVo> findTagsByArticleId(Long articleId);

    Result hots(int limit);

    /**
     * 查询所有的文章标签
     * @return
     */
    Result findAll();

    Result findAllDetail();

    /**
     * 标签文章列表
     * @param id
     * @return
     */
    Result findDetailById(Long id);
}
