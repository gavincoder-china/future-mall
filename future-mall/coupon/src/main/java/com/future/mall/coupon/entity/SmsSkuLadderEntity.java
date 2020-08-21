package com.future.mall.coupon.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 商品阶梯价格
 * 
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-21 08:31:16
 */
@Data
@TableName("sms_sku_ladder")
public class SmsSkuLadderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Long id;
	/**
	 * $column.comments
	 */
	private Long skuId;
	/**
	 * $column.comments
	 */
	private Integer fullCount;
	/**
	 * $column.comments
	 */
	private BigDecimal discount;
	/**
	 * $column.comments
	 */
	private BigDecimal price;
	/**
	 * $column.comments
	 */
	private Integer addOther;

}
