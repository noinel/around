package com.cos.around.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data

public class HeartDTO {
	
	
	private int heartNum;

	@JsonIgnoreProperties({"userGender","userSearchRegion","userRegion","userEmail","userSearchMinAge","userSearchMaxAge","userActivate","userCreateDate","userUpdateDate","heart","reply","board"})
	private Users user;
	
	@JsonIgnoreProperties({})
	private Board board;

	private Reply reply;

	private int heartStatus;
}
