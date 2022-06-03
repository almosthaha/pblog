package com.lyg.blogapi.service;

import com.lyg.blogapi.vo.Result;
import com.lyg.blogapi.vo.params.ArticleParam;
import com.lyg.blogapi.vo.params.PageParams;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/2 17:25
 */
public interface ArticleService {

    Result listArticle(PageParams pageParms);

    Result hotArticle(int limit);

    Result newArticle(int limit);

    Result listArchives();

    /**
     * 查询文章详情
     * @param articleId
     * @return
     */
    Result findArticleById(Long articleId);

    /**
     * 文章发布服务
     * @return
     */
    Result publish(ArticleParam articleParam);
}
