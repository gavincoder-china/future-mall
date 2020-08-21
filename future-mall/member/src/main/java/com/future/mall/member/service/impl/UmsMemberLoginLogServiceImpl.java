package com.future.mall.member.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.future.mall.common.utils.PageUtils;
import com.future.mall.common.utils.Query;

import com.future.mall.member.dao.UmsMemberLoginLogDao;
import com.future.mall.member.entity.UmsMemberLoginLogEntity;
import com.future.mall.member.service.UmsMemberLoginLogService;


@Service("umsMemberLoginLogService")
public class UmsMemberLoginLogServiceImpl extends ServiceImpl<UmsMemberLoginLogDao, UmsMemberLoginLogEntity> implements UmsMemberLoginLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<UmsMemberLoginLogEntity> page = this.page(
                new Query<UmsMemberLoginLogEntity>().getPage(params),
                new QueryWrapper<UmsMemberLoginLogEntity>()
        );

        return new PageUtils(page);
    }

}