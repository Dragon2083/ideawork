package com.example.lagyuihotle.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * hoteldata
 * @author 
 */
@Data
public class Hoteldata implements Serializable {
    private Integer id;

    private String phone;

    private String about;

    private Double single;

    private Double two;

    private Double three;

    private static final long serialVersionUID = 1L;
}