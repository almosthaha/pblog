package com.lyg.blogapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyg.blogapi.dao.dos.Archives;
import com.lyg.blogapi.dao.pojo.Article;
import com.lyg.blogapi.dao.dos.Archives;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/4/15 23:12
 */

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Archives> listArchives();

    IPage<Article> listArticle(Page<Article> page,
                               Long categoryId,
                               Long tagId,
                               String year,
                               String month);
}
