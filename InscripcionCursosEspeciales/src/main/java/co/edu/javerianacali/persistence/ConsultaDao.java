package co.edu.javerianacali.persistence;

import co.edu.javerianacali.entities.CursoCopiado;
import co.edu.javerianacali.entities.CursoPeopleSoft;
import co.edu.javerianacali.entities.Parametro;
import co.edu.javerianacali.entities.Periodo;
import co.edu.javerianacali.entities.Profesor;
import co.edu.javerianacali.entities.TblConfiguracion;
import co.edu.javerianacali.interfaces.persistence.IConsultaDao;
//import co.edu.javerianacali.jdbc.NamedJdbcDao;
import co.edu.javerianacali.persistence.mappers.CursoCopiadoMapper;
import co.edu.javerianacali.persistence.mappers.CursoPeopleSoftMapper;
import co.edu.javerianacali.persistence.mappers.PeriodoMapper;
import co.edu.javerianacali.persistence.mappers.ProfesorMapper;
import co.edu.javerianacali.persistence.mappers.TblConfiguracionMapper;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class ConsultaDao implements IConsultaDao {

    public List<TblConfiguracion> getParametrosLDAP() {
    	List<TblConfiguracion> curso = new ArrayList<TblConfiguracion>();
        return curso;
    }

    public List<Periodo> getPeriodoActual() {
    	List<Periodo> curso = new ArrayList<Periodo>();
        return curso;
    }

    public List<Profesor> getCursosNombreCorreoDeProfesor(String oprid) {
    	List<Profesor> curso = new ArrayList<Profesor>();
        return curso;
       
    }

    public List<CursoPeopleSoft> getCursosProfesorEnUnPeriodo(String strm, String oprid) {
    	List<CursoPeopleSoft> curso = new ArrayList<CursoPeopleSoft>();
        return curso;
    }
    
    public List<CursoPeopleSoft> getCursosPorCatalogo(String strm, String catalogoNbr) {
    	List<CursoPeopleSoft> curso = new ArrayList<CursoPeopleSoft>();
        return curso;
    }
    
    public List<CursoPeopleSoft> getCursosExistePeople(String strm, String catalogoNbr) {
       //System.out.println("llego:"+catalogoNbr);
       //System.out.println("llego:"+strm);
    	List<CursoPeopleSoft> curso = new ArrayList<CursoPeopleSoft>();
        return curso;
    }

    public List<CursoCopiado> getCursosCopiadosPorCodigo(String codigo, String periodo, String grupo) {
       List<CursoCopiado> curso = new ArrayList<CursoCopiado>();
        return curso;
    }

    public void insertCopiaCurso(String codigo, String grupo, String periodo, String plantilla) {
       /* MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("codigo", codigo);
        namedParameters.addValue("grupo", grupo);
        namedParameters.addValue("periodo", periodo);
        namedParameters.addValue("plantilla", plantilla);
        String sql = "insert into ps_bb_integrated.cursos_origen (catalog_nbr, sesion, periodo, crse_id_template) values (:codigo, :grupo, :periodo, :plantilla)";
        this.getNamedParameterJdbcTemplate().update(sql, namedParameters);*/
    }

    public String insertCopiaCurso2(String codigo, String grupo, String periodo, String plantilla) {
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("codigo", codigo);
        namedParameters.addValue("grupo", grupo);
        namedParameters.addValue("periodo", periodo);
        namedParameters.addValue("plantilla", plantilla);
        //String sql = "insert into cursos_origen (catalog_nbr, sesion, periodo, crse_id_template) values (:codigo, :grupo, :periodo, :plantilla)";
        String sql = "insert into ps_bb_integrated.cursos_origen (catalog_nbr, sesion, periodo, crse_id_template) values (" + codigo + ", " + grupo + ", " + periodo + ", " + plantilla + ")";
        //this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
        return sql;
    }
    
    
    public List<Parametro> getMonitorPool() throws SQLException {
        
          List<Parametro> parametros = new ArrayList<Parametro>();
          return parametros;
    }

}