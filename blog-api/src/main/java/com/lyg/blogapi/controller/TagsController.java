package com.lyg.blogapi.controller;

import com.lyg.blogapi.service.TagService;
import com.lyg.blogapi.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/2 17:36
 */

@RestController
//路径映射
@RequestMapping("tags")
public class TagsController {


    @Autowired
    private TagService tagService;


    @GetMapping("hot")
    private Result hot(){

        //int a=10/0;
        //最热标签不可能只有查询全部，所以设置成只显示6个最热标签
        int limit=6;
        return tagService.hots(limit);
    }

    @GetMapping
    public Result findAll(){
        return tagService.findAll();
    }

    @GetMapping("detail")
    public Result findAllDetail(){
        return tagService.findAllDetail();
    }

    @GetMapping("detail/{id}")
    public Result findDetailById(@PathVariable("id") Long id){
        return tagService.findDetailById(id);
    }
}
