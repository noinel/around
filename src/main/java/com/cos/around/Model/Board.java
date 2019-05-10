package com.cos.around.Model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int boardNum;
	
	@Lob
	@Column(nullable = false)
	private String boardContent;
	
	@Column(nullable = true)
	private String boardAttach;
	
	
	@Column(nullable = false)
	private Timestamp boardCreateDate;
	@Column(nullable = false)
	private Timestamp boardUpdateDate;
	
	@ManyToOne
	@JoinColumn(name="userNum")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name="boardRegionNum")
	private Region boardRegion;
	
	@ManyToOne
	@JoinColumn(name="feelingNum")
	private Feeling feeling;
	
//	
	@OneToMany(mappedBy = "board") 
	private List<Heart> heart;

	@OneToMany(mappedBy = "board")
	private List<Reply> reply;
	
	@OneToMany(mappedBy = "board")
	private List<InsertTag> insertTag;
}
