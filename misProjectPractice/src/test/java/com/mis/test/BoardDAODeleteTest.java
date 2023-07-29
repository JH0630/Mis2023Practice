package com.mis.test;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mis.domain.BoardVO;
import com.mis.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/webapp/WEB-INF/spring**/root-context.xml"))
public class BoardDAODeleteTest {

	private static final Logger Logger = LoggerFactory.getLogger(BoardDAOSelectTest.class);

	@Inject
	private BoardDAO dao;

	@Test
	public void testDelete() throws Exception {

		int bno = 1;

		// 1) 1�� �Խñ� ����
		dao.delete(bno);

		// 2) ��ü ��� Ȯ��
		List<BoardVO> list = dao.listAll();

		for (BoardVO vo : list) {
			Logger.info("testListAll :" + vo);
		}
	}
}
