package com.cos.around.Model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
public class InsertTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insertTagNum;
	
	@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
	@ManyToOne
	@JoinColumn(name="tagNum")
	private Tags tag;
	
	@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
	@ManyToOne
	@JoinColumn(name="boardNum")
	private Board board;
}
