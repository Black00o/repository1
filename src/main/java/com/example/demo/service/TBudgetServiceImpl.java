package com.example.demo.service;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.demo.entity.TBudget;
import com.example.demo.mapper.TBudgetMapper;
import com.example.demo.service.TBudgetService;
/**
 * ;(t_budget)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-6-29
 */
@Service
public class TBudgetServiceImpl implements TBudgetService{
    @Autowired
    private TBudgetMapper tBudgetMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    public TBudget queryById(Integer bid){
        return tBudgetMapper.selectById(bid);
    }

    /**
     * 分页查询
     *
     * @param tBudget 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<TBudget> paginQuery(TBudget tBudget, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<TBudget> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(tBudget.getBnum())){
            queryWrapper.eq(TBudget::getBnum, tBudget.getBnum());
        }
        if(StrUtil.isNotBlank(tBudget.getBTime())){
            queryWrapper.eq(TBudget::getBTime, tBudget.getBTime());
        }
        if(StrUtil.isNotBlank(tBudget.getBDescribe())){
            queryWrapper.eq(TBudget::getBDescribe, tBudget.getBDescribe());
        }
        //2. 执行分页查询
        Page<TBudget> pagin = new Page<>(current , size , true);
        IPage<TBudget> selectResult = tBudgetMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param tBudget 实例对象
     * @return 实例对象
     */
    public int insert(TBudget tBudget){
        int num = tBudgetMapper.insert(tBudget);
        return num;
    }

    /**
     * 更新数据
     *
     * @param tBudget 实例对象
     * @return 实例对象
     */
    public int update(TBudget tBudget){
        //1. 根据条件动态更新
//        LambdaUpdateChainWrapper<TBudget> chainWrapper = new LambdaUpdateChainWrapper<TBudget>(tBudgetMapper);
//        if(StrUtil.isNotBlank(tBudget.getBnum())){
//            chainWrapper.eq(TBudget::getBnum, tBudget.getBnum());
//        }
//        if(StrUtil.isNotBlank(tBudget.getBTime())){
//            chainWrapper.eq(TBudget::getBTime, tBudget.getBTime());
//        }
//        if(StrUtil.isNotBlank(tBudget.getBDescribe())){
//            chainWrapper.eq(TBudget::getBDescribe, tBudget.getBDescribe());
//        }
//        //2. 设置主键，并更新
//        chainWrapper.set(TBudget::getBid, tBudget.getBid());
//        boolean ret = chainWrapper.update();
//        //3. 更新成功了，查询最最对象返回
//        if(ret){
//            return queryById(tBudget.getBid());
//        }else{
//            return tBudget;
//        }
        return tBudgetMapper.updateById(tBudget);
    }

    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 是否成功
     */
    public int deleteById(Integer bid){
        int total = tBudgetMapper.deleteById(bid);
        return total;
    }
}