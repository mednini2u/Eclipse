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
 * Servlet implementation class ControllerSup
 */
@WebServlet("/ControllerSup")
public class ControllerSup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Etudiants etudiants = new Etudiants();
    public ControllerSup() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("etudiants", etudiants);
		
		
		Etudiants etudiantsList = new Etudiants();
		request.setAttribute("res", etudiantsList.afficherTousLesEtudiants());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/daoSup.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		etudiants.supprimerUnEtudiant(Integer.parseInt(request.getParameter("idsup")));
		
		doGet(request, response);
	}

}
