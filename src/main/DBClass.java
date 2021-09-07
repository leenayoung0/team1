package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import member.MemberDTO;

public class DBClass {
	public Connection conn;

	public DBClass() {

		try {
			// 자바에서 오라클을 연결하기 위한 기타 기능들을 쓸 수 있게 라이브러리 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오라클과 연결된 객체를 가져온다.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "java");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int insert(MemberDTO dto) {
		String sql = "insert into fx_member(id,pwd,name) values(?,?,?)";
		int result = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPwd());
			ps.setString(3, dto.getName());
			
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}return result;

	}

	public MemberDTO loginChk(String inputId) {
		String sql="select * from fx_member where id =?";
		MemberDTO dto = null;
		try {
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, inputId);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				dto=new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setName(rs.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
}
