public int getCount() throws SQLException {
	DataSource dataSource;
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;

	try {
		con = dataSource.getConnection();
		stmt = con.preparedStatement("Select ");
		rs = stmt.excuteQuery();
		rs.next();
		return rs.getInt(1);
	}
	catch(SQLException e) {
		
	}
	finally {
		if(rs!=null) {
			try {
				rs.close();
			}
			catch() {

			}
		}
		if(stmt!=null) {
			try {
				rs.close();
			}
			catch() {
				
			}
		}
		if(con!=null) {
			try {
				rs.close();
			}
			catch() {
				
			}
		}
	}
}