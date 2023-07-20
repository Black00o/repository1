package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.TBudget;

/**
 * ;(t_budget)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-6-29
 */
public interface TBudgetService{

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    TBudget queryById(Integer bid);

    /**
     * 分页查询
     *
     * @param tBudget 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<TBudget> paginQuery(TBudget tBudget, long current, long size);
    /**
     * 新增数据
     *
     * @param tBudget 实例对象
     * @return 实例对象
     */
    int insert(TBudget tBudget);
    /**
     * 更新数据
     *
     * @param tBudget 实例对象
     * @return 实例对象
     */
    int update(TBudget tBudget);
    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 是否成功
     */
    int deleteById(Integer bid);
}