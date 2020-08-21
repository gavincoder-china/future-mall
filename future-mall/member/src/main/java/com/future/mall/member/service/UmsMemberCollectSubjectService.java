package com.future.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.future.mall.common.utils.PageUtils;
import com.future.mall.member.entity.UmsMemberCollectSubjectEntity;

import java.util.Map;

/**
 * 会员收藏的专题活动
 *
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-20 19:22:27
 */
public interface UmsMemberCollectSubjectService extends IService<UmsMemberCollectSubjectEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

