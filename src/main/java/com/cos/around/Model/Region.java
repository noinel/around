package com.cos.around.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Table(
		uniqueConstraints={
			@UniqueConstraint(columnNames={"regionName"}
			)
		}
	)
@Data
@Entity
//@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class Region {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int regionNum;

	@Column(nullable = false, length = 60)
	private String regionName;


}
