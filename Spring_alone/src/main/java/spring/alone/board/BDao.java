package spring.alone.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BDao{
	
	@Autowired
	private SqlSession sqlSession;

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/*------------------------ex---------------------------------------------
	@Override
	   public List<BoardVO> boardList() {
	      System.out.println("BoardDAOImpl boardList()");
	      return sqlSession.selectList("board.boardlist");
	   }

	   @Override
	   public BoardVO boardDetail(int test) {
	      System.out.println("BoardDAOImpl boardDetail()");
	      return sqlSession.selectOne("board.boarddetail", test);
	   }

	   @Override
	   public void boardUpHits(int test) {
	      System.out.println("BoardDAOImpl boardUpHits()");
	      sqlSession.update("board.boarduphit",test);
	   }
	--------------------------------------------------------------*/
}

/*
public class BDao {

	DataSource dataSource;
	
	public BDao(){
		try{
			Context context =new InitialContext();
			dataSource =(DataSource)context.lookup("java:come/env/jdbc/Oracle11g");//context안에 db 정보중name=jdbc/oracle11g
		}catch(NamingException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDto> list(){
		
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet =null;
		
		try{
			connection= dataSource.getConnection();
			String sql="select bId,bName ,bTitle ,bContent ,bDate, bHit, bGreoup,bIndent frome mvc_board order by bGroup desc,bStep asc";
			preparedStatement=connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");
				
				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(resultSet != null) resultSet.close();
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return dtos;
	}
}
*/