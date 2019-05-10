package com.cos.around.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
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
