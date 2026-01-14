package es.cursojava.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormularioServlet
 */
@WebServlet("/formulariogetafe")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public FormularioServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// tendria que recoger los parametros del formulario todos... vago
		String nombreJava = request.getParameter("Nombre"); // estoy recogiendo el parametro nombre del formulario
		int apellidoJava =Integer.parseInt(request.getParameter("Edad")); // estoy recogiendo el parametro edad del formulario
		String emailJava = request.getParameter("Email"); // estoy recogiendo el parametro email del formulario
		System.out.println("FormularioServlet doGet");
		response.getWriter().append("<p>hola esto es un parrafo</p>").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
