package com.kavy.rookiespringbootmybatis3.controller;

import com.kavy.rookiespringbootmybatis3.entity.Item;
import com.kavy.rookiespringbootmybatis3.entity.ItemVo;
import com.kavy.rookiespringbootmybatis3.service.ItemService;
import com.kavy.rookiespringbootmybatis3.utils.ResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
   private ItemService itemService;

    /**
     * 添加item
     */
    @PostMapping("/addItem")
    public ResultJson<String> addItem(@RequestBody Item item){
        itemService.addItem(item);
        Integer itemId = item.getItemId();
        System.out.println(itemId);
        return ResultJson.success();
    }

    @DeleteMapping("/deleteItem/{itemId}")
    public ResultJson<String> deleteItem(@PathVariable Integer itemId){
        itemService.deleteItem(itemId);

        return ResultJson.success();
    }

    @PostMapping("/updateItem")
    public ResultJson<String> updateItem(@RequestBody Item item){

        itemService.updateItem(item);

        return ResultJson.success();
    }

    @GetMapping("/queryItemById/{itemId}")
    public ResultJson<Item> queryItemById(@PathVariable Integer itemId){

        Item item = itemService.queryItemById(itemId);

        return ResultJson.ok(item);
    }

    @GetMapping("/queryItemById/{itemId}/{itemName}")
    public ResultJson<Item> queryItemByIdAndName(@PathVariable Integer itemId,@PathVariable String itemName){

        Item item = itemService.queryItemByIdAndName(itemId,itemName);

        return ResultJson.ok(item);
    }

    /**
     * 参数传递
     */
    //pojo传递
    @GetMapping("/queryByItemVo")
    public ResultJson<Item> queryByItemVo(){
        ItemVo itemVo = new ItemVo();
        Item item = new Item();
            item.setItemName("阿斯顿");
        itemVo.setItemVo(item);
        Item itemList = itemService.queryByItemVo(itemVo);

        return ResultJson.ok(itemList);
    }
    //map传递
    @PostMapping("/queryItemByMap")
    public ResultJson<Item> queryItemByMap(@RequestBody Map<String,Object> itemMap){

        Item item = itemService.queryItemByMap(itemMap);

        return ResultJson.ok(item);
    }

    //list传递
    @GetMapping("/queryItemByList")
    public ResultJson<Item> queryItemByList(@RequestParam List<Integer> idsList){

        List<Item> itemList = itemService.queryItemByList(idsList);

        return ResultJson.ok(itemList);
    }
    //list批量删除
    @DeleteMapping("/deleteByIdsList")
    public ResultJson<Item> deleteByIdsList(@RequestParam List<Integer> idsList){

        itemService.deleteByIdsList(idsList);

        return ResultJson.success();
    }

    //批量添加
    @PostMapping("/insertItemList")
    public ResultJson<String> insertItemList(@RequestBody List<Item> item){
        itemService.insertItemList(item);

        return ResultJson.success();
    }


    //批量更新
    //TODO 未完成有bug
    @PostMapping("/updateItemList")
    public ResultJson<String> updateItemList(@RequestParam List<Integer> idsList){

        itemService.updateItemList(idsList);

        return ResultJson.success();
    }

    // 根据pojo模糊查询
    @PostMapping("/queryItemLikeByItemVo")
    public ResultJson<Item> queryItemLikeByItemVo(@RequestBody ItemVo itemVo){

        List<Item> itemList = itemService.queryItemLikeByItemVo(itemVo);


        return ResultJson.ok(itemList);
    }

    /**
     *  模糊查询
     * @param itemName
     * @return
     */
    @GetMapping("/queryItemLikeByName/{itemName}")
    public ResultJson<Item> queryItemLikeByName(@PathVariable String itemName){

        List<Item> itemList = itemService.queryItemLikeByName(itemName);


        return ResultJson.ok(itemList);
    }

    /**
     * 多条记录封装成map返回 Map<String,Item> ：key是这条记录的主键,值是javaBean
     * @param itemName
     * @return
     */
    @GetMapping("/queryMapItem/{itemName}")
    public ResultJson<Item> queryMapItem(@PathVariable String itemName){

        Map<String, Item> stringItemMap = itemService.queryMapItem(itemName);
        System.out.println(stringItemMap);

        return ResultJson.ok(stringItemMap);
    }
}
