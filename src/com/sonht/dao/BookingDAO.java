package com.sonht.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sonht.config.DatabaseContext;
import com.sonht.dto.BookingDTO;

public class BookingDAO {
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preStatement = null;
	ResultSet rs = null;
	
	public List<BookingDTO> getBookingsByUserId(int userId) throws SQLException {
		List<BookingDTO> list = new ArrayList<BookingDTO>();
		try {
			connection = new DatabaseContext().getConnection();
			String sql = "SELECT "
					+ "    t.name, "
					+ "    t.image, "
					+ "    t.price, "
					+ "    b.adults_quantity, "
					+ "    b.children_quantity, "
					+ "    b.created_date, "
					+ "    b.status "
					+ "FROM "
					+ "booking b "
					+ "JOIN "
					+ "tour t ON b.tour_id = t.id "
					+ "where b.user_id=? and b.status='active'  ";
			preStatement = connection.prepareStatement(sql);
			preStatement.setInt(1, userId);
			
			rs = preStatement.executeQuery();
			while (rs.next()) {
				// retrieve data from result set row and create new student object
				BookingDTO booking = new BookingDTO(rs.getString("name"), rs.getString("image"), rs.getDouble("price"), 
						rs.getInt("adults_quantity"), rs.getInt("children_quantity"), rs.getString("created_date"), rs.getString("status"));

				// add it to the students
				list.add(booking);
			}
			return list;
		} finally {
			close(connection, statement, null, rs);
		}
	}
	
	
	private void close(Connection con, Statement stm, PreparedStatement pre, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stm != null)
				stm.close();
			if (pre != null)
				pre.close();
			if (con != null)
				con.close(); // doesn't really close it... just puts back in connection pool

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
