package com.future.mall.coupon.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.future.mall.common.utils.PageUtils;
import com.future.mall.common.utils.Query;

import com.future.mall.coupon.dao.SmsCouponDao;
import com.future.mall.coupon.entity.SmsCouponEntity;
import com.future.mall.coupon.service.SmsCouponService;


@Service("smsCouponService")
public class SmsCouponServiceImpl extends ServiceImpl<SmsCouponDao, SmsCouponEntity> implements SmsCouponService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsCouponEntity> page = this.page(
                new Query<SmsCouponEntity>().getPage(params),
                new QueryWrapper<SmsCouponEntity>()
        );

        return new PageUtils(page);
    }

}