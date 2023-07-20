package com.example.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

/**
 * ;
 * @author : http://www.chiner.pro
 * @date : 2023-6-28
 */
@ApiModel(value = "",description = "")
@TableName("t_user")
public class TUser implements Serializable,Cloneable{
    /** 主键id */
    @ApiModelProperty(name = "主键id",notes = "")
    @TableId
    private Integer uid ;
    /** 账号 */
    @ApiModelProperty(name = "账号",notes = "")
    private String username ;
    /** 密码 */
    @ApiModelProperty(name = "密码",notes = "")
    private String pwd ;
    /** 手机号 */
    @ApiModelProperty(name = "手机号",notes = "")
    private String phone ;
    /** 创建时间 */
    @ApiModelProperty(name = "创建时间",notes = "")
    private String uCreatetime ;
    /** 昵称 */
    @ApiModelProperty(name = "昵称",notes = "")
    private String nickname ;
    /** 性别 */
    @ApiModelProperty(name = "性别",notes = "")
    private String sex ;
    /** 个人描述 */
    @ApiModelProperty(name = "个人描述",notes = "")
    private String uDescribe ;

    /** 主键id */
    public Integer getUid(){
        return this.uid;
    }
    /** 主键id */
    public void setUid(Integer uid){
        this.uid=uid;
    }
    /** 账号 */
    public String getUsername(){
        return this.username;
    }
    /** 账号 */
    public void setUsername(String username){
        this.username=username;
    }
    /** 密码 */
    public String getPwd(){
        return this.pwd;
    }
    /** 密码 */
    public void setPwd(String pwd){
        this.pwd=pwd;
    }
    /** 手机号 */
    public String getPhone(){
        return this.phone;
    }
    /** 手机号 */
    public void setPhone(String phone){
        this.phone=phone;
    }
    /** 创建时间 */
    public String getUCreatetime(){
        return this.uCreatetime;
    }
    /** 创建时间 */
    public void setUCreatetime(String uCreatetime){
        this.uCreatetime=uCreatetime;
    }
    /** 昵称 */
    public String getNickname(){
        return this.nickname;
    }
    /** 昵称 */
    public void setNickname(String nickname){
        this.nickname=nickname;
    }
    /** 性别 */
    public String getSex(){
        return this.sex;
    }
    /** 性别 */
    public void setSex(String sex){
        this.sex=sex;
    }
    /** 个人描述 */
    public String getUDescribe(){
        return this.uDescribe;
    }
    /** 个人描述 */
    public void setUDescribe(String uDescribe){
        this.uDescribe=uDescribe;
    }
}