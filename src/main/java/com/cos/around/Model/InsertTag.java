package com.cos.around.Model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class InsertTag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int insertTagNum;
	
	@ManyToOne
	@JoinColumn(name="tagNum")
	private Tags tag;
	
	@ManyToOne
	@JoinColumn(name="boardNum")
	private Board board;
}
