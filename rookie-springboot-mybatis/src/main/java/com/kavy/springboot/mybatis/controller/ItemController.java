package com.kavy.springboot.mybatis.controller;

import com.kavy.springboot.mybatis.entity.Item;
import com.kavy.springboot.mybatis.service.ItemService;
import com.kavy.springboot.mybatis.utils.ResultCode;
import com.kavy.springboot.mybatis.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
* item
* @author  2020-04-23
*/
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
   private ItemService itemService;


    /**
     * 测试
     * @return
     */
    @RequestMapping("/test")
    public ResultJson test(){
        System.out.println("hello world!");
        return ResultJson.ok("111");
    }

    @RequestMapping("/load/{id}")
    public ResultJson<String> load(@PathVariable Integer id){
        System.out.println(id);
        Item load = itemService.load(id);
        System.out.println(load.toString());
        return ResultJson.ok(load);
    }


    /**
     * 增删改查
     */
    @RequestMapping("/addItem")
    public ResultJson<String> addItem(){
        Item item = new Item();
        item.setItemImage("12324");
        item.setItemName("李白");
        item.setPrice(1243);
        itemService.addItem(item);
        return ResultJson.ok("添加成功！");
    }

    @RequestMapping("/updateItemById/{itemId}")
    public ResultJson<String> updateItemById(@PathVariable Integer itemId){
        Item item = itemService.selectItemById(itemId);
        if (item!= null){

            item.setItemImage("4444424");
            item.setItemName("xiao");
            item.setPrice(122243);
            itemService.updateItemById(item);
        }

        return ResultJson.ok("修改成功！");
    }

    @RequestMapping("/selectItemById/{itemId}")
    public ResultJson<String> selectItemById(@PathVariable Integer itemId){
        Item item = itemService.selectItemById(itemId);
        if (item!= null){

           return ResultJson.ok(item);
        }else {

            return ResultJson.failure(ResultCode.NOT_FOUND);
        }

    }

    @RequestMapping("/selectItemList")
    public ResultJson<String> selectItemList(){
        List<Item> items = itemService.selectItemList();
        if (items!= null){

           return ResultJson.ok(items);
        }else {

            return ResultJson.failure(ResultCode.NOT_FOUND);
        }

    }

    @RequestMapping("/getItemByItemIdAndItemName/{itemId}/{itemName}")
    public ResultJson<String> getItemByItemIdAndItemName(@PathVariable Integer itemId,@PathVariable String itemName){
        Item itemByItemIdAndItemName = itemService.getItemByItemIdAndItemName(itemId, itemName);
        if (itemByItemIdAndItemName!= null){

            return ResultJson.ok(itemByItemIdAndItemName);
        }else {

            return ResultJson.failure(ResultCode.NOT_FOUND);
        }

    }

    @RequestMapping("/deleteItemById/{itemId}")
    public ResultJson<String> deleteItemById(@PathVariable Integer itemId){
        itemService.deleteItemById(itemId);
        return ResultJson.success();
    }

}
