package es.cursojava.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import es.cursojava.dto.AlumnoDto;
import es.cursojava.entities.AlumnoEntiti;
import es.cursojava.utils.HibernateUtil;

public class AlumnoService {
	
	public void insertarAlumno(AlumnoDto alumnoDto) {
        // Validaciones básicas
        if (alumnoDto == null) {
            throw new IllegalArgumentException("El alumno no puede ser nulo");
        }
        if (alumnoDto.getNombre() == null || alumnoDto.getNombre().isEmpty() ||
            alumnoDto.getEmail() == null || alumnoDto.getEmail().isEmpty()) {
            throw new IllegalArgumentException("El nombre y el email del alumno no pueden estar vacíos");
        }
        if (alumnoDto.getEdad() < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }

        // Conversión DTO -> Entity
        AlumnoEntiti alumnoEntity = new AlumnoEntiti();
        alumnoEntity.setNombre(alumnoDto.getNombre());
        alumnoEntity.setEmail(alumnoDto.getEmail());
        alumnoEntity.setEdad(alumnoDto.getEdad());

        // Persistir usando Hibernate
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory();
            tx = session.beginTransaction();

            session.persist(alumnoEntity);

            tx.commit();

            System.out.println("Insertado alumno: " + alumnoEntity.getNombre() + " (id=" + alumnoEntity.getId() + ")");
        } catch (Exception e) {
            if (tx != null) {
                try {
                    tx.rollback();
                } catch (Exception ex) {
                    // ignore rollback exceptions
                }
            }
            throw new RuntimeException("Error al insertar el alumno en la base de datos", e);
        } finally {
            // No cerramos el Session aquí porque HibernateUtil gestiona la sesión compartida;
            // si se quisiera cerrar: if (session != null && session.isOpen()) session.close();
        }
    }
	
	// va a devolver el listado en un Stringbuilder para poder mostrarlo en el servlet.
	public List<AlumnoEntiti> listarAlumnos() {
	    Session session = null;

	    try {
	        session = HibernateUtil.getSessionFactory();

	        session.beginTransaction();

	        List<AlumnoEntiti> listado =
	                session.createQuery(
	                        "FROM AlumnoEntiti",
	                        AlumnoEntiti.class
	                ).list();

	        session.getTransaction().commit();

	        return listado;

	    } catch (Exception e) {
	        throw new RuntimeException(
	                "Error al listar los alumnos desde la base de datos", e
	        );
	    }
	}


}