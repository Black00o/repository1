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
 * @date : 2023-6-29
 */
@ApiModel(value = "",description = "")
@TableName("t_charge")
public class TCharge implements Serializable,Cloneable{
    /** 主键id */
    @ApiModelProperty(name = "主键id",notes = "")
    @TableId
    private Integer tid ;
    /** 外键记录用户id */
    @ApiModelProperty(name = "外键记录用户id",notes = "")
    private Integer uid ;
    /** 编号 */
    @ApiModelProperty(name = "编号",notes = "")
    private String tnum ;
    /** 收支类型 */
    @ApiModelProperty(name = "收支类型",notes = "")
    private Integer type ;
    /** 类型名称 */
    @ApiModelProperty(name = "类型名称",notes = "")
    private String typename ;
    /** 记账时间 */
    @ApiModelProperty(name = "记账时间",notes = "")
    private String tTime ;
    /** 金额 */
    @ApiModelProperty(name = "金额",notes = "")
    private Integer account ;
    /** 备注 */
    @ApiModelProperty(name = "备注",notes = "")
    private String tDescribe ;

    /** 主键id */
    public Integer getTid(){
        return this.tid;
    }
    /** 主键id */
    public void setTid(Integer tid){
        this.tid=tid;
    }
    /** 外键记录用户id */
    public Integer getUid(){
        return this.uid;
    }
    /** 外键记录用户id */
    public void setUid(Integer uid){
        this.uid=uid;
    }
    /** 编号 */
    public String getTnum(){
        return this.tnum;
    }
    /** 编号 */
    public void setTnum(String tnum){
        this.tnum=tnum;
    }
    /** 收支类型 */
    public Integer getType(){
        return this.type;
    }
    /** 收支类型 */
    public void setType(Integer type){
        this.type=type;
    }
    /** 类型名称 */
    public String getTypename(){
        return this.typename;
    }
    /** 类型名称 */
    public void setTypename(String typename){
        this.typename=typename;
    }
    /** 记账时间 */
    public String getTTime(){
        return this.tTime;
    }
    /** 记账时间 */
    public void setTTime(String tTime){
        this.tTime=tTime;
    }
    /** 金额 */
    public Integer getAccount(){
        return this.account;
    }
    /** 金额 */
    public void setAccount(Integer account){
        this.account=account;
    }
    /** 备注 */
    public String getTDescribe(){
        return this.tDescribe;
    }
    /** 备注 */
    public void setTDescribe(String tDescribe){
        this.tDescribe=tDescribe;
    }
}