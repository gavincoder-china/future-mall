package com.future.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.future.mall.common.utils.PageUtils;
import com.future.mall.ware.entity.WmsWareSkuEntity;

import java.util.Map;

/**
 * 商品库存
 *
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-20 19:49:54
 */
public interface WmsWareSkuService extends IService<WmsWareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

