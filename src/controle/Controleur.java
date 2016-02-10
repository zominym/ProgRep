package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.*;
import dao.ServiceAdherent;
import dao.ServiceOeuvrepret;
import meserreurs.*;

/**
 * Servlet implementation class Controleur
 */
@WebServlet("/Controleur")
public class Controleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ACTION_TYPE = "action";
	private static final String LISTER_RADHERENT = "listerAdherent";
	private static final String AJOUTER_ADHERENT = "ajouterAdherent";
	private static final String INSERER_ADHERENT = "insererAdherent";
	private static final String ERROR_KEY = "messageErreur";
	private static final String ERROR_PAGE = "/erreur.jsp";
	
	private static final String LISTER_OEUVREPRETS = "listerOeuvres";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		processusTraiteRequete(request, response);
	}

	protected void processusTraiteRequete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionName = request.getParameter(ACTION_TYPE);
		String destinationPage = ERROR_PAGE;
		// execute l'action
		if (LISTER_RADHERENT.equals(actionName)) {
			try {

				ServiceAdherent unService = new ServiceAdherent();
				request.setAttribute("mesAdherents", unService.consulterListeAdherents());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationPage = "/listerAdherent.jsp";
		}
        
		else if (LISTER_OEUVREPRETS.equals(actionName)) {
			try {

				ServiceOeuvrepret unService = new ServiceOeuvrepret();
				request.setAttribute("mesOeuvreprets", unService.consulterListeOeuvreprets());

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			destinationPage = "/listerOeuvres.jsp";
		}
			
		if (AJOUTER_ADHERENT.equals(actionName)) {

			destinationPage = "/ajouterAdherent.jsp";
		} else if (INSERER_ADHERENT.equals(actionName)) {
			try {
				Adherent unAdherent = new Adherent();
				unAdherent.setNomAdherent(request.getParameter("txtnom"));
				unAdherent.setPrenomAdherent(request.getParameter("txtprenom"));
				unAdherent.setVilleAdherent(request.getParameter("txtville"));
				ServiceAdherent unService = new ServiceAdherent();
				unService.insertAdherent(unAdherent);

			} catch (MonException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			destinationPage = "/index.jsp";
		}

		else {
			String messageErreur = "[" + actionName + "] n'est pas une action valide.";
			request.setAttribute(ERROR_KEY, messageErreur);
		}
		// Redirection vers la page jsp appropriee
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);

	}

}
