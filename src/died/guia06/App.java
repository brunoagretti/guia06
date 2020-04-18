package died.guia06;

public class App {

	public static void main(String[] args) {
		Curso C = new Curso("afdpijsd", 4, 2020, 50, 0);
		Alumno a = new Alumno("facundo", 14);
		Alumno b = new Alumno("esteban", 15);
		Alumno c = new Alumno("zoe", 16);
		C.inscribir(a);
		C.inscribir(b);
		C.inscribir(c);
		C.imprimirInscriptos();
		
	}
}
