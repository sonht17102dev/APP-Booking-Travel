package com.sonht.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sonht.config.DatabaseContext;
import com.sonht.model.Post;

public class PostDAO {
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preStatement = null;
	ResultSet rs = null;
	
	public List<Post> getAllPosts() throws SQLException {
		List<Post> list = new ArrayList<Post>();
		try {
			connection = new DatabaseContext().getConnection();
			String sql = "select * from post ";
			statement = connection.createStatement();
			rs = statement.executeQuery(sql);
			while (rs.next()) {
				// retrieve data from result set row and create new student object
				Post post = new Post(rs.getInt("id"), rs.getString("name"), rs.getString("image"),
						rs.getString("description"), rs.getString("created_date"), rs.getString("status"));

				// add it to the students
				list.add(post);
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
				con.close(); 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Post getPostById(String postId) throws Exception {
		int id;
		Post postById = null;
		try {
			// convert user id to int
			id = Integer.parseInt(postId);
			// get connection to db
			connection = new DatabaseContext().getConnection();
			// create sql to get user by id
			String sql = "select * from post where id=? ";

			// create prepare statement
			preStatement = connection.prepareStatement(sql);

			// set params
			preStatement.setInt(1, id);

			// excute
			rs = preStatement.executeQuery();

			// get data save in result set
			if (rs.next()) {
				postById = new Post(id, rs.getString("name"), rs.getString("image"),
						rs.getString("description"), rs.getString("created_date"), rs.getString("status"));
			} else {
				throw new Exception("Could not find post id: " + postId);
			}

			return postById;
		} finally {
			close(connection, null, preStatement, rs);
		}
	}
	
}
