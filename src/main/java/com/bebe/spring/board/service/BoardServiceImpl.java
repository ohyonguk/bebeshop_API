package com.bebe.spring.board.service;

import com.bebe.spring.board.dao.BoardDao;
import com.bebe.spring.board.vo.BoardVO;
import com.bebe.spring.board.vo.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("service")
public class BoardServiceImpl implements BoardService {

	private BoardDao dao;

	@Override
	public List<BoardVO> noticeList(Criteria cri) throws Exception {
		return dao.noticeList(cri);
	}

	@Override
	public List<BoardVO> faqList() throws Exception {
		return dao.faqList();
	}

	@Override
	public int noticeListCount(Criteria cri) throws Exception {
		return dao.noticeListCount(cri);
	}

	@Override
	public BoardVO readNotice(int noticeNo) throws Exception {
		return dao.readNotice(noticeNo);
	}

	@Override
	public BoardVO readFaq(int faqNo) throws Exception {
		return dao.readFaq(faqNo);
	}

	@Override
	public void writeNotice(BoardVO boardVO) throws Exception {
		dao.writeNotice(boardVO);

	}

	@Override
	public void writeFaq(BoardVO boardVO) throws Exception {
		dao.writeFaq(boardVO);
	}

	@Override
	public List<BoardVO> category(String noticeCategory) throws Exception {
		return dao.category(noticeCategory);
	}

	@Override
	public void deleteNotice(int noticeNo) throws Exception {
		dao.deleteNotice(noticeNo);
	}

	@Override
	public void deleteFaq(int faqNo) throws Exception {
		dao.deleteFaq(faqNo);
	}

	@Override
	public void updateNotice(BoardVO boardVO) throws Exception {
		dao.updateNotice(boardVO);
	}

	@Override
	public void updateFaq(BoardVO boardVO) throws Exception {
		dao.updateFaq(boardVO);
	}

	@Override
	public Integer rnumCount() throws Exception{
		return dao.rnumCount();
	}
}
