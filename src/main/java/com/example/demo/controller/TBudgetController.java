package com.example.demo.controller;

import java.util.List;

import com.example.demo.entity.ResponseTool;
import com.example.demo.entity.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.TBudget;
import com.example.demo.service.TBudgetService;

/**
 * ;(t_budget)表控制层
 * @author : http://www.chiner.pro
 * @date : 2023-6-29
 */
@Api(tags = "对象功能接口")
@RestController
@CrossOrigin
@RequestMapping("/tBudget")
public class TBudgetController{
    @Autowired
    private TBudgetService tBudgetService;

    /**
     * 通过ID查询单条数据
     *
     * @param bid 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("/chaxun/{bid}")
    public ResponseEntity<TBudget> queryById(@PathVariable Integer bid){
        return ResponseEntity.ok(tBudgetService.queryById(bid));
    }

    /**
     * 分页查询
     *
     * @param tBudget 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
//    @ApiOperation("分页查询")
//    @GetMapping
//    public ResponseEntity<PageImpl<TBudget>> paginQuery(TBudget tBudget, PageRequest pageRequest){
//        //1.分页参数
//        long current = pageRequest.getPageNumber();
//        long size = pageRequest.getPageSize();
//        //2.分页查询
//        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
//        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TBudget> pageResult = tBudgetService.paginQuery(tBudget, current,size);
//        //3. 分页结果组装
//        List<TBudget> dataList = pageResult.getRecords();
//        long total = pageResult.getTotal();
//        PageImpl<TBudget> retPage = new PageImpl<TBudget>(dataList,pageRequest,total);
//        return ResponseEntity.ok(retPage);
//    }

    /**
     * 新增数据
     *
     * @param tBudget 实例对象
     * @return 实例对象
     */
    @ApiOperation("新增数据")
    @PostMapping("/add")
    public ResultDto add(@RequestBody TBudget tBudget){

        int num = tBudgetService.insert(tBudget);
        if(num>0){
            return new ResultDto(200 , "添加数据成功!" ,num);
        }else{
            return ResponseTool.buildFail(601 , "添加数据失败" , null );
        }
//        return ResponseEntity.ok(tBudgetService.insert(tBudget));
    }

    /**
     * 更新数据
     *
     * @param tBudget 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping("/update")
    public ResultDto edit(@RequestBody TBudget tBudget){

        int num = tBudgetService.update(tBudget);
        if(num>0){
            return new ResultDto(200 , "更新数据成功!" ,num);
        }else{
            return ResponseTool.buildFail(601 , "更新数据失败" , null );
        }
//        return ResponseEntity.ok(tBudgetService.update(tBudget));
    }

    /**
     * 通过主键删除数据
     *
     * @param bid 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping("/shanchu/{bid}")
    public ResultDto deleteById(@PathVariable Integer bid){

        int num = tBudgetService.deleteById(bid);
        if(num>0){
            return new ResultDto(200 , "删除数据成功!" ,num);
        }else{
            return ResponseTool.buildFail(601 , "删除数据失败" , null );
        }
    }
//        return ResponseEntity.ok(tBudgetService.deleteById(bid));
    }
