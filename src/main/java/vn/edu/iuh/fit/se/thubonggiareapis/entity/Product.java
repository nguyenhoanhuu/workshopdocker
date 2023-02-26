package vn.edu.iuh.fit.se.thubonggiareapis.entity;

import java.io.Serializable;


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
import lombok.ToString;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, columnDefinition = "NVARCHAR(255)")
	private String name;
	@Column(columnDefinition = "NVARCHAR(255)")
	private String brand;

	@Column(columnDefinition = "NVARCHAR(255)")
	private String madeIn;
	@Column
	private float price;
	private Type type;
}
