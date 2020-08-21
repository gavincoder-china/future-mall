package com.future.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.future.mall.common.utils.PageUtils;
import com.future.mall.product.entity.PmsAttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-21 08:35:58
 */
public interface PmsAttrGroupService extends IService<PmsAttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

