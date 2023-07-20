package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.TUser;

/**
 * ;(t_user)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-6-28
 */
public interface TUserService{

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    TUser queryById(Integer uid);
    TUser queryByUsername(String username);
    TUser queryByUid(Integer uid);

    /**
     * 分页查询
     *
     * @param tUser 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<TUser> paginQuery(TUser tUser, long current, long size);
    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    int insert(TUser tUser);
    /**
     * 更新数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    int update(TUser tUser);
    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    int deleteById(Integer uid);
}