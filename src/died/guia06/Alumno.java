package died.guia06;

import java.util.List;


public class Alumno implements Comparable {

	private String nombre;
	private Integer nroLibreta;
	private Integer creditos;
	public List<Curso> cursando;
	public List<Curso> aprobados;
	

	public Alumno(String nom, int lib) {
		nombre=nom;
		nroLibreta=lib;
		creditos=0;
	}
	
	
	public int creditosObtenidos() {
		return creditos;
	}

	public void aprobar(Curso c) {
		this.creditos += c.getCreditos();
		cursando.remove(c);
		aprobados.add(c);
	}

	public void inscripcionAceptada(Curso c) {
		cursando.add(c);
	}
	
	public boolean equals(Alumno a) {
		if (this.nroLibreta == a.nroLibreta) {
			return true;
		}
		return false;
		
	}
	
	public Alumno comparar(Alumno a) {
		if(this.nombre.compareTo(a.nombre) < 0) {
			return this;
		}
		return a;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNroLibreta() {
		return nroLibreta;
	}

	public void setNroLibreta(Integer nroLibreta) {
		this.nroLibreta = nroLibreta;
	}
	
	
	

}
