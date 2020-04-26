package com.kavy.springboot.mybatis.controller;

import com.kavy.springboot.mybatis.entity.Item;
import com.kavy.springboot.mybatis.service.ItemService;
import com.kavy.springboot.mybatis.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;



/**
* item
* @author  2020-04-23
*/
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
   private ItemService itemService;


    @RequestMapping("/test")
    public ResultJson test(){
        System.out.println("凶");
        return ResultJson.ok("111");
    }

    @RequestMapping("/load/{id}")
    public ResultJson<String> load(@PathVariable Integer id){
        System.out.println(id);
        Item load = itemService.load(id);
        System.out.println(load.toString());
        return ResultJson.ok(load);
    }

    @RequestMapping("/insert")
    public ResultJson<String> insert( Item item){
        item.setItemName("丽丽");
        item.setItemImage("3333");
        item.setPrice(11211);

        itemService.insert(item);
        return ResultJson.success();
    }
}
