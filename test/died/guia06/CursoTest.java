package died.guia06;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CursoTest {

	@Test
	void test() {
		Curso C = new Curso("afdpijsd", 4, 2020, 50, 0, 0);
		Alumno a = new Alumno("facundo", 14);
		Alumno b = new Alumno("esteban", 15);
		Alumno c = new Alumno("zoe", 16);
		try {
			C.inscribir(a);
		} catch (FaltanCreditosException | CupoException | MaxMateriasException | RegistroAuditoriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			C.inscribir(b);
		} catch (FaltanCreditosException | CupoException | MaxMateriasException | RegistroAuditoriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			C.inscribir(c);
		} catch (FaltanCreditosException | CupoException | MaxMateriasException | RegistroAuditoriaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3, C.getInscriptos().size());
		ArrayList<Alumno> listaAux = new ArrayList<Alumno>();
		listaAux.add(b);
		listaAux.add(a);
		listaAux.add(c);
		assertEquals(listaAux, C.getInscriptos());
		
		}

}
