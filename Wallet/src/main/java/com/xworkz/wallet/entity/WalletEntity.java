package com.xworkz.wallet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
	@Entity
	@AllArgsConstructor
	@NoArgsConstructor
	@Table(name="wallet_table")

	@NamedQuery(name="findByName",query="SELECT entity FROM WalletEntity entity where entity.company=:company")
	@NamedQuery(name="findPriceByname",query="SELECT entity.price FROM WalletEntity entity where entity.company=:company")
	@NamedQuery(name="findPriceAndSizeByCompany",query="Select entity.price,entity.size from WalletEntity entity where entity.company=:company")
	public class WalletEntity {
		@Id
		private int id;
		@Column(name="wallet_company")
		private String company;
		@Column(name="wallet_price")
		private int price;
		@Column(name="wallet_color")
		private String color;
		@Column(name="wallet_size")
		private int size;

}
