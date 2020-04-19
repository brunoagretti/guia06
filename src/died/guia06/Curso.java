package died.guia06;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import died.guia06.util.Registro;

/**
 * Clase que representa un curso. Un curso se identifica por su ID y por su nombre y ciclo lectivo.
 * Un curso guarda una lista de los inscriptos actuales que tienen.
 * Un curso, al aprobarlo, otorga una cantidad de creditos definidas en el curso.
 * Un curso requiere que para inscribirnos tengamos al menos la cantidad de creditos requeridas, y que haya cupo disponible
 * @author marti
 *
 */
public class Curso {

	public List<Alumno> getInscriptos() {
		return inscriptos;
	}


	public void setInscriptos(List<Alumno> inscriptos) {
		this.inscriptos = inscriptos;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getCicloLectivo() {
		return cicloLectivo;
	}


	public void setCicloLectivo(Integer cicloLectivo) {
		this.cicloLectivo = cicloLectivo;
	}


	public Integer getCupo() {
		return cupo;
	}


	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}


	public Integer getCreditosRequeridos() {
		return creditosRequeridos;
	}


	public void setCreditosRequeridos(Integer creditosRequeridos) {
		this.creditosRequeridos = creditosRequeridos;
	}
	

	public Integer getCreditos() {
		return creditos;
	}


	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}


	private Integer id;
	private String nombre;
	private Integer cicloLectivo;
	private Integer cupo; 
	private List<Alumno> inscriptos;
	private Integer creditos;
	private Integer creditosRequeridos;
	
	private Registro log;
	
	public Curso() {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.creditos=0;
		this.cupo = 0;
	}
	
	public Curso(String nombre, int id, int ciclo, int cupo, int creditos, int creditReq) {
		super();
		this.inscriptos = new ArrayList<Alumno>();
		this.log = new Registro();
		this.nombre=nombre;
		this.id=id;
		this.cicloLectivo=ciclo;
		this.creditos=creditos;
		this.cupo = cupo;
		this.creditosRequeridos=creditReq;
	}
	



	/**
	 * Este método, verifica si el alumno se puede inscribir y si es así lo agrega al curso,
	 * agrega el curso a la lista de cursos en los que está inscripto el alumno y retorna verdadero.
	 * Caso contrario retorna falso y no agrega el alumno a la lista de inscriptos ni el curso a la lista
	 * de cursos en los que el alumno está inscripto.
	 * 
	 * Para poder inscribirse un alumno debe
	 * 		a) tener como minimo los creditos necesarios
	 *      b) tener cupo disponibles
	 *      c) puede estar inscripto en simultáneo a no más de 3 cursos del mismo ciclo lectivo.
	 * @param a
	 * @return
	 */
	public Boolean inscribir(Alumno a) throws FaltanCreditosException, CupoException, MaxMateriasException, RegistroAuditoriaException {
		try {
			if(a.creditosObtenidos()<creditosRequeridos) {
				throw new FaltanCreditosException();
			} else {
				if(inscriptos.size()>=cupo) {
					throw new CupoException();
				} else {
					if (a.cursando.size()>=3) {
						throw new MaxMateriasException();
					}
				}
			}
			log.registrar(this, "inscribir ",a.toString());
			inscriptos.add(a);
			a.inscripcionAceptada(this);
			return true;
		} catch (IOException e1) {
			throw new RegistroAuditoriaException();
		}
		
	}
	
	public void inscribirAlumno(Alumno a) {
		try {
			inscribir(a);
		} catch(FaltanCreditosException e1) {
			System.out.println("El alumno no tiene los creditos necesarios para inscribirse.");
		} catch(CupoException e2) {
			System.out.println("Este curso se ha quedado sin cupos");
		} catch(MaxMateriasException e3) {
			System.out.println("El alumno ya est� inscripto a 3 materias");
		} catch(RegistroAuditoriaException e4) {
			System.out.println("Ha ocurrido un error: " + e4);
		}
	}
	
	
	
	
	/** 
	 * imprime los inscriptos en orden alfabetico
	 */
	public void imprimirInscriptos() {
		try {
			Collections.sort(inscriptos);
			System.out.println(inscriptos);
			log.registrar(this, "imprimir listado",this.inscriptos.size()+ " registros ");
		} catch (IOException e2) {
			System.out.println("Ha ocurrido un error: " + e2);
		}
	}
	
	@Override
    public String toString() {
        return "Curso " + nombre + " ID: " + id;
    }


}
