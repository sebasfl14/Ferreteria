package com.redsocial.repositorio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.redsocial.entidad.Concurso;

@Repository
public class ConcursoMySqlRepositorio implements ConcursoRepositorio{

	@Autowired
    private JdbcTemplate jdbcTemplate ;

	@Override
	public int elimina(int idConcurso) {
		 return jdbcTemplate.update("delete from concurso where idconcurso=?", new Object[] { idConcurso});
	}

	@Override
	public int inserta(Concurso obj) {
		 return jdbcTemplate.update("insert into concurso values(null,?,?,?,?)", new Object[] { obj.getNombre(), obj.getFechaInicio(), obj.getFechaFin(), obj.getEstado() });
	}

	@Override
	public int actualiza(Concurso obj) {
		 return jdbcTemplate.update("update concurso set nombre =?, fechainicio =?, fechafin =?, estado =? where idconcurso =? ", new Object[] { obj.getNombre(), obj.getFechaInicio(), obj.getFechaFin(), obj.getEstado(), obj.getIdConcurso()});
	}

	@Override
	public List<Concurso> lista(String filtro) {
		List<Concurso> lista = jdbcTemplate.query("select * from concurso where nombre like ? ",new Object[] { filtro+"%" }, new RowMapper<Concurso>() {
            @Override
            public Concurso mapRow(ResultSet rs, int arg1) throws SQLException {
            	Concurso obj = new Concurso();
            	obj.setIdConcurso(rs.getInt("idconcurso"));
            	obj.setNombre(rs.getString("nombre"));
            	obj.setFechaInicio(rs.getString("fechaInicio"));
            	obj.setFechaFin(rs.getString("fechaFin"));
            	obj.setEstado(rs.getString("estado"));
                return obj;
            }
        });
        return lista;
	}

	



	
	
	
	
}
