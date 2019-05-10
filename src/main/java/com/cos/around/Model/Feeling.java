package com.cos.around.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Feeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int feelingNum;
	
	@Column(nullable = false, length = 60)
	private String feelingName;
	@Column(nullable = false)
	private String feelingEmoticon;
	
	@OneToMany(mappedBy = "feeling")
	private List<Board> board;
	
	
}
