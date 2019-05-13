package com.cos.around.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

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
