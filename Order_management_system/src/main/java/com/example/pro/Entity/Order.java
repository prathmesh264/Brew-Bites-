package com.example.pro.Entity;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	
	@Column(name = "customer_Name")
	public String customerName;
	
	@Column(name = "product")
	public String product;
	
	@Column(name = "quantity")
	public String quantity;
	
	@Column(name = "order_Date ")
	public String oDate;
	
	
	@Enumerated(EnumType.STRING)
	@Column(name = "status")
	
//	       enum type
	
	public orderStatusEnum status;
	

}


