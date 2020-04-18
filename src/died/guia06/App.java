package died.guia06;

public class App {

	public static void main(String[] args) {
		Curso c = new Curso("afdpijsd", 4, 2020, 50, 0);
		Alumno a = new Alumno("facundo", 1234);
		Alumno b = new Alumno("esteban", 1235);
		c.inscribir(a);
		c.inscribir(b);
		c.imprimirInscriptos();
		
	}
}
