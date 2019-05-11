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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Component
public class UsersDTO {
	private int userNum;

	private int userAge;

	private String userGender;

	private Region userSearchRegion;

	private Region userRegion;

	private List<Heart> heart;

	private List<Board> board;

	private List<Reply> reply;

	
	private String userEmail;
	
	private int userSearchMinAge;
	
	private int userSearchMaxAge;
	
	private int userActivate;
	
	private Timestamp userCreateDate;
	
	private Timestamp userUpdateDate;
}
