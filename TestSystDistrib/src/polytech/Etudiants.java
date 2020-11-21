package polytech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import com.sun.java.util.jar.pack.Package.Class;

// Ici on définit la couche de notre app
public class Etudiants {
	
	private Connection connection = null;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}




	public void seConnecter() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //exception surveillée
		} catch (ClassNotFoundException e) {
			System.out.println("Le Driver n'est pas chargé");
		}
		
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/cm13nov?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
			System.out.println("Connecté à la BDD");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	public List<Etudiant> afficherTousLesEtudiants(){
		List<Etudiant> res = new ArrayList<Etudiant>();
		
		this.seConnecter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //exception surveillée
		} catch (ClassNotFoundException e) {
			System.out.println("Le Driver n'est pas chargé");
		}
		
		
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		try {
			
			statement = connection.createStatement();
			//execute une requete et récuperer le contenu dans l'objet résultSet
			resultSet = statement.executeQuery("SELECT * FROM `etudiants`");
			
			//récupération des données...
			while(resultSet.next()) {
				int identifiant = resultSet.getInt("identifiant");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				res.add(new Etudiant(identifiant, nom, prenom));
			}
			
			
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("Problème de connexion à la base de donnée");
		}
		finally {
			
				try {
					if (connection!= null)
					connection.close();
					if (statement != null)
					statement.close();
					if(resultSet !=null)
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return res;
	}
	
	
	public void ajouterUnEtudiant(Etudiant etudiant) {
		this.seConnecter();
		
		// failles d'injection SQL
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("INSERT INTO `etudiants`(`identifiant`, `nom`, `prenom`) VALUES (?,?,?);");
			preparedStatement.setInt(1, etudiant.getIdentifiant());
			preparedStatement.setString(2, etudiant.getNom());
			preparedStatement.setString(3, etudiant.getPrenom());
			
			//executer la requête
			preparedStatement.executeUpdate();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème dans l'ajout d'un étudiant");
		}
	}
	
	public void supprimerUnEtudiant(int idSup) {
		this.seConnecter();
		
		// failles d'injection SQL
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("DELETE FROM `etudiants` WHERE `identifiant`=?");
			preparedStatement.setInt(1, idSup);
	
			preparedStatement.executeUpdate();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Problème dans la suppresion d'un étudiant");
		}
	}
	
	
	
	
	public List<Etudiant> rechUnEtudiant(String name) {
	//	this.seConnecter();
		//List<Etudiant> res = new ArrayList<Etudiant>();
		List<Etudiant> res = new ArrayList<Etudiant>();
		
		
		this.seConnecter();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //exception surveillée
		} catch (ClassNotFoundException e) {
			System.out.println("Le Driver n'est pas chargé");
		}
		
		
		
		ResultSet resultSet = null;
		try {
			
				
	
				PreparedStatement preparedStatement = this.connection.prepareStatement("SELECT * FROM `etudiants` WHERE `nom`=? OR `prenom`=?");
				
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, name);
				
				resultSet = preparedStatement.executeQuery();
				
			
				while(resultSet.next()) {
					int identifiant = resultSet.getInt("identifiant");
					String nom = resultSet.getString("nom");
					String prenom = resultSet.getString("prenom");
					res.add(new Etudiant(identifiant, nom, prenom));
				
			}
			
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Problème dans la recherche");
		}
		return res;
	}
	
	
	
	
	public void modifierUnEtudiant(int ID, String Name, String Forname) {
		this.seConnecter();
		
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement("UPDATE `etudiants` SET `nom`=?,`prenom`=? WHERE `identifiant`=?");
			preparedStatement.setInt(3, ID);
			preparedStatement.setString(1, Name);
			preparedStatement.setString(2, Forname);
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problème dans la modification d'un étudiant");
		}
		
	}
}
