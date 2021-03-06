package com.lyg.blogapi.vo.params;

import com.lyg.blogapi.vo.CategoryVo;
import com.lyg.blogapi.vo.TagVo;
import lombok.Data;

import java.util.List;

@Data
public class ArticleParam {

    private Long id;

    private ArticleBodyParam body;

    private CategoryVo category;

    private String summary;

    private List<TagVo> tags;

    private String title;
}
