// method with strategy pattern
public void deleteAll() {
	jdbcContextWithStatementStrategy(new DeleteAllStatement());
}

// method with template/callback pattern
public void deleteAll() {
	jdbcContextWithStatementStrategy(new StatementStrategy {
		public PreparedStatement makePreparedStatement(Connection conn) {
			return conn.prepareStatement("DELETE FROM USERS");
		}
	});
}

public void excuteSql(final String query) {
	this.jdbcContext.workWithStatementStrategy(new StatementStrategy() {
		public PreparedStatement makePreparedStatement(Connection conn) {
			return conn.prepareStatement(query);
		}
	});
}

// strategy pattern
// interface
public interface StatementStrategy {
	public PreparedStatement makePreparedStatement(Connection conn);
}

// strategy pattern
// class 
public class DeleteAllStatement implements StatementStrategy {
	public PreparedStatement makePreparedStatement(Connection conn) {
		PreparedStatement ps = conn.prepareStatement("DELETE FROM USERS");
		return ps;
	}
}

public void jdbcContextWithStatementStrategy(StatementStrategy strategy) {
	Connection conn=null;
	PreparedStatement ps = null;

	try {
		conn = dataSource.getConnection();
		strategy.makePreparedStatement(conn);
		ps.excuteUpdate();
	}
	catch(SQLException e) {

	}
	finally {
		if(ps!=null) { try { ps.close();} catch(SQLException e) {}}
		if(conn!=null) { try { conn.close();} catch(SQLException e) {}}
	}
}


