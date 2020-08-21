package com.future.mall.member.dao;

import com.future.mall.member.entity.UmsMemberLoginLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员登录记录
 * 
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-20 19:22:27
 */
@Mapper
public interface UmsMemberLoginLogDao extends BaseMapper<UmsMemberLoginLogEntity> {
	
}
