package com.mis.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import com.mis.domain.MemberVO;
import com.mis.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = ("file:src/main/webapp/WEB-INF/spring**/root-context.xml"))
public class MemberDAOTest {

	private static final Logger Logger = LoggerFactory.getLogger(MemberDAOTest.class);

	@Inject
	private MemberDAO dao;

/*	@Test
	public void testInsertMember() throws Exception {

		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUsername("°ü¸®ÀÚ");
		vo.setUserpw("1234");
		vo.setEmail("admin@gmail.com");

		Logger.info("testInsertMember: " + vo);
		dao.insertMember(vo);
	}
*/
	@Test
	public void testTime() throws Exception {
		Logger.info("testTime : ", dao.getTime());
	}

	@Test
	public void testReadMember() throws Exception {
		Logger.info("testReadMember : ", dao.readMember("admin"));
	}

	@Test
	public void testReadWithPW() throws Exception {
		Logger.info("testReadWithPW : ", dao.readWithPW("admin", "1234"));
	}
}
