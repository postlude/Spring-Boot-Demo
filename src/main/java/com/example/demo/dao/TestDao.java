package com.example.demo.dao;

//import static com.example.demo.jooq.tables.Test.TEST;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDao {
	// 1. JdbcTemplate 이용하는 방법
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	public Map<String, Object> getName(int seq) throws Exception {
//		return jdbcTemplate.queryForMap("select name from test where seq = ?", seq);
//	}
	
	/*
	 * 직접 connection을 받아오는 코드
	 * 간혹 쓰일 수 있음
	 * ResultSet 은 DBMS 의 커서를 받아 한 레코드씩 결과를 전송받아 전달해주는 객체이기 때문에 게시판처럼 수십 줄 정도를 불러와 처리하는 경우에는 별다른 차이가 없으나
	 * 수천, 수만 줄 이상의 레코드를 결과로 받아와 한 번에 처리해야 하는 경우라면 객체에 주입하기 위해,
	 * 그리고 주입 후 처리를 위해 덩치 큰 객체와 이를 처리하기 위한 객체 사용 등으로 GC 에 굉장한 부담을 줄 수 있습니다.
	 */
	/*public Map<String, Object> getName(int seq) throws Exception {
		Connection conn = jdbcTemplate.getDataSource().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(" select name from test where seq = ? ");
		pstmt.setInt(1, seq);

		ResultSet rs = pstmt.executeQuery();

		Map<String, Object> result;
		
		if (rs.next()) {
			String name = rs.getString("name");
			result = Collections.singletonMap("name", name);
		} else {
			result = Collections.singletonMap("name", null);
		}

		return result;
	}*/
	
	/*@Autowired
	private ApplicationContext applicationContext;

	public Map<String, Object> getName(int seq) throws Exception {

		DataSource ds = (DataSource) applicationContext.getBean("dataSource");
		Connection conn = ds.getConnection();

		// 이하 생략
	}*/
	
	
	// 2. mybatis 이용 방법
	@Autowired
	private SqlSession sqlSession;

	public Map<String, Object> getName(int seq) throws Exception {
		return sqlSession.selectOne("mapper.TestMapper.getName", seq);
	}
	
	
	// 3. JOOQ 이용 방법
	/*@Autowired
	private DSLContext create;

	public Map<String, Object> getName(int seq) throws Exception {
		return create.select(TEST.NAME)
				.from(TEST)
				.where(TEST.SEQ.equal(seq))
				.fetchOneMap();
	}*/
}
