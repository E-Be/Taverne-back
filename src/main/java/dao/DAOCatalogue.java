package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import inventaire.Catalogue;
import comptes.Client;
import comptes.Compte;
import comptes.Employe;
import comptes.Fournisseur;
import comptes.Intervenant;

public class DAOCatalogue implements IDAO<Catalogue, Integer> {

	@Override
	public Catalogue findById(Integer id) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM catalogue WHERE id=?");
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next(); //toujours mettre ça pour ne pas avoir valeur null (dans notre cas erreur)
			Catalogue c = new Stock(rs.getInt("id_produit_catalogue"), rs.getString("Produit"), rs.getString("type_produit"), rs.getInt("coutHT"), rs.getInt("Qte_lot"), rs.getInt("Volume"), rs.getInt("id_fournisseur"));

			rs.close();
			ps.close();
			conn.close();

			return p;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;	
	}

	@Override
	public List<Compte> findAll() {
		List<Compte> listC = new ArrayList<Compte>();
		Compte c;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte");

			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				String typeCompte = rs.getString("type_compte");
				switch (typeCompte) {
				case "Client": c = new Client(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
				case "Admin": c = new Admin(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
				case "Employe": c = new Employe(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
				case "Fournisseur": c = new Fournisseur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("entreprise") ); break;
				case "Intervenant": c = new Intervenant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("entreprise")); break;
				default: c = null; break;
				}
				listC.add(c);
			}

			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listC;
	}

	@Override
	public void insert(Compte c) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("INSERT INTO compte (nom,prenom,login,password,mail, type_compte) VALUES (?,?,?,?,?,?)");

			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getLogin());
			ps.setString(4, c.getPassword());
			ps.setString(5, c.getMail());
			ps.setString(6, c.getClass().getSimpleName());

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


