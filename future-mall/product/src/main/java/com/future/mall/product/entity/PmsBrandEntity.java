package com.future.mall.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 品牌
 * 
 * @author gavincoder
 * @email gavincoder@163.com
 * @date 2020-08-21 08:35:58
 */
@Data
@TableName("pms_brand")
public class PmsBrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * $column.comments
	 */
	@TableId
	private Long brandId;
	/**
	 * $column.comments
	 */
	private String name;
	/**
	 * $column.comments
	 */
	private String logo;
	/**
	 * $column.comments
	 */
	private String descript;
	/**
	 * $column.comments
	 */
	private Integer showStatus;
	/**
	 * $column.comments
	 */
	private String firstLetter;
	/**
	 * $column.comments
	 */
	private Integer sort;

}
