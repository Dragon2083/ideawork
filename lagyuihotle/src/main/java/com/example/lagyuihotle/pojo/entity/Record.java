package com.example.lagyuihotle.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * record
 * @author 
 */
@Data
public class Record implements Serializable {
    /**
     * id
     */
    private Integer id;

    private Integer cid;

    private String rphone;

    /**
     * 顾客姓名
     */
    private String cname;

    /**
     * 入住房号
     */
    private Integer rnumber;

    private Double price;

    /**
     * 入住时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkindate;

    /**
     * 退房时间
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkoutdate;

    private Integer checkin;

    private Integer useable;

    private String ordernumber;

    private static final long serialVersionUID = 1L;
}