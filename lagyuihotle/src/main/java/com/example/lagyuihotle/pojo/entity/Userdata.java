package com.example.lagyuihotle.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * userdata
 * @author 
 */
@Data
public class Userdata implements Serializable {
    private String idcard;

    /**
     * 用户
     */
    private String uname;

    private String phone;

    private String psw;

    private Integer category;

    private static final long serialVersionUID = 1L;
}