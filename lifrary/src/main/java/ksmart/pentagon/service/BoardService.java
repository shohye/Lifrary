package ksmart.pentagon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ksmart.pentagon.mapper.BoardMapper;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardmapper;
	
}
