package com.mis.test;

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
public class BoardDAOCreateTest {
	
	private static final Logger Logger = LoggerFactory.getLogger(BoardDAOCreateTest.class);

	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception {
		
		BoardVO vo= new BoardVO();
		vo.setTitle("���ο� ��");
		vo.setContent("���ο� ���� �ֽ��ϴ�.");
		vo.setWriter("�׽���");
		
		Logger.info("testCreate : " + vo);
		dao.create(vo);
	}
}
