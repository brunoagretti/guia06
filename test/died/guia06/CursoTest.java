package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CursoTest {

	@Test
	void InscribirTest() {

		Curso A = new Curso("Matematica I", 1, 2020, 1, 25, 0);
		Curso B = new Curso("Matematica II", 2, 2020, 50, 25, 0);
		Curso C = new Curso("Matematica III", 3, 2020, 50, 25, 0);
		Curso D = new Curso("Baile con ataúdes", 4, 2020, 50, 0, 25);
		Curso E = new Curso("Matematica inferior", 5, 2020, 50, 0, 0);
		Alumno a = new Alumno("facundo", 14);
		Alumno b = new Alumno("esteban", 15);
		Alumno c = new Alumno("zoe", 16);
		
		//Se inscriben los alumnos
		C.inscribirAlumno(a);
		C.inscribirAlumno(b);
		C.inscribirAlumno(c);
		assertTrue(C.getInscriptos().contains(a)&& C.getInscriptos().contains(b) && C.getInscriptos().contains(c));

		//Aprueba a y obtiene creditos
		a.aprobar(C);
		assertEquals(25, a.creditosObtenidos());
		
		//Sólo a se puede inscribir porque es el unico que tiene creditos
		D.inscribirAlumno(a);
		D.inscribirAlumno(b);
		D.inscribirAlumno(c);
		assertTrue(D.getInscriptos().contains(a));
		assertFalse(D.getInscriptos().contains(b));
		assertFalse(D.getInscriptos().contains(c));
		
		//a se puede inscribir en A y B, pero no en E porque ya esta inscripto en 3 cursos
		A.inscribirAlumno(a);
		B.inscribirAlumno(a);
		E.inscribirAlumno(a);
		assertFalse(E.getInscriptos().contains(a));

		
		//A se queda sin cupo porque a se inscribio anteriormente, entonces b no se puede inscribir
		A.inscribirAlumno(b);
		assertFalse(A.getInscriptos().contains(b));
		
		c.aprobar(D);
		assertTrue(c.aprobados.contains(D));
		
		
		}

}
