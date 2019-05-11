package com.cos.around.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
public class Heart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int heartNum;
	
	

	@ManyToOne
	@JoinColumn(name="userNum")
	private Users user;
	
	
	@ManyToOne
	@JoinColumn(name="boardNum")
	private Board board;
	
	
	@ManyToOne
	@JoinColumn(name="replyNum")
	private Reply reply;
	
	@Column(nullable = false)
	private int heartStatus;
}
