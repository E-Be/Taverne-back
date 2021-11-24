package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import comptes.Admin;
import comptes.Client;
import comptes.Compte;
import comptes.Employe;
import comptes.Fournisseur;
import comptes.Intervenant;
import fonctionnalitees.CarteFidelite;



public class DAOCompte implements IDAO<Compte, Integer> {
	
	static DAOCarte daoCarte = new DAOCarte();

	@Override
	public Compte findById(Integer id) {
		Compte c = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/taverne","root","");

			PreparedStatement ps = conn.prepareStatement("SELECT * FROM compte WHERE compte.id_compte=?");
			ps.setInt(1, id);

			ResultSet rs=ps.executeQuery();
			rs.next();
			String typeCompte = rs.getString("type_compte");
			switch (typeCompte) {
			case "Client": c = new Client(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); 
			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM carte_client WHERE carte_client.id_client=?");
			ps2.setInt(1, id);
			ResultSet rs2=ps2.executeQuery();
			if (rs2.next()) {
				CarteFidelite carte = new CarteFidelite(rs2.getInt("id"), (Client)c,rs2.getInt("points"));
			}
			ps2.close();
			rs2.close();
			break;
			case "Admin": c = new Admin(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
			case "Employe": c = new Employe(rs.getInt("id_compte_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
			case "Fournisseur": c = new Fournisseur(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("entreprise") ); break;
			case "Intervenant": c = new Intervenant(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("entreprise")); break;
			default: c = null; break;
			}
			rs.close();
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
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
				case "Client": c = new Client(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
				case "Admin": c = new Admin(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
				case "Employe": c = new Employe(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
				case "Fournisseur": c = new Fournisseur(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("entreprise") ); break;
				case "Intervenant": c = new Intervenant(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("entreprise")); break;
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

			PreparedStatement ps;

			if ((c.getClass().getSimpleName().equals("Client"))) {
				ps = conn.prepareStatement("UPDATE compte SET nom=?, prenom=?, login=?, password=?, mail=?, type_compte=? WHERE id_compte=?");
				ps.setString(1, c.getNom());
				ps.setString(2, c.getPrenom());
				ps.setString(3, c.getLogin());
				ps.setString(4, c.getPassword());
				ps.setString(5, c.getMail());
				ps.setString(6, c.getClass().getSimpleName());
				ps.setInt(7, c.getId());
				daoCarte.update(((Client)c).getCarte());
			} else {
				ps = conn.prepareStatement("UPDATE compte SET nom=?, prenom=?, login=?, password=?, mail=?, type_compte=? WHERE id_compte=?");
				ps.setString(1, c.getNom());
				ps.setString(2, c.getPrenom());
				ps.setString(3, c.getLogin());
				ps.setString(4, c.getPassword());
				ps.setString(5, c.getMail());
				ps.setString(6, c.getClass().getSimpleName());
				ps.setInt(7, c.getId());
			}


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
			case "Client": c = new Client(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); 
			PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM carte_client WHERE carte_client.id_client=?");
			ps2.setInt(1, rs.getInt("id_compte"));
			ResultSet rs2=ps2.executeQuery();
			if (rs2.next()) {
				CarteFidelite carte = new CarteFidelite(rs2.getInt("id"), (Client)c,rs2.getInt("points"));
			}
			ps2.close();
			rs2.close();
			break;
			case "Employe": c = new Employe(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
			case "Admin": c = new Admin(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
			case "Fournisseur": c = new Fournisseur(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail"), rs.getString("Entreprise")); break;
			case "Intervenant": c = new Intervenant(rs.getInt("id_compte"), rs.getString("nom"), rs.getString("prenom"), rs.getString("login"), rs.getString("password"), rs.getString("mail")); break;
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
