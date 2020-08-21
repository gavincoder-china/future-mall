package com.future.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.future.mall.common.utils.PageUtils;
import com.future.mall.member.entity.UmsGrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-20 19:22:27
 */
public interface UmsGrowthChangeHistoryService extends IService<UmsGrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

