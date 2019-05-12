package com.cos.around.Model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
//@JsonIdentityInfo(generator =  ObjectIdGenerators.IntSequenceGenerator.class)
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

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "userNum")
	private Users user;

	@ManyToOne
	@JoinColumn(name = "boardRegionNum")
	private Region boardRegion;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "feelingNum")
	private Feeling feeling;

	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<Heart> heart;

	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<Reply> reply;

	@OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
	private List<InsertTag> insertTag;
}
