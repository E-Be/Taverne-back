package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import comptes.Client;
import fonctionnalitees.CarteFidelite;

public class DAOCarte {

	public void update(CarteFidelite c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("UPDATE carte_client SET id=?, id_client=?, points=? WHERE id=?");

			ps.setInt(1, c.getId());
			ps.setInt(2, c.getOwner().getId());
			ps.setInt(3, c.getNbPoints());
			ps.setInt(4, c.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void insert(CarteFidelite c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO  carte_client SET id=?, id_client=?, points=? WHERE id=?");

			ps.setInt(1, c.getId());
			ps.setInt(2, c.getOwner().getId());
			ps.setInt(3, c.getNbPoints());
			ps.setInt(4, c.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

}
