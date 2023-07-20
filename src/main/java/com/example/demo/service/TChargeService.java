package com.example.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.TCharge;

/**
 * ;(t_charge)表服务接口
 * @author : http://www.chiner.pro
 * @date : 2023-6-29
 */
public interface TChargeService{

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    TCharge queryById(Integer tid);

    /**
     * 分页查询
     *
     * @param tCharge 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    Page<TCharge> paginQuery(TCharge tCharge, long current, long size);
    /**
     * 新增数据
     *
     * @param tCharge 实例对象
     * @return 实例对象
     */
    int insert(TCharge tCharge);
    /**
     * 更新数据
     *
     * @param tCharge 实例对象
     * @return 实例对象
     */
    int update(TCharge tCharge);
    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    int deleteById(Integer tid);
}
