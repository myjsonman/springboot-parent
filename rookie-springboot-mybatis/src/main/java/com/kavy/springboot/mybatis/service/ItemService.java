package com.kavy.springboot.mybatis.service;

import com.kavy.springboot.mybatis.entity.Item;
import com.kavy.springboot.mybatis.utils.ResultJson;

import java.util.List;

public interface ItemService {




    /**
     * 根据主键 id 查询
     */
    public Item load(Integer itemId);


    /**
     * 增删改
     * @param item
     * @return
     */
    public void addItem(Item item);

    public void  updateItemById(Item item);

    public Item selectItemById(Integer itemId);

    List<Item> selectItemList();

    Item getItemByItemIdAndItemName(Integer itemId,String itemName);

    public void deleteItemById(Integer itemId);
}
