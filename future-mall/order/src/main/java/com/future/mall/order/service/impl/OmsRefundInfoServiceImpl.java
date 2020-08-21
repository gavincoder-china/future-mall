package com.future.mall.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.future.mall.common.utils.PageUtils;
import com.future.mall.common.utils.Query;

import com.future.mall.order.dao.OmsRefundInfoDao;
import com.future.mall.order.entity.OmsRefundInfoEntity;
import com.future.mall.order.service.OmsRefundInfoService;


@Service("omsRefundInfoService")
public class OmsRefundInfoServiceImpl extends ServiceImpl<OmsRefundInfoDao, OmsRefundInfoEntity> implements OmsRefundInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OmsRefundInfoEntity> page = this.page(
                new Query<OmsRefundInfoEntity>().getPage(params),
                new QueryWrapper<OmsRefundInfoEntity>()
        );

        return new PageUtils(page);
    }

}