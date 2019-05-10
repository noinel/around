package com.cos.around.Model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int replyNum; 
	
	@Column(nullable = false, length = 60)
	private String replyContent;
	@Column(nullable = false)
	private int replyStatus;
	@Column(nullable = false)
	private Timestamp replyCreateDate;
	@Column(nullable = false)
	private Timestamp replyUpdateDate;
	
	@ManyToOne
	@JoinColumn(name="boardNum")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="toReplyNum")
	private Reply toReply;
	
	@ManyToOne
	@JoinColumn(name="userNum")
	private Users user;
	
	@OneToMany(mappedBy = "reply")
	private List<Heart> heart;
	
	
	
	
	
}
