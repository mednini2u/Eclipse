package polytech;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Etudiants etudiants = new Etudiants();
 
    public Controller() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("etudiants", etudiants);
		
		
		Etudiants etudiantsList = new Etudiants();
		request.setAttribute("res", etudiantsList.afficherTousLesEtudiants());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/dao.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//On definit un objet de la classe métier, on fait appel à la méthode ajouterUnEtudiant(etudiant, etudiant)
		Etudiant etudiant = new Etudiant();
		etudiant.setIdentifiant(Integer.parseInt(request.getParameter("id")));
		etudiant.setNom(request.getParameter("nom"));
		etudiant.setPrenom(request.getParameter("prenom"));
		
		Etudiants etudiants = new Etudiants();
		etudiants.ajouterUnEtudiant(etudiant);
		
		
		
		doGet(request, response);

	}

}
