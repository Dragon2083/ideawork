package com.example.lagyuihotle.pojo.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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

    /**
     * 顾客姓名
     */
    private String cname;

    /**
     * 入住房号
     */
    private Integer rnumber;

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

    private Integer useable;

    private static final long serialVersionUID = 1L;
}