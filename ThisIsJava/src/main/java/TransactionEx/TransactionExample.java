package TransactionEx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionExample {

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
			
			// -----트랜잭션 시작----- 
			
			// 자동 커밋 기능 끄기
			conn.setAutoCommit(false);
			// JDBC에서 트랜잭션을 코드로 제어하려면 자동 커밋 기능을 꺼야 한다
			// JDBC에서는 INSERT, UPDATE, DELETE 문을 실행할 때마다 자동 커밋이 일어난다
			
			// 출금 작업
			String sql1 = "UPDATE accounts SET balance = balance - ? WHERE ano = ?";
			
			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			
			pstmt1.setInt(1, 10000);
			pstmt1.setString(2, "111-111-1111");
			
			int rows1 = pstmt1.executeUpdate();
			if(rows1 == 0) {
				throw new Exception("출금되지 않았음");
			}
			
			pstmt1.close();
			
			// 입금 작업
			String sql2 = "UPDATE accounts SET balance = balance + ? WHERE ano = ?";
			
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			pstmt2.setInt(1, 10000);
			pstmt2.setString(2, "222-222-2222");
			
			int rows2 = pstmt2.executeUpdate();
			if(rows2 == 0) {
				throw new Exception("입금되지 않았음");
			}
			
			pstmt2.close();
			
			// 수동 커밋 -> 모두 성공 처리
			conn.commit();
			System.out.println("계좌 이체 성공");
			
			// -----트랜잭션 종료-----
			
		} catch (Exception e) {
			
			try {
				
				// 수동 롤백 -> 모두 실패 처리
				conn.rollback();
				
			} catch (SQLException e1) {}
				
			System.out.println("계좌 이체 실패");
			e.printStackTrace();
			
		} finally {
			
			if(conn != null) {
				
				try {
					
					// 원래대로 자동 커밋 기능 켜기
					conn.setAutoCommit(true);
					// 트랜잭션을 처리한 이후에는 원래대로 자동 커밋 기능을 쿼둬야 한다
					
					// 연결 끊기
					conn.close();
					
				} catch (Exception e2) {
				}
			}
		}
		
	}

}
