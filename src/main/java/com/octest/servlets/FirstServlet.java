package com.octest.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.octest.beans.Login;
import com.octest.beans.filiere;
import com.octest.beans.etudiant;
import com.octest.beans.departement;
import com.octest.beans.etudiantcher;
import com.octest.beans.departementcher;
import com.octest.bdd.Jeebdd;
import com.octest.beans.Login;
import com.octest.beans.filiere;
import com.octest.beans.etudiant;
import com.octest.beans.departement;
import com.octest.beans.filiercher;
import com.octest.bdd.LoginBean;

@WebServlet("/")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Jeebdd dao;

	public void init() {
		dao = new Jeebdd();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/login":
				loginUser(request, response);
				break;
			case "/logout":
				logout(request, response);
				break;
			case "/formdepartement":
				showNewForm(request, response);
				break;
			case "/insertdepartement":
				insertUser(request, response);
				break;
			case "/deletedepartement":
				deleteUser(request, response);
				break;
			case "/editdepartement":
				showEditForm(request, response);
				break;
			case "/updatedepartement":
				updateUser(request, response);
				break;
			case "/showdepartement":
				listUser(request, response);
				break;
			case "/chercherdepartement":
				listUserchercher(request, response);
				break;
			case "/chercherindexdepartement":
				listUserchercherIndex(request, response);
				break;
			case "/newfilier":
				showNewFormfilier(request, response);
				break;
			case "/insertfilier":
				insertUserfilier(request, response);
				break;
			case "/deletefilier":
				deleteUserfilier(request, response);
				break;
			case "/editfilier":
				showEditFormfilier(request, response);
				break;
			case "/updatefilier":
				updateUserfilier(request, response);
				break;
			case "/showfilier":
				listUserfilier(request, response);
				break;
			case "/chercherfilier":
				listUserchercherfilier(request, response);
				break;
			case "/chercherindexfilier":
				listUserchercherIndexfilier(request, response);
				break;
			case "/Filier":
				listUserIndexfilier(request, response);
				break;
			case "/newetudiant":
				showNewFormetudiant(request, response);
				break;
			case "/insertetudiant":
				insertUseretudiant(request, response);
				break;
			case "/deleteetudiant":
				deleteUseretudiant(request, response);
				break;
			case "/editetudiant":
				showEditFormetudiant(request, response);
				break;
			case "/updateetudiant":
				updateUseretudiant(request, response);
				break;
			case "/showetudiant":
				listUseretudiant(request, response);
				break;
			case "/chercheretudiant":
				listUserchercheretudiant(request, response);
				break;
			case "/chercherindexetudiant":
				listUserchercherIndexetudiant(request, response);
				break;
			case "/Etudiant":
				listUserIndexetudiant(request, response);
				break;
				
			default:
				listUserIndex(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);

		}
	}
	
	private void loginUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		LoginBean loginDao = new LoginBean();

		HttpSession session = request.getSession();

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login loginbdd = new Login();
		loginbdd.setUsername(username);
		loginbdd.setPassword(password);

		if (loginDao.validate(loginbdd)) {
			session.setAttribute("username", username);
			response.sendRedirect("showdepartement");

		} else {
			// HttpSession session = request.getSession();
			response.sendRedirect("Login.jsp");

		}

	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		  HttpSession session = request.getSession();
	        session.removeAttribute("username");
			response.sendRedirect("Index.jsp");

	}
	
	

	private void listUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<departement> Departement = dao.selectAll();
		request.setAttribute("Departement", Departement);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
	}

	private void listUserIndex(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String nameuser = "";
		if (nameuser == "") {
			List<departement> Departement = dao.selectAll();
			request.setAttribute("Departement", Departement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		departement existingUser = dao.select(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String name = request.getParameter("name");
		int name2 = Integer.parseInt(request.getParameter("name2"));
		int name3 = Integer.parseInt(request.getParameter("name3"));

		departement newUser = new departement(name,name2,name3);
		dao.insert(newUser);
		response.sendRedirect("showdepartement");
//		request.getRequestDispatcher("user-list.jsp");

	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int name2 = Integer.parseInt(request.getParameter("name2"));
		int name3 = Integer.parseInt(request.getParameter("name3"));


		departement book = new departement(id, name, name2, name3);
		dao.update(book);
		response.sendRedirect("showdepartement");
//		request.getRequestDispatcher("user-list.jsp");

	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.delete(id);
		response.sendRedirect("showdepartement");
//		request.getRequestDispatcher("user-list.jsp");

	}

	private void listUserchercher(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nameuser = request.getParameter("nameUser");
		if (nameuser == "") {
			List<departement> Departement = dao.selectAll();
			request.setAttribute("Departement", Departement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
			dispatcher.forward(request, response);

		} else {
			departementcher model = new departementcher();
			model.setNameUser(nameuser);
			List<departement> userss = dao.ParNOM(nameuser);
			model.setDepartement(userss);
			request.setAttribute("model", model);
			request.getRequestDispatcher("list-chercher.jsp").forward(request, response);
		}

	}

	private void listUserchercherIndex(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nameuser = request.getParameter("nameUser");
		if (nameuser == "") {
			List<departement> Departement = dao.selectAll();
			request.setAttribute("Departement", Departement);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Index.jsp");
			dispatcher.forward(request, response);

		} else {
			departementcher model = new departementcher();
			model.setNameUser(nameuser);
			List<departement> userss = dao.ParNOM(nameuser);
			model.setDepartement(userss);
			request.setAttribute("model", model);
			request.getRequestDispatcher("Index-chercher.jsp").forward(request, response);
		}

	}



	private void listUserfilier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<filiere> Filiere = dao.selectAllFilier();
		request.setAttribute("Filiere", Filiere);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-filier.jsp");
		dispatcher.forward(request, response);
	}

	private void listUserIndexfilier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String nameuser = "";
		if (nameuser == "") {
			List<filiere> Filiere = dao.selectAllFilier();
			request.setAttribute("Filiere", Filiere);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Index-filier.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void showNewFormfilier(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-filier.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormfilier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		filiere existingUser = dao.selectFilier(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-filier.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUserfilier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		int name4 = Integer.parseInt(request.getParameter("name4"));
		int name3 = Integer.parseInt(request.getParameter("name3"));

		filiere newUser = new filiere(name1,name2,name4,name3);
		dao.insertFilier(newUser);
		response.sendRedirect("showfilier");

	}

	private void updateUserfilier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		int name4 = Integer.parseInt(request.getParameter("name4"));
		int name3 = Integer.parseInt(request.getParameter("name3"));

		filiere book = new filiere(id, name, name2,name4, name3);
		dao.updateFilier(book);
		response.sendRedirect("showfilier");

	}

	private void deleteUserfilier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteFilier(id);
		response.sendRedirect("showfilier");

	}

	private void listUserchercherfilier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nameuser = request.getParameter("nameUser2");
		if (nameuser == "") {
			List<filiere> Filiere = dao.selectAllFilier();
			request.setAttribute("Filiere", Filiere);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list-filier.jsp");
			dispatcher.forward(request, response);

		} else {
			filiercher model2 = new filiercher();
			model2.setNameUser2(nameuser);
			List<filiere> userss = dao.ParNOMFilier(nameuser);
			model2.setFiliere(userss);
			request.setAttribute("model", model2);
			request.setAttribute("model2", model2);

			int Filier = dao.ParNOMFilier2(nameuser);

			departement existingUser = dao.select2(Filier);
			request.setAttribute("existingUser", existingUser);

			request.getRequestDispatcher("list-chercher-filier.jsp").forward(request, response);
		}

	}

	private void listUserchercherIndexfilier(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nameuser2 = request.getParameter("nameUser2");
		if (nameuser2 == "") {
			List<filiere> Filiere = dao.selectAllFilier();
			request.setAttribute("Filiere", Filiere);

			RequestDispatcher dispatcher = request.getRequestDispatcher("Index-filier.jsp");
			dispatcher.forward(request, response);

		} else {
			filiercher model2 = new filiercher();
			model2.setNameUser2(nameuser2);
			List<filiere> userss = dao.ParNOMFilier(nameuser2);
			model2.setFiliere(userss);
			request.setAttribute("model2", model2);

			int Filier = dao.ParNOMFilier2(nameuser2);

			departement existingUser = dao.select2(Filier);
			request.setAttribute("existingUser", existingUser);

			request.getRequestDispatcher("Index-chercher-filier.jsp").forward(request, response);
		}

	}




	private void listUseretudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<etudiant> Etudiant = dao.selectAllEtudiant();
		request.setAttribute("Etudiant", Etudiant);
		RequestDispatcher dispatcher = request.getRequestDispatcher("list-etudiant.jsp");
		dispatcher.forward(request, response);
	}

	private void listUserIndexetudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String nameuser = "";
		if (nameuser == "") {
			List<etudiant> Etudiant = dao.selectAllEtudiant();
			request.setAttribute("Etudiant", Etudiant);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Index-etudiant.jsp");
			dispatcher.forward(request, response);

		}
	}

	private void showNewFormetudiant(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-etudiant.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditFormetudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		etudiant existingUser = dao.selectEtudiant(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("form-etudiant.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertUseretudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String cne = request.getParameter("cne");
		String name = request.getParameter("name");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		int idfilier = Integer.parseInt(request.getParameter("idfilier"));
		int iddepar = Integer.parseInt(request.getParameter("iddepar"));

		etudiant newUser = new etudiant(cne, name, prenom, telephone, idfilier, iddepar);
		dao.insertEtudiant(newUser);
		response.sendRedirect("showetudiant");
//		request.getRequestDispatcher("user-list.jsp");

	}

	private void updateUseretudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String cne = request.getParameter("cne");
		String name = request.getParameter("name");
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");
		int idfilier = Integer.parseInt(request.getParameter("idfilier"));
		int iddepar = Integer.parseInt(request.getParameter("iddepar"));

		etudiant book = new etudiant(id, cne, name, prenom, telephone, idfilier, iddepar);
		dao.updateEtudiant(book);
		response.sendRedirect("showetudiant");
//		request.getRequestDispatcher("user-list.jsp");

	}

	private void deleteUseretudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		dao.deleteEtudiant(id);
		response.sendRedirect("showetudiant");
//		request.getRequestDispatcher("user-list.jsp");

	}

	private void listUserchercheretudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nameuser = request.getParameter("nameUser3");
		if (nameuser == "") {
			List<etudiant> Etudiant = dao.selectAllEtudiant();
			request.setAttribute("Etudiant", Etudiant);
			RequestDispatcher dispatcher = request.getRequestDispatcher("list-etudiant.jsp");
			dispatcher.forward(request, response);

		} else {
			etudiantcher model3 = new etudiantcher();
			model3.setNameUser3(nameuser);
			List<etudiant> userss = dao.ParNOMEtudiant(nameuser);
			model3.setEtudiant(userss);
			request.setAttribute("model3", model3);
			int Etudiant = dao.ParNOMEtudiant2(nameuser);

			departement existingUser = dao.select3(Etudiant);
			request.setAttribute("existingUser", existingUser);

			int Etudiant2 = dao.ParNOMEtudiant4(nameuser);

			filiere existingUser2 = dao.select4(Etudiant2);
			request.setAttribute("existingUser2", existingUser2);
			request.getRequestDispatcher("list-chercher-etudiant.jsp").forward(request, response);
		}

	}

	private void listUserchercherIndexetudiant(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		String nameuser3 = request.getParameter("nameUser3");
		if (nameuser3 == "") {
			List<etudiant> Etudiant = dao.selectAllEtudiant();
			request.setAttribute("Etudiant", Etudiant);

			RequestDispatcher dispatcher = request.getRequestDispatcher("Index-etudiant.jsp");
			dispatcher.forward(request, response);

		} else {
			etudiantcher model3 = new etudiantcher();
			model3.setNameUser3(nameuser3);
			List<etudiant> userss = dao.ParNOMEtudiant(nameuser3);
			model3.setEtudiant(userss);
			request.setAttribute("model3", model3);

			int Etudiant = dao.ParNOMEtudiant2(nameuser3);

			departement existingUser = dao.select3(Etudiant);
			request.setAttribute("existingUser", existingUser);

			int Etudiant2 = dao.ParNOMEtudiant4(nameuser3);

			filiere existingUser2 = dao.select4(Etudiant2);
			request.setAttribute("existingUser2", existingUser2);

			request.getRequestDispatcher("Index-chercher-etudiant.jsp").forward(request, response);
		}

	}

}