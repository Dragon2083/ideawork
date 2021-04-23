package com.example.lagyuihotle.pojo.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * roomdata
 * @author 
 */
@Data
public class Roomdata implements Serializable {
    private Integer roomid;

    private Integer rname;

    private String rstate;

    private Double rprice;

    private Byte ruseable;

    private Integer rtype;

    private static final long serialVersionUID = 1L;
}