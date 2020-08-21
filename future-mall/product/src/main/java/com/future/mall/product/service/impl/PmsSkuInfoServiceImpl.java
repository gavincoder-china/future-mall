package com.future.mall.product.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.future.mall.common.utils.PageUtils;
import com.future.mall.common.utils.Query;

import com.future.mall.product.dao.PmsSkuInfoDao;
import com.future.mall.product.entity.PmsSkuInfoEntity;
import com.future.mall.product.service.PmsSkuInfoService;


@Service("pmsSkuInfoService")
public class PmsSkuInfoServiceImpl extends ServiceImpl<PmsSkuInfoDao, PmsSkuInfoEntity> implements PmsSkuInfoService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<PmsSkuInfoEntity> page = this.page(
                new Query<PmsSkuInfoEntity>().getPage(params),
                new QueryWrapper<PmsSkuInfoEntity>()
        );

        return new PageUtils(page);
    }

}