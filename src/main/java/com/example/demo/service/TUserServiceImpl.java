package com.example.demo.service;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.example.demo.entity.TUser;
import com.example.demo.mapper.TUserMapper;
import com.example.demo.service.TUserService;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ;(t_user)表服务实现类
 * @author : http://www.chiner.pro
 * @date : 2023-6-28
 */
@Service
public class TUserServiceImpl implements TUserService{
    @Autowired
    private TUserMapper tUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    public TUser queryById(Integer uid){
        return tUserMapper.selectById(uid);
    }

    public TUser queryByUid(Integer uid){
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid" , uid);
        List<TUser> list =  tUserMapper.selectList(queryWrapper);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public TUser queryByUsername(String username){
        QueryWrapper<TUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName" , username);
        List<TUser> list =  tUserMapper.selectList(queryWrapper);
        if(CollectionUtils.isEmpty(list)) {
            return null;
        } else {
            return list.get(0);
        }
    }
    /**
     * 分页查询
     *
     * @param tUser 筛选条件
     * @param current 当前页码
     * @param size  每页大小
     * @return
     */
    public Page<TUser> paginQuery(TUser tUser, long current, long size){
        //1. 构建动态查询条件
        LambdaQueryWrapper<TUser> queryWrapper = new LambdaQueryWrapper<>();
        if(StrUtil.isNotBlank(tUser.getUsername())){
            queryWrapper.eq(TUser::getUsername, tUser.getUsername());
        }
        if(StrUtil.isNotBlank(tUser.getPwd())){
            queryWrapper.eq(TUser::getPwd, tUser.getPwd());
        }
        if(StrUtil.isNotBlank(tUser.getPhone())){
            queryWrapper.eq(TUser::getPhone, tUser.getPhone());
        }
        if(StrUtil.isNotBlank(tUser.getUCreatetime())){
            queryWrapper.eq(TUser::getUCreatetime, tUser.getUCreatetime());
        }
        if(StrUtil.isNotBlank(tUser.getNickname())){
            queryWrapper.eq(TUser::getNickname, tUser.getNickname());
        }
        if(StrUtil.isNotBlank(tUser.getSex())){
            queryWrapper.eq(TUser::getSex, tUser.getSex());
        }
        if(StrUtil.isNotBlank(tUser.getUDescribe())){
            queryWrapper.eq(TUser::getUDescribe, tUser.getUDescribe());
        }
        //2. 执行分页查询
        Page<TUser> pagin = new Page<>(current , size , true);
        IPage<TUser> selectResult = tUserMapper.selectByPage(pagin , queryWrapper);
        pagin.setPages(selectResult.getPages());
        pagin.setTotal(selectResult.getTotal());
        pagin.setRecords(selectResult.getRecords());
        //3. 返回结果
        return pagin;
    }

    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    public int insert(TUser tUser){

        return  tUserMapper.insert(tUser);
    }

    /**
     * 更新数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    public int update(TUser tUser){
        //1. 根据条件动态更新
//        LambdaUpdateChainWrapper<TUser> chainWrapper = new LambdaUpdateChainWrapper<TUser>(tUserMapper);
//        if(StrUtil.isNotBlank(tUser.getUsername())){
//            chainWrapper.eq(TUser::getUsername, tUser.getUsername());
//        }
//        if(StrUtil.isNotBlank(tUser.getPwd())){
//            chainWrapper.eq(TUser::getPwd, tUser.getPwd());
//        }
//        if(StrUtil.isNotBlank(tUser.getPhone())){
//            chainWrapper.eq(TUser::getPhone, tUser.getPhone());
//        }
//        if(StrUtil.isNotBlank(tUser.getUCreatetime())){
//            chainWrapper.eq(TUser::getUCreatetime, tUser.getUCreatetime());
//        }
//        if(StrUtil.isNotBlank(tUser.getNickname())){
//            chainWrapper.eq(TUser::getNickname, tUser.getNickname());
//        }
//        if(StrUtil.isNotBlank(tUser.getSex())){
//            chainWrapper.eq(TUser::getSex, tUser.getSex());
//        }
//        if(StrUtil.isNotBlank(tUser.getUDescribe())){
//            chainWrapper.eq(TUser::getUDescribe, tUser.getUDescribe());
//        }
//        //2. 设置主键，并更新
//        chainWrapper.set(TUser::getUid, tUser.getUid());
//        boolean ret = chainWrapper.update();
//        //3. 更新成功了，查询最最对象返回
//        if(ret){
//            return queryById(tUser.getUid());
//        }else{
//            return tUser;
//        }
        return tUserMapper.updateById(tUser);
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    public int deleteById(Integer uid){
        int total = tUserMapper.deleteById(uid);
        return total;
    }
}
