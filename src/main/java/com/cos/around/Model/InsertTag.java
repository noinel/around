package com.cos.around.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class InsertTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insertTagNum;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "tagNum")
	private Tags tag;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "boardNum")
	private Board board;
}
