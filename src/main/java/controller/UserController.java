package controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.bo.Offre;
import model.bo.Postulations;
import model.bo.TypeOffre;
import model.bo.User;
import model.dao.DAOOffre;
import model.dao.DAOPostulations;
import model.dao.DAOTypeOffre;
import model.dao.DAOUser;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		maxFileSize = 1024 * 1024 * 10, // 10 MB
		maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static User userSession;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Post : " + request.getPathInfo());
		switch (request.getPathInfo()) {
		case "/inserer":
			System.out.println("insertion");
			register(request, response);
			break;

		case "/login":
			try {
				authenticate(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "/updateOffre":
			updateOffre(request, response);
			listOffresuser(request, response);
			break;
		case "/inscription":
			inscription(request, response);
			break;

		case "/mesoffres":

			break;

		case "/postuler":
			postuler(request, response);
			break;

		default:
			break;
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;
		System.out.println("Get : " + request.getPathInfo());
		switch (request.getPathInfo()) {
		case "/inserer":

			request.getRequestDispatcher("/register.jsp").forward(request, response);
			break;
		case "/offres":
			if (userSession.getType().equals("u"))
				listOffresuser(request, response);
			if (userSession.getType().equals("a"))
				listOffresadmin(request, response);

			break;
		case "/login":
			response.sendRedirect("/login.jsp");
			break;

		case "/modifier":
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("offre", new DAOOffre().getOffreByID(id));
			dispatcher = request.getRequestDispatcher("/modifier.jsp");
			dispatcher.forward(request, response);
			break;

		case "/supprimer":
			System.out.println("Dans /supprimer");

			deleteOffre(request, response);
			listOffresuser(request, response);
			break;
		case "/demandes":
			mesoffres(request, response);
			break;
		case "/demande":
			dispatcher = request.getRequestDispatcher("/demande.jsp");
			dispatcher.forward(request, response);
			break;
		case "/DownloadServlet":
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			String filename = request.getParameter("nom");
			String filepath = "c:\\upload\\";
			response.setContentType("APPLICATION/OCTET-STREAM");
			// response.setHeader("Content-Disposition", "attachment; filename=\"" +
			// filename + "\"");

			// use inline if you want to view the content in browser, helpful for pdf file
			response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
			FileInputStream fileInputStream = new FileInputStream(filepath + filename);

			int i;
			while ((i = fileInputStream.read()) != -1) {
				out.write(i);
			}
			fileInputStream.close();
			out.close();

			break;

		default:
			break;
		}

	}

	private void mesoffres(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		List<Postulations> mo = new DAOPostulations().getListDemandes(id);
		System.out.println("liste des offres :");
		System.out.println(mo);
		request.setAttribute("mo", mo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/demandes.jsp");
		dispatcher.forward(request, response);

	}

	private void postuler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* Receive file uploaded to the Servlet from the HTML5 form */

		Part filePart = request.getPart("cv");
		String cv = request.getPart("cv").getSubmittedFileName();
		// cv.concat(filePart.getSubmittedFileName());
		System.out.println("cv : " + cv);
		for (Part part : request.getParts()) {
			part.write("C:\\upload\\" + filePart.getSubmittedFileName());
		}

		filePart = request.getPart("lm");
		String lm = request.getPart("lm").getSubmittedFileName();
		;
//		lm.concat(filePart.getSubmittedFileName());
		System.out.println("lm : " + lm);

		for (Part part : request.getParts()) {
			part.write("C:\\upload\\" + filePart.getSubmittedFileName());
		}
		// acceder a la session pour utiliser les donnees d'utilisateur courant
		int id = Integer.parseInt(request.getParameter("id"));

		HttpSession session = request.getSession();
		// session.getAttribute("user");

		Offre o = new DAOOffre().getOffreByID(id);

		Postulations post = new Postulations(cv, lm);
		post.setDemandeur((User) session.getAttribute("user"));
		post.setOffre(o);

		new DAOPostulations().postuler(post);
		listOffresuser(request, response);

	}

	private void inscription(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User(nom, prenom, email, password, "u");
		System.out.println(user);
		new DAOUser().saveUser(user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);

	}

	private void deleteOffre(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Dans deleteOffre()");
		int id = Integer.parseInt(request.getParameter("id"));
		Offre o = new Offre();
		o.setId(id);

		new DAOOffre().supprimerOffre(o);
	}

	public int typedeoffre(String s) {
		switch (s) {
		case "cdi":
			return 3;
		case "cdd":
			return 2;
		case "stage":
			return 1;
		default:
			return 0;
		}
	}

	// MAJ
	private void updateOffre(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String type = request.getParameter("inputType");
		int idtype = typedeoffre(type);
		int id = Integer.parseInt(request.getParameter("id"));

		Offre o = new Offre();
		o.setId(id);
		o.setTitre(titre);
		o.setDescription(description);
		TypeOffre to = new DAOTypeOffre().getTypeId(type);
		o.setType(to);

		new DAOOffre().updateOffre(o);

	}

	// afficher les offres pour un utilisateur
	private void listOffresuser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Offre> lo = new DAOOffre().getListOffres();
		request.setAttribute("lo", lo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/offres.jsp");
		dispatcher.forward(request, response);
	}

	// afficher les offres pour un admin
	private void listOffresadmin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Offre> lo = new DAOOffre().getListOffresadmin();
		request.setAttribute("lo", lo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/offres.jsp");
		dispatcher.forward(request, response);

	}

	// inserer une offre
	private void register(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// pour garder les informations comme titre, description, type d'offre
		String titre = request.getParameter("titre");
		String description = request.getParameter("description");
		String type = request.getParameter("inputType");
		// acceder a la session pour utiliser les donnees d'utilisateur courant
		HttpSession session = request.getSession();
		// garder l'utilisateur courant dans (u)
		User u = (User) session.getAttribute("user");
		// creatin de l'offre
		Offre o = new Offre(titre, description);
		// utilisation des objets persités
		TypeOffre to = new DAOTypeOffre().getTypeId(type);
		u = new DAOUser().getUserById(u.getId());

		o.setCreateur(u);
		o.setType(to);
		// insertion
		new DAOOffre().insererOffre(o);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/register-success.jsp");
		dispatcher.forward(request, response);
	}

	// authentification
	private void authenticate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DAOUser loginDao = new DAOUser();
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		userSession = loginDao.validate(username, password);
		HttpSession session = request.getSession();
		session.setAttribute("user", userSession);

		if (userSession != null) {
			System.out.println("User valide ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/offres.jsp");
			dispatcher.forward(request, response);
		} else {
			System.out.println("User non valide ");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
			dispatcher.forward(request, response);
		}
	}
}