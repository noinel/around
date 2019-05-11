package com.cos.around.Model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Component
public class FeelingDTO {
	

	private int feelingNum;
	

	private String feelingName;

	private String feelingEmoticon;
	

	private List<Board> board;
	
	
}
