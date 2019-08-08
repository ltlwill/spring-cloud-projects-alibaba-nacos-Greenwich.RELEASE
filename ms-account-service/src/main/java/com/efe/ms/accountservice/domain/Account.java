package com.efe.ms.accountservice.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
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
@Table(name="ms_account")
@DynamicInsert
@DynamicUpdate
@Getter
@Setter
@NoArgsConstructor
public class Account extends BusinessEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	// 产品编码
	@Column(name="user_id")
	private String userId;
	
	@Column(name="user_name")
	private String userName;
	// 数量
	private BigDecimal balance;
	
}
