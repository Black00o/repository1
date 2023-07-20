package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.demo.entity.TBudget;

/**
 * ;(t_budget)表数据库访问层
 * @author : http://www.chiner.pro
 * @date : 2023-6-29
 */
@Mapper
public interface TBudgetMapper  extends BaseMapper<TBudget>{
    /**
     * 分页查询指定行数据
     *
     * @param page 分页参数
     * @param wrapper 动态查询条件
     * @return 分页对象列表
     */
    IPage<TBudget> selectByPage(IPage<TBudget> page , @Param(Constants.WRAPPER) Wrapper<TBudget> wrapper);
}