package com.cos.around.Model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class Tags {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tagNum;

	@Column(nullable = false, length = 60)
	private String tagName;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "tag")
	private List<InsertTag> insertTag;
	
	@CreationTimestamp
	private LocalDate tagCreateDate;
	@CreationTimestamp
	private LocalDate tagUpdateDate;
}
