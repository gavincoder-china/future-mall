package com.future.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品属性
 * 
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-21 08:35:58
 */
@Data
@TableName("pms_attr")
public class PmsAttrEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Long attrId;
	/**
	 * $column.comments
	 */
	private String attrName;
	/**
	 * $column.comments
	 */
	private Integer searchType;
	/**
	 * $column.comments
	 */
	private String icon;
	/**
	 * $column.comments
	 */
	private String valueSelect;
	/**
	 * $column.comments
	 */
	private Integer attrType;
	/**
	 * $column.comments
	 */
	private Long enable;
	/**
	 * $column.comments
	 */
	private Long catelogId;
	/**
	 * $column.comments
	 */
	private Integer showDesc;

}
