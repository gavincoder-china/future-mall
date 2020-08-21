package com.future.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * sku信息
 * 
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-21 08:35:58
 */
@Data
@TableName("pms_sku_info")
public class PmsSkuInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Long skuId;
	/**
	 * $column.comments
	 */
	private Long spuId;
	/**
	 * $column.comments
	 */
	private String skuName;
	/**
	 * $column.comments
	 */
	private String skuDesc;
	/**
	 * $column.comments
	 */
	private Long catalogId;
	/**
	 * $column.comments
	 */
	private Long brandId;
	/**
	 * $column.comments
	 */
	private String skuDefaultImg;
	/**
	 * $column.comments
	 */
	private String skuTitle;
	/**
	 * $column.comments
	 */
	private String skuSubtitle;
	/**
	 * $column.comments
	 */
	private BigDecimal price;
	/**
	 * $column.comments
	 */
	private Long saleCount;

}
