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

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Component
public class ReplyDTO {

	private int replyNum;

	private String replyContent;

	private int replyStatus;

	private Timestamp replyCreateDate;

	private Timestamp replyUpdateDate;
	private Board board;
	private Reply toReply;
	private Users user;

	private List<Heart> heart;

}
