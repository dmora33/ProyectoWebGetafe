package es.cursojava.servlets;

import java.io.IOException;

import es.cursojava.dto.AlumnoDto;
import es.cursojava.service.AlumnoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlumnosServlet
 */
@WebServlet("/AlumnosServlet")
public class AlumnosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AlumnosServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreJava = request.getParameter("Nombre"); // estoy recogiendo el parametro nombre del formulario
		int apellidoJava =Integer.parseInt(request.getParameter("Edad")); // estoy recogiendo el parametro edad del formulario
		String emailJava = request.getParameter("Email"); // estoy recogiendo el parametro email del formulario
		System.out.println("FormularioServlet doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		AlumnoDto alumnoDto = new AlumnoDto(nombreJava, apellidoJava, emailJava);
		System.out.println("Alumno DTO creado: " + alumnoDto.getNombre());
		AlumnoService alumnoService = new AlumnoService();
		alumnoService.insertarAlumno(alumnoDto);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
