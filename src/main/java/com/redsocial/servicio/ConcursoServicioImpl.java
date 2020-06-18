package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Concurso;
import com.redsocial.repositorio.ConcursoRepositorio;

@Service
public class ConcursoServicioImpl implements ConcursoServicio {

	@Autowired
	private ConcursoRepositorio repositorio;

	@Override
	public int eliminaConcurso(int idConcurso) {
		return repositorio.elimina(idConcurso);
	}

	@Override
	public int insertaConcurso(Concurso obj) {
		return repositorio.inserta(obj);
	}

	@Override
	public int actualizaConcurso(Concurso obj) {
		return repositorio.actualiza(obj);
	}

	@Override
	public List<Concurso> listaConcurso(String filtro) {
		return repositorio.lista(filtro);
	}



}






