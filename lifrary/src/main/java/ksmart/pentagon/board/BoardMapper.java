package ksmart.pentagon.board;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ksmart.pentagon.vo.Board;

@Mapper
public interface BoardMapper {
	
	public List<Board> getBoard();

}
