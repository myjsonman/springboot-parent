package com.kavy.rookiespringbootmybatis3.service;

import com.kavy.rookiespringbootmybatis3.entity.Item;
import com.kavy.rookiespringbootmybatis3.entity.ItemVo;

import java.util.List;
import java.util.Map;

public interface ItemService {

     void  addItem(Item item);
     void  deleteItem(Integer itemId);
     void  updateItem(Item item);
     Item queryItemById(Integer itemId);
     Item queryItemByIdAndName(Integer itemId,String itemName);

     //参数传递
     //pojo传递
     Item queryByItemVo(ItemVo itemVo);

     //map传递
     Item queryItemByMap(Map<String,Object> itemMap);

     //List传递
     List<Item> queryItemByList(List<Integer> idsList);
     //list批量删除
     void deleteByIdsList(List<Integer> idsList);
     //批量插入
     void insertItemList(List<Item> itemList);
     //批量更新
     void updateItemList(List<Integer> idsList);

     //模糊查询
     List<Item> queryItemLikeByName(String itemName);
     List<Item> queryItemLikeByItemVo(ItemVo itemVo);

     //封装成一个map,返回
     Map<String,Item> queryMapItem(String itemName);
}
