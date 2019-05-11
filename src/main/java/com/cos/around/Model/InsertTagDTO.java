package com.cos.around.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Component
@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class InsertTagDTO {
	private int insertTagNum;

	private Tags tag;
	private Board board;
}
