package BoardEx;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardSelectExample {

	public static void main(String[] args) {

		Connection conn = null;
		
		try {
			
			// JDBC Driver 등록
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// 연결하기
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/thisisjava",
					"root",
					"1111"
					);
			
			// 매개변수화된 SQL 문 작성
			String sql = "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata " +
						"FROM boards " +
						"WHERE bwriter = ?";
			
			// PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "winter");
			
			// SQL 문 실행 후, ResultSet을 통해 데이터 읽기
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				board.setBfilename(rs.getString("bfilename"));
				board.setBfiledata(rs.getBlob("bfiledata"));
				
				// 콘솔에 출력
				System.out.println(board);
				
				// Blob 객체에 저장된 바이너리 데이터를 얻기 위해서는 입력 스트림 또는 배열을 얻어내야 한다
				// 파일로 저장
				Blob blob = board.getBfiledata();
				if(blob != null) {
					
					InputStream is = blob.getBinaryStream();
					OutputStream os = new FileOutputStream("c:/temp/" + board.getBfilename());		// bfiledata 컬럼의 그림 데이터는 c:\Temp 디렉토리에 저장된다
					is.transferTo(os);
					os.flush();
					os.close();
					is.close();
				}
			}
			
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					
					// 연결 끊기
					conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
