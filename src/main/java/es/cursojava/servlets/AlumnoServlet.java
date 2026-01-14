package es.cursojava.servlets;

import java.io.IOException;
import java.util.List;

import es.cursojava.entities.AlumnoEntiti;
import es.cursojava.hibernate.ejercicio1.dto.AlumnoDTO;
import es.cursojava.hibernate.ejercicio1.service.AlumnoService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AltaAlumnoServlet")
public class AlumnoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    AlumnoService alumnoService = new AlumnoService();
	    List<AlumnoEntiti> listado = alumnoService.listarAlumnos();

	    
	    
	    // Pasar la lista a la JSP
	    req.setAttribute("alumnos", listado);
	    req.getRequestDispatcher("listarAlumnos.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String email = req.getParameter("email");
		Integer edad = Integer.parseInt(req.getParameter("edad"));
		
		AlumnoDTO alumnoDTO = new AlumnoDTO(nombre, email, edad);
		AlumnoService alumnoService = new AlumnoService();
		
		try {
			alumnoService.altaAlumnoService(alumnoDTO);
			resp.getWriter().println("Alumno dado de alta correctamente.");
		} catch (IllegalArgumentException e) {
			resp.getWriter().println("Error al dar de alta el alumno: " + e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
	}

	
	
}
