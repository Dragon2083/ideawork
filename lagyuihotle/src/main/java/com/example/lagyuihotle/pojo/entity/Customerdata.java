package com.example.lagyuihotle.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * customerdata
 * @author 
 */
@Data
public class Customerdata implements Serializable {
    /**
     * 顾客
     */
    private Integer cid;

    /**
     * 顾客账号
     */
    private String account;

    /**
     * 顾客密码
     */
    private String cpsw;

    /**
     * 顾客的姓名
     */
    private String cname;

    /**
     * 性别
     */
    private String gender;

    /**
     * 注册日期
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date registerdate;

    /**
     * 顾客手机号
     */
    private String cphone;

    private static final long serialVersionUID = 1L;
}