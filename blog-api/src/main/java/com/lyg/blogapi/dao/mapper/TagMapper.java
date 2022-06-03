package com.lyg.blogapi.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lyg.blogapi.dao.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/4/16 10:12
 */

@Mapper
public interface TagMapper extends BaseMapper<Tag> {
    
    /**
     * 根据文章id查询标签列表
     *
     * mybatis-plus不提供多表查询，所以只能用mtbatis写sql
     * @param articleId
     * @return
     */


    List<Tag> findTagsByArticleId(Long articleId);

    /**
     * 查询最热标签.前n条
     * @param limit
     * @return
     */
    List<Long> findHotsTagIds(int limit);


    List<Tag> findTagsByTagIds(List<Long> tagIds);
}
