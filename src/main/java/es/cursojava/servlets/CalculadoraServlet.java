package es.cursojava.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculadoraServlet
 */
@WebServlet("/CalculadoraServlet")
public class CalculadoraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CalculadoraServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int resultado=0;
		// tendria que recoger los parametros del formulario todos... vago
				String operacionJava = request.getParameter("operacion"); // estoy recogiendo el parametro nombre del formulario
				int numero1Java =Integer.parseInt(request.getParameter("numero1")); // estoy recogiendo del formulario
				int numero2Java =Integer.parseInt(request.getParameter("numero2")); // estoy recogiendo del formulario
				switch (operacionJava) {
				case "suma" ->
					resultado=numero1Java + numero2Java;
					
				case "resta" ->
					resultado=numero1Java - numero2Java;
					
				case "multiplicacion" ->
					resultado=numero1Java * numero2Java;

				default ->
					System.out.println("error operación");
					
				}
		response.getWriter().println("El resultado es: "+ resultado);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
