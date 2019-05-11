package com.cos.around.Model;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class BoardDTO {

	private int boardNum;

	private String boardContent;

	private String boardAttach;

	private Timestamp boardCreateDate;

	private Timestamp boardUpdateDate;

	private int userNum;

	private Region boardRegion;

	private int feelingNum;

	private List<Integer> heartNums;

	private List<Integer> replyNums;

	private List<Integer> insertTagNums;
}
