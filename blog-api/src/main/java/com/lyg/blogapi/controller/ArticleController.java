package com.lyg.blogapi.controller;

import com.lyg.blogapi.common.aop.LogAnnotation;
import com.lyg.blogapi.service.ArticleService;
import com.lyg.blogapi.vo.Result;
import com.lyg.blogapi.vo.params.ArticleParam;
import com.lyg.blogapi.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/2 17:24
 */
@RestController
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 首页 文章列表
     */


    @PostMapping
    //加上此注解 代表要对此接口记录日志
    @LogAnnotation(module="登录",operator="用户登录")
    public Result listArtcle(@RequestBody PageParams pageParms){
        return articleService.listArticle(pageParms);
    }


    /**
     * 首页 最热文章
     */


    @PostMapping("hot")
    public Result hotArtcle(){


        int limit=5;
        return articleService.hotArticle(limit);
    }
    /**
     * 最新文章
     */
    @PostMapping("new")
    public Result newArtcle(){

        int limit=5;
        return articleService.newArticle(limit);
    }

    /**
     * 文章归档(分组查询)
     */

    @PostMapping("view/{id}")
    public Result findArticleById(@PathVariable("id") Long articleId){
        return articleService.findArticleById(articleId);
    }

    @PostMapping("publish")
    public Result publish(@RequestBody ArticleParam articleParam){
        return articleService.publish(articleParam);
    }
}
