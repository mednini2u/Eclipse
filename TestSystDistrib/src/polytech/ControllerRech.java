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
 * Servlet implementation class ControllerRech
 */
@WebServlet("/ControllerRech")
public class ControllerRech extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Etudiants etudiants = new Etudiants();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerRech() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	/*	request.setAttribute("etudiants", etudiants);
		Etudiants etudiantsList = new Etudiants();
		String src = request.getParameter("nameRe");
		
		if(src=="root") {
			
			request.setAttribute("res", etudiantsList.afficherTousLesEtudiants());
			System.out.println("Test");
		}
		else {
			
			
			System.out.println("Test5");
		}
		*/
		request.setAttribute("etudiants", etudiants);
		Etudiants etudiantsList = new Etudiants();
		String src = request.getParameter("nameRe");
		
	
			
		if(src!= "all")  {
			request.setAttribute("res", etudiantsList.rechUnEtudiant(src));
		}
		else {
			
			request.setAttribute("res", etudiantsList.afficherTousLesEtudiants());
			
		}
		
		
		
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/daoRech.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		doGet(request, response);
	}

}
