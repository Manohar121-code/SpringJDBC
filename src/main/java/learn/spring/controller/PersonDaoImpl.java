package learn.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import learn.spring.model.Person;

@Repository
public class PersonDaoImpl implements IPersonDao {

	public void savePerson(Person p) {
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/junedb";
		String userName = "root";
		String password = "manah";
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		try {
			Class.forName(dbDriver);
			String sql = "insert into person(name, age) values(?,?)";
			
			connection = DriverManager.getConnection(url, userName, password);
			prepareStatement = connection.prepareStatement(sql);
			
			prepareStatement.setString(1, p.getName());
			prepareStatement.setInt(2, p.getAge());
			
			prepareStatement.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && prepareStatement != null) {
					connection.close();
					prepareStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Person> listPersons() {
		String dbDriver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/junedb";
		String userName = "root";
		String password = "manah";
		
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		
		List<Person> listPersons = new ArrayList<Person>();
		try {
			Class.forName(dbDriver);
			String sql = "select * from person";
			
			connection = DriverManager.getConnection(url, userName, password);
			prepareStatement = connection.prepareStatement(sql);
			
			ResultSet rs = prepareStatement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Person p = new Person(id, name, age);
				listPersons.add(p);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null && prepareStatement != null) {
					connection.close();
					prepareStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listPersons;
	}

}
