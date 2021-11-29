package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import idao.jpa.IDAO;
import inventaire.Boisson;
import inventaire.Alcool;
import inventaire.Soft;
import inventaire.Article;
import inventaire.Stock;
import inventaire.Catalogue;
import inventaire.CarteBoissons;



public class DAOBoisson implements IDAO<Boisson, Integer> {

	@Override
	public Boisson findById(Integer id) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM boisson WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next(); //toujours mettre ça pour ne pas avoir valeur null (dans notre cas erreur)
			Boisson b = new Boisson(rs.getInt("id"), rs.getInt("id_bar"),rs.getString("nom"), rs.getString("type_produit") rs.getInt("prixHT"), rs.getInt("prixHThh"), rs.getInt("tva"));

			rs.close();
			ps.close();
			conn.close();

			return b;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public List<Boisson> findAll() {
		List<Boisson> boissons = new ArrayList();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from taverne");
			//Statement st = conn.createStatement();
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Boisson b = new Boisson(rs.getInt("id"), rs.getInt("id_bar"),rs.getString("nom"), rs.getString("type_produit") rs.getInt("prixHT"), rs.getInt("prixHThh"), rs.getInt("tva"));

				Boisson.add(b);
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boissons;
	}


	@Override
	public void insert(Boisson b) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte int (int id, int id_bar, String nom, String type_produit, double prixHT,double prixHThh,double tva) tva VALUES (?,?,?,?,?,?,?)");

			ps.setInt(1, b.getId());
			ps.setInt(2, b.getId_bar());
			ps.setString(3, b.getNom());
			ps.setString(4, b.getType_produit());
			ps.setDouble(5, b.getPrixHT());
			ps.setDouble(6, b.getPrixHThh());
			ps.setDouble(5, b.getTva());

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("UPDATE compte SET (nom,prenom,login,password,mail, type_compte) VALUES (?,?,?,?,?,?) WHERE id=?");

			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getLogin());
			ps.setString(4, c.getPassword());
			ps.setString(5, c.getMail());
			ps.setString(6, c.getClass().getSimpleName());
			ps.setInt(7, c.getId());

			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

	public Compte connect(String login, String password) {
		Compte c=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * from compte where login=? and password=?");
			ps.setString(1, login);
			ps.setString(2, password);

			ResultSet rs=ps.executeQuery();
			rs.next();
			String typeCompte = rs.getString("type_compte");
			switch (typeCompte) {
			case "Client": c = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("email"));
			case "Employe": c = new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("email"));
			case "Admin": c = new Admin(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("email"));
			case "Fournisseur": c = new Fournisseur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("email"), rs.getString("Entreprise"));
			case "Intervenant": c = new Intervenant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("email"));
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}



}



