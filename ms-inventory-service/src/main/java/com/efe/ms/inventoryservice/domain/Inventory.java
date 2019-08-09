package com.efe.ms.inventoryservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@SuppressWarnings("serial")
@Entity
@Table(name="ms_inventory")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
public class Inventory extends BusinessEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	// 产品编码
//	@Column(name="sku")
	private String sku;
	// 数量
//	@Column(name="count")
	private Integer count;
	
}
