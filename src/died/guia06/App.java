package died.guia06;

public class App {

	public static void main(String[] args) {
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
		

		//Aprueba a y obtiene creditos
		a.aprobar(C);
		
		
		//Sólo a se puede inscribir porque es el unico que tiene creditos
		D.inscribirAlumno(a);
		D.inscribirAlumno(b);
		D.inscribirAlumno(c);
		
		
		//a se puede inscribir en A y B, pero no en E porque a ya esta inscripto en 3 cursos
		A.inscribirAlumno(a);
		B.inscribirAlumno(a);
		E.inscribirAlumno(a);
		
		//A se queda sin cupo porque a se inscribio anteriormente, entonces b no se puede inscribir
		A.inscribirAlumno(b);
		
		B.inscribirAlumno(b);
		B.inscribirAlumno(c);
		System.out.print("Los alumnos del curso " + B.getNombre() + " son: ");
		B.imprimirInscriptos();
		
		
		
		}
	}
