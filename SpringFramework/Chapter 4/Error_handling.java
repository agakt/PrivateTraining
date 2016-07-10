// JdbcTemplate : The template/callback pattern related jdbc driver supplied by Spring framework
public class UserDao {
     ...
     private JdbcTemplate jdbcTemplate;

     public void setDataSource(DataSource dataSource) {
          this.jdbcTemplate = new JdbcTemplate(dataSource);
          this.dataSource = dataSource;
     }
}


1. update() // PreparedStatementCreator 콜백 사용

jdbcTemplate.update("delete from users");
jdbcTemplate.update("insert into users(id,name,password) values(?,?,?)", user.getId(), user.getName(),                            user.getPassword());


2. queryForInt(), query() // PreparedStatementCreator, ResultSetExtractor 콜백 사용 

jdbcTemplate.queryForInt("select count(*) from users");


3. queryForObject() // RowMapper 콜백 사용 

jdbcTemplate.queryForObject("select * from users where id=?", new Object[] {id}, new RowMapper<User>()
{
     public User mapRow(ResultSet rs, int rowNum) {
          User user = new User();
          user.setId(rs.getString("id")); 
          user.setName(rs.getString("name"));
          user.setPassword(rs.getString("password"));
          return user;
      }
});

// 낙관적 에러 처리 : 모든 에러는 해결할 수 없는 RuntimeException으로 시스템적으로 처리해야 한다고 생각하는 자세.
// RuntimeException의 장점 : catch문으로 따로 처리할 의무가 없다. 메서드 선언문에서 따로 throws문을 적지 않아도 된다. 
catch(SQLException e) {
     if(e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY)
          throw DuplicateUserException(e);
     else
          throw e;
}

public class DuplicatedUserException extens RuntimeException {
     public DuplicatedUserException (Throwable caues) {
          super(cause);
     }
}

// throws DuplicatedUserException을 적은 이유 : 의무가 아닌 정보 제공이 목적이다.
public void add() throws DuplicatedUserException {
     try {
          ...
     }
     catch(SQLException e) {
          if(e.getErrorCode() == MysqlErrorNumbers.ER_DUP_ENTRY)
               throw new DuplicatedUserException(e);
          else
               throw new RuntimeException(e);
     }
}
