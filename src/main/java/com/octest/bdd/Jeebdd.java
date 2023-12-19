package com.octest.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.octest.beans.departement;
import com.octest.beans.etudiant;
import com.octest.beans.filiere;

public class Jeebdd {
	private String jdbcURL = "jdbc:mysql://localhost:3306/siham_jee?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";
	private String dbDriver = "com.mysql.jdbc.Driver";
	private int id;

	public Jeebdd() {
	}

	protected Connection getConnection(String dbDriver) {
		Connection connection = null;
		try {
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insert(departement departement) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO `departement`(`Nom_dep`,`num_filiere`,`num_etudiant`) VALUES (?,?,?)")) {
//			System.out.println("insert User:"+preparedStatement);
			preparedStatement.setString(1, departement.getNom());
			preparedStatement.setInt(2, departement.getNfilier());
			preparedStatement.setInt(3, departement.getNetudiant());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			printSQLException(e);
		}

	}

	public departement select(int id) {
		departement departement = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from departement where id_departement =?");) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nom = rs.getString("Nom_dep");
				int nfilier = rs.getInt("num_filiere");
				int netudiant = rs.getInt("num_etudiant");
				departement = new departement(id,  nom,  nfilier,  netudiant);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return departement;
	}

	public List<departement> selectAll() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<departement> Departement = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from departement");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id_departement");
				String nom = rs.getString("Nom_dep");
				int nfilier = rs.getInt("num_filiere");
				int netudiant = rs.getInt("num_etudiant");
				Departement.add(new departement(id,  nom,  nfilier,  netudiant));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Departement;
	}

	public boolean delete(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement statement = connection.prepareStatement("delete from departement where id_departement = ?");) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			statement.close();
		}
		return rowDeleted;
	}

	public boolean update(departement departement) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement statement = connection
						.prepareStatement("update departement set Nom_dep = ?, num_filiere = ? ,num_etudiant=? where id_departement = ?");) {
			System.out.println("updated User:" + statement);
			statement.setString(1, departement.getNom());
			statement.setInt(2, departement.getNfilier());
			statement.setInt(3, departement.getNetudiant());
			statement.setInt(4, departement.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public List<departement> ParNOM(String nameuser) {
		List<departement> usersn = new ArrayList<departement>();
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedSt = connection.prepareStatement("select * from departement where Nom_dep = ?");) {

			System.out.println(preparedSt);
			// Step 3: Execute the query or update query
			preparedSt.setString(1, nameuser);

			ResultSet rs = preparedSt.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				int id = rs.getInt("id_departement");
				String nom = rs.getString("Nom_dep");
				int nfilier = rs.getInt("num_filiere");
				int netudiant = rs.getInt("num_etudiant");
				usersn.add(new departement(id,  nom,  nfilier,  netudiant));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return usersn;
	}
	

	
	public void insertFilier(filiere Filiere) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO `filiere`(`Nom_fil`, `Nom_prof`,`num_etudiant`,`id_departement`) VALUES (?,?,?,?)")) {
//			System.out.println("insert User:"+preparedStatement);
			preparedStatement.setString(1, Filiere.getNom());
			preparedStatement.setString(2, Filiere.getNomprof());
			preparedStatement.setInt(3, Filiere.getNetudiant());
			preparedStatement.setInt(4, Filiere.getIddepar());

			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			printSQLException(e);
		}

	}
	
	public filiere selectFilier(int id) {
		filiere Filiere = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from filiere where id_filiere =?");) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nom = rs.getString("Nom_fil");
				String nomprof = rs.getString("Nom_prof");
				int netudiant = rs.getInt("num_etudiant");
				int iddepar = rs.getInt("id_departement");
				Filiere = new filiere(id,  nom,  nomprof,  netudiant, iddepar);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Filiere;
	}

	public List<filiere> selectAllFilier() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<filiere> Filiere= new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from filiere");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id_filiere");
				String nom = rs.getString("Nom_fil");
				String nomprof = rs.getString("Nom_prof");
				int netudiant = rs.getInt("num_etudiant");
				int iddepar = rs.getInt("id_departement");
				Filiere.add(new filiere(id,  nom,  nomprof,  netudiant, iddepar));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Filiere;
	}

	public boolean deleteFilier(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement statement = connection.prepareStatement("delete from filiere where id_filiere = ?");) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			statement.close();
		}
		return rowDeleted;
	}

	public boolean updateFilier(filiere Filiere) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement statement = connection
						.prepareStatement("update filiere set Nom_fil = ?, Nom_prof = ?,num_etudiant = ? ,id_departement = ? where id_filiere = ?");) {
			System.out.println("updated User:" + statement);
			statement.setString(1, Filiere.getNom());
			statement.setString(2, Filiere.getNomprof());
			statement.setInt(3, Filiere.getNetudiant());
			statement.setInt(4, Filiere.getIddepar());
			statement.setInt(5, Filiere.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public List<filiere> ParNOMFilier(String nameuser2) {
		List<filiere> usersn = new ArrayList<filiere>();
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedSt = connection.prepareStatement("select * from filiere where Nom_fil = ?");) {

			System.out.println(preparedSt);
			// Step 3: Execute the query or update query
			preparedSt.setString(1, nameuser2);

			ResultSet rs = preparedSt.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				int id = rs.getInt("id_filiere");
				String nom = rs.getString("Nom_fil");
				String nomprof = rs.getString("Nom_prof");
				int netudiant = rs.getInt("num_etudiant");
				int iddepar = rs.getInt("id_departement");
				usersn.add(new filiere(id,  nom,  nomprof,  netudiant, iddepar));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return usersn;
	}
	
	public int ParNOMFilier2(String nameuser2) {
		int id= 0 ;
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedSt = connection.prepareStatement("select * from filiere where Nom_fil = ?");) {

			System.out.println(preparedSt);
			// Step 3: Execute the query or update query
			preparedSt.setString(1, nameuser2);

			ResultSet rs = preparedSt.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				 id = rs.getInt("id_departement");
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return id ;
	}
	
	public departement select2(int id) {
		departement departement = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from departement where id_departement =?");) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nom = rs.getString("Nom_dep");
				departement = new departement(nom);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return departement;
	}

	
	
	
	
	public void insertEtudiant(etudiant Etudiant) throws SQLException {
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO `etudiant`(`CNE`, `Nom`, `Prenom`, `Telephone`, `id_filiere`, `id_departement`) VALUES (?,?,?,?,?,?)")) {
//			System.out.println("insert User:"+preparedStatement);
			preparedStatement.setString(1, Etudiant.getCne());
			preparedStatement.setString(2, Etudiant.getNom());
			preparedStatement.setString(3, Etudiant.getPrenom());
			preparedStatement.setString(4, Etudiant.getTelephone());
			preparedStatement.setInt(5, Etudiant.getIdfilier());
			preparedStatement.setInt(6, Etudiant.getIddepar());


			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			printSQLException(e);
		}

	}

	public etudiant selectEtudiant(int id) {
		etudiant Etudiant = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from etudiant where Id =?");) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String cne = rs.getString("CNE");
				String nom = rs.getString("Nom");
				String prenom = rs.getString("Prenom");
				String telephone = rs.getString("Telephone");
				int idfilier = rs.getInt("id_filiere");
				int iddepar = rs.getInt("id_departement");
				Etudiant = new etudiant(id, cne , nom,  prenom, telephone , idfilier, iddepar);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Etudiant;
	}

	public List<etudiant> selectAllEtudiant() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<etudiant> Etudiant = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select * from etudiant");) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("Id");
				String cne = rs.getString("CNE");
				String nom = rs.getString("Nom");
				String prenom = rs.getString("Prenom");
				String telephone = rs.getString("Telephone");
				int idfilier = rs.getInt("id_filiere");
				int iddepar = rs.getInt("id_departement");
				Etudiant.add(new etudiant(id, cne , nom,  prenom, telephone , idfilier, iddepar));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Etudiant;
	}

	public boolean deleteEtudiant(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement statement = connection.prepareStatement("delete from etudiant where Id = ?");) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			statement.close();
		}
		return rowDeleted;
	}

	public boolean updateEtudiant(etudiant Etudiant) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection(dbDriver);
				PreparedStatement statement = connection
						.prepareStatement("update etudiant set CNE = ?, Nom = ?, Prenom = ?, Telephone = ? , id_filiere = ?, id_departement=?  where Id = ?");) {
			System.out.println("updated User:" + statement);
			statement.setString(1, Etudiant.getCne());
			statement.setString(2, Etudiant.getNom());
			statement.setString(3, Etudiant.getPrenom());
			statement.setString(4, Etudiant.getTelephone());
			statement.setInt(5, Etudiant.getIdfilier());
			statement.setInt(6, Etudiant.getIddepar());
			statement.setInt(7, Etudiant.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	public List<etudiant> ParNOMEtudiant(String nameuser2) {
		List<etudiant> usersn = new ArrayList<etudiant>();
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedSt = connection.prepareStatement("select * from etudiant where CNE = ?");) {

			System.out.println(preparedSt);
			// Step 3: Execute the query or update query
			preparedSt.setString(1, nameuser2);

			ResultSet rs = preparedSt.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				int id = rs.getInt("Id");
				String cne = rs.getString("CNE");
				String nom = rs.getString("Nom");
				String prenom = rs.getString("Prenom");
				String telephone = rs.getString("Telephone");
				int idfilier = rs.getInt("id_filiere");
				int iddepar = rs.getInt("id_departement");
				usersn.add(new etudiant(id, cne , nom,  prenom, telephone , idfilier, iddepar));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return usersn;
	}
	
	public int ParNOMEtudiant2(String nameuser2) {
		int id= 0 ;
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedSt = connection.prepareStatement("select * from etudiant where CNE = ?");) {

			System.out.println(preparedSt);
			// Step 3: Execute the query or update query
			preparedSt.setString(1, nameuser2);

			ResultSet rs = preparedSt.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				 id = rs.getInt("id_departement");
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return id ;
	}
	
	public departement select3(int id) {
		departement departement = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from departement where id_departement =?");) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nom = rs.getString("Nom_dep");
				departement = new departement(nom);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return departement;
	}

	public int ParNOMEtudiant4(String nameuser2) {
		int id= 0 ;
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedSt = connection.prepareStatement("select * from etudiant where CNE = ?");) {

			System.out.println(preparedSt);
			// Step 3: Execute the query or update query
			preparedSt.setString(1, nameuser2);

			ResultSet rs = preparedSt.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {

				 id = rs.getInt("id_filiere");
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return id ;
	}
	
	public filiere select4(int id) {
		filiere filiere = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection(dbDriver);
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from filiere where id_filiere =?");) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String nom = rs.getString("Nom_fil");
				filiere = new filiere(nom);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return filiere;
	}
	
	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}