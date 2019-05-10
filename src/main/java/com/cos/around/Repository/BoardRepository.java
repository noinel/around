package com.cos.around.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.around.Model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer>{

}
