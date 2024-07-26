package com.sonht.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sonht.config.DatabaseContext;
import com.sonht.model.Tour;

public class TourDAO {
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preStatement = null;
	ResultSet rs = null;

	public List<Tour> getAllTours() throws SQLException {
		List<Tour> list = new ArrayList<Tour>();
		try {
			connection = new DatabaseContext().getConnection();
			String sql = "select * from tour";
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while(rs.next()) {
				// retrieve data from result set row and create new student object
				Tour tour = new Tour(rs.getInt("id"), rs.getString("name"), rs.getString("image"), 
						rs.getString("description"), rs.getString("start_date"), rs.getString("duetime"), 
						rs.getDouble("price"), rs.getString("address"), rs.getString("status"));
				
				// add it to the students
				list.add(tour);
			}
			return list;
		} finally {
			close(connection, statement, null, rs);
		}
	}

	private void close(Connection con, Statement stm, PreparedStatement pre,ResultSet rs) {
		try {
			if (rs != null) rs.close();
			if (stm != null) stm.close();
			if (pre != null) pre.close();
			if (con != null) con.close();  // doesn't really close it... just puts back in connection pool
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}