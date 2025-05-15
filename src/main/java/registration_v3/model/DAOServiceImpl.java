package registration_v3.model;

import java.sql.*;

public class DAOServiceImpl implements DAOService {
private Connection con;
private Statement stmnt;
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registration_app1","root","test");
			stmnt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifycredentials(String email, String password) {
		try {
			ResultSet result = stmnt.executeQuery("select * from login where email = '"+email+"' and password = '"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void closeDB() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void saveReg(String name, String city, String email, String mobile) {
		try {
			stmnt.executeUpdate("insert into registration values('"+name+"','"+city+"','"+email+"','"+mobile+"')");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet getAllReg() {
		try {
			ResultSet result = stmnt.executeQuery("select * from registration");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteReg(String email) {
		try {
			stmnt.executeUpdate("delete from registration where email ='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateReg(String name, String city, String email, String mobile) {

		try {
			stmnt.executeUpdate("update registration set name='"+name+"',city='"+city+"',mobile='"+mobile+"'where email='"+email+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
