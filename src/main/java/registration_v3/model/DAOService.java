package registration_v3.model;

import java.sql.ResultSet;

public interface DAOService {
public void connectDB();
public boolean verifycredentials(String email,String password);
public void closeDB();
public void saveReg(String name,String city,String email,String mobile);
public ResultSet getAllReg();
public void deleteReg(String email);
public void updateReg(String name,String city,String email,String mobile);
}
