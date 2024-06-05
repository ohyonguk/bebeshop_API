package com.bebe.spring.board.service;

import java.util.List;

import com.bebe.spring.board.vo.BoardVO;
import com.bebe.spring.board.vo.Criteria;

public interface BoardService {
	
	public List<BoardVO> noticeList(Criteria cri) throws Exception;
	public List<BoardVO> faqList() throws Exception;
	
	public BoardVO readNotice(int noticeNo) throws Exception;
	public BoardVO readFaq(int faqNo) throws Exception;
	public int noticeListCount(Criteria cri) throws Exception;
	
	public void writeNotice(BoardVO boardVO) throws Exception;
	public void writeFaq(BoardVO boardVO) throws Exception;
	public List<BoardVO> category(String noticeCategory) throws Exception;
	
	public void deleteNotice(int noticeNo) throws Exception;
	public void deleteFaq(int faqNo) throws Exception;
	
	public void updateNotice(BoardVO boardVO) throws Exception;
	public void updateFaq(BoardVO boardVO) throws Exception;

	public Integer rnumCount() throws Exception;
	
}