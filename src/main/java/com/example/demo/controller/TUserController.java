package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import com.example.demo.entity.ResponseTool;
import com.example.demo.entity.ResultDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.TUser;
import com.example.demo.service.TUserService;


/**
 * ;(t_user)表控制层
 * @author : http://www.chiner.pro
 * @date : 2023-6-28
 */
@Api(tags = "对象功能接口")
@CrossOrigin
@RestController
@RequestMapping("/tUser")
public class TUserController{
    @Autowired
    private TUserService tUserService;

    /**
     * 通过ID查询单条数据
     *
     * @param uid 主键
     * @return 实例对象
     */
    @ApiOperation("通过ID查询单条数据")
    @GetMapping("/chaxun/{uid}")
    public ResponseEntity<TUser> queryById(@PathVariable Integer uid){
        return ResponseEntity.ok(tUserService.queryById(uid));
    }

    /**
     * 分页查询
     *
     * @param tUser 筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
//    @ApiOperation("分页查询")
//    @GetMapping("/fenye")
//    public ResponseEntity<PageImpl<TUser>> paginQuery(TUser tUser, PageRequest pageRequest){
//        //1.分页参数
//        long current = pageRequest.getPageNumber();
//        long size = pageRequest.getPageSize();
//        //2.分页查询
//        /*把Mybatis的分页对象做封装转换，MP的分页对象上有一些SQL敏感信息，还是通过spring的分页模型来封装数据吧*/
//        com.baomidou.mybatisplus.extension.plugins.pagination.Page<TUser> pageResult = tUserService.paginQuery(tUser, current,size);
//        //3. 分页结果组装
//        List<TUser> dataList = pageResult.getRecords();
//        long total = pageResult.getTotal();
//        PageImpl<TUser> retPage = new PageImpl<TUser>(dataList,pageRequest,total);
//        return ResponseEntity.ok(retPage);
//    }

   /**
     * 提交注册
     * @return
             */
    @PostMapping("/register")
    public ResultDto register(@RequestBody TUser tUser) {

        TUser selectUser = tUserService.queryByUsername(tUser.getUsername());
        if( null != selectUser) {
            return ResponseTool.buildFail(601 , "注册失败，此用户已存在!" , null );
        }

        int num =  tUserService.insert(tUser);

        return new ResultDto(200 , "注册成功!" ,num);
    }

    /**
     * 用户名唯一检测
     * @param userName
     * @return
     */
//    @GetMapping("/checkUser/{userName}")
//    public ResultDto checkUserName(@PathVariable String userName) {
//        if( userName.equals("admin") ) {
//            return ResponseTool.buildFail(601 , "注册失败，此用户已存在!" , null );
//        } else {
//            return ResponseTool.buildSuccess(user);
//        }
//    }






    /**
     * 新增数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
//    @ApiOperation("新增数据")
//    @PostMapping("/add")
//    public  ResponseEntity add(@RequestBody TUser tUser){
//        return ResponseEntity.ok(tUserService.insert(tUser));
//    }
//
////    @ApiOperation("新增数据")
////    @PostMapping("/add")
////    public ResponseEntity<TUser> add(@RequestBody TUser tUser) {
////        TUser insertedUser = tUserService.insert(tUser);
////        return ResponseEntity.ok(insertedUser);
////    }




    /**
     * 更新数据
     *
     * @param tUser 实例对象
     * @return 实例对象
     */
    @ApiOperation("更新数据")
    @PutMapping("/update")
    public ResultDto edit(@RequestBody TUser tUser){
        int num = tUserService.update(tUser);
        if(num>0){
            return new ResultDto(200 , "更新数据成功!" ,num);
        }else{
            return ResponseTool.buildFail(601 , "更新数据失败" , null );
        }
    }

    /**
     * 通过主键删除数据
     *
     * @param uid 主键
     * @return 是否成功
     */
    @ApiOperation("通过主键删除数据")
    @DeleteMapping("/shanchu/{uid}")
    public ResultDto deleteById(@PathVariable Integer uid){
        int num = tUserService.deleteById(uid);
        if(num>0){
            return new ResultDto(200 , "删除数据成功!" ,num);
        }else{
            return ResponseTool.buildFail(601 , "删除数据失败" , null );
        }
//        return ResponseEntity.ok(tUserService.deleteById(uid));
    }

    @PostMapping("/login")
    public ResultDto login(@RequestParam String username,@RequestParam String pwd){
        TUser user = new TUser();
        user = tUserService.queryByUsername(username);
        if (username.equals(user.getUsername()) && pwd.equals(user.getPwd())){
            return new ResultDto(200 , "登录成功!" ,user);
        }else{
            return ResponseTool.buildFail(601 , "登录失败" , null );
        }
    }

    @PutMapping("/modify/pwd")
    public ResultDto modify(@RequestParam String username,@RequestParam String oldPwd,@RequestParam String newPwd){
        TUser user = new TUser();
        user = tUserService.queryByUsername(username);
        if(user.getPwd().equals(oldPwd)){
            user.setPwd(newPwd);
            tUserService.update(user);
            return new ResultDto(200 , "修改密码成功!" ,user);
        }else{
            return ResponseTool.buildFail(601 , "密码与旧密码不同，修改密码失败" , null );
        }

    }

}
