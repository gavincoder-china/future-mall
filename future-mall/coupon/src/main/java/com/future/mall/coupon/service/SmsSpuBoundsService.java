package com.future.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.future.mall.common.utils.PageUtils;
import com.future.mall.coupon.entity.SmsSpuBoundsEntity;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-21 08:31:16
 */
public interface SmsSpuBoundsService extends IService<SmsSpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

