package com.revature.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.revature.beans.Employee;
import com.revature.beans.Reimburse;
import com.revature.util.ConnectionUtil;

public class ReimburseDAOImpl implements ReimburseDAO {
	
	private static String filename = "connection.properties";
	private static Logger log = Logger.getRootLogger();

	@Override
	public List<Reimburse> getReimburseByEmployee(Employee e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Reimburse getReimburseByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getImage(int id) {
		InputStream image = null;
		FileOutputStream output = null;
		PreparedStatement pstmt = null;
		
		File file = new File("test.jpg");
		try {
			output = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("entered");
		try (Connection con = ConnectionUtil.getConnectionFromFile(filename)) {
			String sql = "SELECT * FROM IMAGE WHERE ID = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				//System.out.println(rs.getBytes("BODY"));
				
				image =  rs.getBinaryStream("BODY");
				

				byte[] bytes = IOUtils.toByteArray(image);
				String encoded = Base64.getEncoder().encodeToString(bytes);
				
	
				return encoded;
		
				
			} else {
				log.warn("no matching image found for id: " + id);
			}

		} catch (SQLException ex) {
			log.info("Error getting image id: " + id + "\nsqltrace: " + ex);
			//ex.printStackTrace();
		} catch (IOException ex) {
			log.info("Error getting image id: " + id + "\niotrace: " + ex);
			//ex.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean addNewRequest(Reimburse r) {
		 PreparedStatement pstmt;
	        if (r == null) {
	            return false;
	        }
	        
	        System.out.println(r);

	        try (Connection con = ConnectionUtil.getConnectionFromFile(filename)){
	            String sql = "INSERT INTO REIMBURSE (REIMBURSE_PROCESS, EMPLOYEE_ID, REIMBURSE_TYPE, REIMBURSE_VALUE,IMAGE) VALUES (?,?,?,?,?)";
	            pstmt = con.prepareStatement(sql);
	            pstmt.setInt(1, r.getStatus());
	            pstmt.setInt(2, r.getEmployeeID() );
	            pstmt.setString(3, r.getType());
	            pstmt.setDouble(4, r.getValue());
	            pstmt.setBlob(5, r.getImage());
	         
	            if (pstmt.executeUpdate() > 0) {
	                return true;
	            }
	        } catch (SQLException | IOException e) {
	            e.printStackTrace();
	        }
	        return false;
	}

}
