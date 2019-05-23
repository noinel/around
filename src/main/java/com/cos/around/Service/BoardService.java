package com.cos.around.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.around.Model.Board;
import com.cos.around.Model.Users;
import com.cos.around.Repository.BoardRepository;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	public Board create(Optional<Board> optionalBoard) {
		if (optionalBoard.isPresent()) {
			Board board = optionalBoard.get();

			Board result = boardRepository.save(board);

			return result;
		} else {
			return null;
		}
	}

	public Optional<List<Board>> findSearchBoard(Users user) {
		Optional<List<Board>> opBoards;
		int userSearchMinAge = user.getUserSearchMinAge();
		int userSearchMaxAge = user.getUserSearchMaxAge();
		int userSearchRegionNum = user.getUserSearchRegion().getRegionNum();
		if (user.getUserSearchRegion().getRegionName().equals("전국")) {
			opBoards = boardRepository.findSearchBoard(userSearchMinAge, userSearchMaxAge);
		} else {
			opBoards = boardRepository.findSearchBoard(userSearchRegionNum, userSearchMinAge, userSearchMaxAge);
		}
		return opBoards;
	}

}
