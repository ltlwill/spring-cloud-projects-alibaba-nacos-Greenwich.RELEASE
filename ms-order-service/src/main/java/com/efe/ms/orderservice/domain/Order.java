package com.efe.ms.orderservice.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name="ms_order")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order extends BusinessEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	// 产品编码
//	@Column(name="sku")
	private String sku;
	// 数量
//	@Column(name="count")
	private Integer count;
	
	@Column(name="user_id")
	private String userId;
	
	private BigDecimal amount;
	
	@Column(name="create_time")
	private Date createTime;
	
}
