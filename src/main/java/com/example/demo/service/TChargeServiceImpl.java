package com.example.demo.service;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.demo.entity.TCharge;
import com.example.demo.mapper.TChargeMapper;
import com.example.demo.service.TChargeService;
/**
 * ;(t_charge)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-6-29
 */
@Service
public class TChargeServiceImpl implements TChargeService{
    @Autowired
    private TChargeMapper tChargeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param tid 主键
     * @return 实例对象
     */
    public TCharge queryById(Integer tid){
        return tChargeMapper.selectById(tid);
    }

    /**
     * 分页查询
     *
     * @param tCharge 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<TCharge> paginQuery(TCharge tCharge, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<TCharge> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(tCharge.getTnum())){
            queryWrapper.eq(TCharge::getTnum, tCharge.getTnum());
        }
        if(StrUtil.isNotBlank(tCharge.getTypename())){
            queryWrapper.eq(TCharge::getTypename, tCharge.getTypename());
        }
        if(StrUtil.isNotBlank(tCharge.getTTime())){
            queryWrapper.eq(TCharge::getTTime, tCharge.getTTime());
        }
        if(StrUtil.isNotBlank(tCharge.getTDescribe())){
            queryWrapper.eq(TCharge::getTDescribe, tCharge.getTDescribe());
        }
        //2. 执行分页查询
        Page<TCharge> pagin = new Page<>(current , size , true);
        IPage<TCharge> selectResult = tChargeMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param tCharge 实例对象
     * @return 实例对象
     */
    public int insert(TCharge tCharge){
        int num = tChargeMapper.insert(tCharge);
        return num;
    }

    /**
     * 更新数据
     *
     * @param tCharge 实例对象
     * @return 实例对象
     */
    public int update(TCharge tCharge){
        //1. 根据条件动态更新
//        LambdaUpdateChainWrapper<TCharge> chainWrapper = new LambdaUpdateChainWrapper<TCharge>(tChargeMapper);
//        if(StrUtil.isNotBlank(tCharge.getTnum())){
//            chainWrapper.eq(TCharge::getTnum, tCharge.getTnum());
//        }
//        if(StrUtil.isNotBlank(tCharge.getTypename())){
//            chainWrapper.eq(TCharge::getTypename, tCharge.getTypename());
//        }
//        if(StrUtil.isNotBlank(tCharge.getTTime())){
//            chainWrapper.eq(TCharge::getTTime, tCharge.getTTime());
//        }
//        if(StrUtil.isNotBlank(tCharge.getTDescribe())){
//            chainWrapper.eq(TCharge::getTDescribe, tCharge.getTDescribe());
//        }
//        //2. 设置主键，并更新
//        chainWrapper.set(TCharge::getTid, tCharge.getTid());
//        boolean ret = chainWrapper.update();
//        //3. 更新成功了，查询最最对象返回
//        if(ret){
//            return queryById(tCharge.getTid());
//        }else{
//            return tCharge;
//        }
        return tChargeMapper.updateById(tCharge);
    }

    /**
     * 通过主键删除数据
     *
     * @param tid 主键
     * @return 是否成功
     */
    public int deleteById(Integer tid){
        int total = tChargeMapper.deleteById(tid);
        return total ;
    }
}



