package com.future.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品三级分类
 * 
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-21 08:35:58
 */
@Data
@TableName("pms_category")
public class PmsCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Long catId;
	/**
	 * $column.comments
	 */
	private String name;
	/**
	 * $column.comments
	 */
	private Long parentCid;
	/**
	 * $column.comments
	 */
	private Integer catLevel;
	/**
	 * $column.comments
	 */
	private Integer showStatus;
	/**
	 * $column.comments
	 */
	private Integer sort;
	/**
	 * $column.comments
	 */
	private String icon;
	/**
	 * $column.comments
	 */
	private String productUnit;
	/**
	 * $column.comments
	 */
	private Integer productCount;

}
