package com.kavy.springboot.mybatis.entity;

import java.io.Serializable;
import lombok.Data;
import java.util.Date;
import java.util.List;

/**
*  item
* @author  2020-04-23
*/
@Data
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
    * item_id
    */
    private Integer itemId;

    /**
    * item_name
    */
    private String itemName;

    /**
    * item_image
    */
    private String itemImage;

    /**
    * price
    */
    private Integer price;

    public Item() {
    }

}
