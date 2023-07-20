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
@TableName("t_budget")
public class TBudget implements Serializable,Cloneable{
    /** 主键id */
    @ApiModelProperty(name = "主键id",notes = "")
    @TableId
    private Integer bid ;
    /** 外键记录用户id */
    @ApiModelProperty(name = "外键记录用户id",notes = "")
    private Integer uid ;
    /** 编号 */
    @ApiModelProperty(name = "编号",notes = "")
    private String bnum ;
    /** 金额 */
    @ApiModelProperty(name = "金额",notes = "")
    private Integer account ;
    /** 月份 */
    @ApiModelProperty(name = "月份",notes = "")
    private String bTime ;
    /** 备注 */
    @ApiModelProperty(name = "备注",notes = "")
    private String bDescribe ;

    /** 主键id */
    public Integer getBid(){
        return this.bid;
    }
    /** 主键id */
    public void setBid(Integer bid){
        this.bid=bid;
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
    public String getBnum(){
        return this.bnum;
    }
    /** 编号 */
    public void setBnum(String bnum){
        this.bnum=bnum;
    }
    /** 金额 */
    public Integer getAccount(){
        return this.account;
    }
    /** 金额 */
    public void setAccount(Integer account){
        this.account=account;
    }
    /** 月份 */
    public String getBTime(){
        return this.bTime;
    }
    /** 月份 */
    public void setBTime(String bTime){
        this.bTime=bTime;
    }
    /** 备注 */
    public String getBDescribe(){
        return this.bDescribe;
    }
    /** 备注 */
    public void setBDescribe(String bDescribe){
        this.bDescribe=bDescribe;
    }
}