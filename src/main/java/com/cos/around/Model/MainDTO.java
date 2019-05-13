package com.cos.around.Model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
public class MainDTO {

	private int boardNum;

	private String boardContent;

	private LocalDate boardCreateDate;

	private LocalDate boardUpdateDate;

	private Region boardRegion;

	@JsonIgnoreProperties({"userGender","userAge","userSearchRegion","userRegion","userEmail","userSearchMinAge","userSearchMaxAge","userActivate","userCreateDate","userUpdateDate","heart","reply","board"})
	private Users user;
	
	@JsonIgnoreProperties({"feelingCreateDate","feelingUpdateDate","board"})
	private Feeling feeling;
	
	
	private List<Heart> hearts;
	
	
	
}
