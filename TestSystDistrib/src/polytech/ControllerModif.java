package polytech;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerModif
 */
@WebServlet("/ControllerModif")
public class ControllerModif extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Etudiants etudiants = new Etudiants();
    
    public ControllerModif() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setAttribute("etudiants", etudiants);
		
		
		Etudiants etudiantsList = new Etudiants();
		request.setAttribute("res", etudiantsList.afficherTousLesEtudiants());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/daoModif.jsp").forward(request,response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		etudiants.modifierUnEtudiant(Integer.parseInt(request.getParameter("idm")), request.getParameter("nomm"), request.getParameter("prenomm"));
		doGet(request, response);
	}

}
