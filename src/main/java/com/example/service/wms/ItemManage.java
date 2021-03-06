package com.example.service.wms;

import com.example.entity.basic.ItemInfo;
import com.example.entity.basic.ItemType;

/**
 * 物料，分类管理接口1
 *
 */
public interface ItemManage {
    /**
     *
     * 通过itemCode删除ItemInfo
     * @param itemCode
     * @return
     */
    String deleteItemInfo(String itemCode);


    /**
     * 根据ItemBarCode获取ItemInfo
     * @param itemBarCode
     * @return
     */
   // String queryItemInfoByItemBarCode(String itemBarCode);


    /**
     * 添加ItemInfo
     * @param param
     * @return
     */
    String addItemInfo(String param);

    /**
     *查询ItemInfo列表
     * @param itemInfo
     * @param pageNum
     * @param pageSize
     * @param token
     * @return
     */
    //String queryItemInfoList(String itemInfo, Integer pageNum, Integer pageSize, String token);

    /**
     *
     * 更新ItemInfo
     * @param param
     * @return
     */
    String updateItemInfo(String  param);

    //itemType管理==================================================================================================

    /**
     * 删除物料分类
     * @param itemTypeCode
     * @return
     */
    String deleteItemType(String itemTypeCode);

    /**
     *
     * 新增物料分类
     * @param itemType
     * @return
     */
   // String addItemType(ItemType itemType);

    /**
     * 跟新物料信息
     * @param itemType
     * @return
     */
    String updateItemType(ItemType itemType);

    /**
     * 添加物料主分类
     * @param param
     * @return
     */
    String addMainType(String param);

    /**
     * 添加商品二级分类
     * @param param
     * @return
     */
    String addItemType(String param);

    /***
     * 更新商品二级分类
     * @return
     */
    String updateItemType(String param);




    /**
     * 添加品牌
     * @param param
     * @return
     */
    String addBrand(String param);


    /**
     * 更新品牌信息
     * @param param
     * @return
     */
    String updateBrand(String param);

    /**
     * 查询库存
     * @param param
     * @return
     */
    int queryItemCount(String param);

}
