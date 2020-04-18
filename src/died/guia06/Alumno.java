package died.guia06;

import java.util.ArrayList;
import java.util.List;

import died.guia06.util.Registro;


public class Alumno implements Comparable<Alumno> {

	private String nombre;
	private Integer nroLibreta;
	private Integer creditos;
	public List<Curso> cursando;
	public List<Curso> aprobados;
	

	public Alumno(String nom, int lib) {
		nombre=nom;
		nroLibreta=lib;
		creditos=0;
		this.cursando = new ArrayList<Curso>();
		this.aprobados = new ArrayList<Curso>();
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

	@Override
    public String toString() {
        return nombre + " LU: " + nroLibreta;
    }

	@Override
	public int compareTo(Alumno o) {
		return this.getNombre().compareTo(o.getNombre());
	}
	
	
	

}
