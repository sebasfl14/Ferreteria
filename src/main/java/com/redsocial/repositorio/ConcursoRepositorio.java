package com.redsocial.repositorio;

import java.util.List;

import com.redsocial.entidad.Concurso;

public interface ConcursoRepositorio  {

	public abstract int elimina(int idConcurso) ;
	public abstract int inserta(Concurso  obj) ;
	public abstract int actualiza(Concurso obj) ;
	public abstract List<Concurso> lista(String filtro) ;

	
	
	
}
