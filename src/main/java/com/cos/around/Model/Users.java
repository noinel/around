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
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userNum;
	@Column(nullable = false)
	private int userAge;
	@Column(nullable = false)
	private String userGender;
	
	@ManyToOne
	@JoinColumn(name="userSearchRegionNum")
	private Region userSearchRegion;
	
	@ManyToOne
	@JoinColumn(name="userRegionNum")
	private Region userRegion;

	@OneToMany(mappedBy = "user")
	private List<Heart> heart;
	
	@OneToMany(mappedBy = "user")
	private List<Board> board;
	
	@OneToMany(mappedBy = "user")
	private List<Reply> reply;
	
	@Column(nullable = false, length = 50)
	private String userEmail;
	@Column(nullable = false)
	private int userSearchMinAge;
	@Column(nullable = false)
	private int userSearchMaxAge;
	@Column(nullable = false)
	private int userActivate;
	@Column(nullable = false)
	private Timestamp userCreateDate;
	@Column(nullable = false)
	private Timestamp userUpdateDate;
}
