package com.kavy.springboot.mybatis.dao;
import com.kavy.springboot.mybatis.entity.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
*  item
* @author  2020-04-23
*/
@Mapper
public interface ItemMapper  {



    Item load(Integer itemId);

    /**
     *  增删改查
     * @param item
     */
    void addItem(Item item);

    void updateItemById(Item item);

    Item selectItemById(Integer itemId);

    List<Item> selectItemList();
    // 必须用@Param 明确指定封装参数
    Item getItemByItemIdAndItemName(@Param("itemId") Integer itemId,@Param("itemName") String itemName);

    void deleteItemById(Integer itemId);
}
