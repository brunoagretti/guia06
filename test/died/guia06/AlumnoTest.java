package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AlumnoTest {

	@Test
	void testCreditosObtenidos() {
		Alumno a = new Alumno("pedro", 1234);
		Curso c = new Curso();
		c.setCreditos(25);
		a.aprobar(c);
		int creditosObt = a.creditosObtenidos();
		assertEquals(25, creditosObt);
		
	}

	@Test
	void testAprobar() {
		Alumno a = new Alumno("pedro", 1234);
		Curso c = new Curso();
		c.setCreditos(25);
		a.aprobar(c);
		assertTrue(a.aprobados.contains(c));
		assertTrue(a.cursando.isEmpty());
		assertEquals(25, a.creditosObtenidos());
	}

	@Test
	void testInscripcionAceptada() {
		Alumno a = new Alumno("pedro", 1234);
		Curso c = new Curso();
		a.inscripcionAceptada(c);
		assertTrue(a.cursando.contains(c));
	}

}
