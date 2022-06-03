package com.lyg.admin.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lyg.admin.mapper.PermissionMapper;
import com.lyg.admin.model.params.PageParam;
import com.lyg.admin.pojo.Permission;
import com.lyg.admin.vo.PageResult;
import com.lyg.admin.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 林有光
 * @version 1.0
 * @date 2022/5/5 20:13
 */


@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    //这里没有用接口的也可以，因为接口是为了更多的实现
    public Result listPermission(PageParam pageParam) {
        /**
         * 要的数据，管理台，表的所有字段 Permission
         */
       /* Page<Permission> page=new Page<>(pageParam.getCurrentPage(), pageParam.getPageSize());
        LambdaQueryWrapper lambdaQueryWrapper=new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageParam.getQueryString())){
            lambdaQueryWrapper.eq(Permission::getName,pageParam.getQueryString());
        }
        Page page1 = permissionMapper.selectPage(page, lambdaQueryWrapper);

        return PageResult;*/

        Page<Permission> page = new Page<>(pageParam.getCurrentPage(),pageParam.getPageSize());
        LambdaQueryWrapper<Permission> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(pageParam.getQueryString())){
            queryWrapper.eq(Permission::getName,pageParam.getQueryString());
        }
        Page<Permission> permissionPage = permissionMapper.selectPage(page, queryWrapper);
        PageResult<Permission> pageResult = new PageResult<>();
        pageResult.setList(permissionPage.getRecords());
        pageResult.setTotal(permissionPage.getTotal());
        return Result.success(pageResult);


    }

    public Result add(Permission permission) {
        this.permissionMapper.insert(permission);
        return Result.success(null);
    }

    public Result update(Permission permission) {
        this.permissionMapper.updateById(permission);
        return Result.success(null);
    }

    public Result delete(Long id) {
        this.permissionMapper.deleteById(id);
        return Result.success(null);
    }
}
