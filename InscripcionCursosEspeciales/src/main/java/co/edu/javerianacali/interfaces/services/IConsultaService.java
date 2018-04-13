package co.edu.javerianacali.interfaces.services;

import co.edu.javerianacali.entities.CursoCopiado;
import co.edu.javerianacali.entities.CursoPeopleSoft;
import co.edu.javerianacali.entities.Parametro;
import co.edu.javerianacali.entities.Periodo;
import co.edu.javerianacali.entities.Profesor;
import co.edu.javerianacali.entities.TblConfiguracion;
import java.sql.SQLException;
import java.util.List;

public interface IConsultaService {

    List<TblConfiguracion> getParametrosLDAP();

    List<Periodo> getPeriodoActual();

    List<Profesor> getCursosNombreCorreoDeProfesor(String oprid);

    List<CursoPeopleSoft> getCursosProfesorEnUnPeriodo(String strm, String oprid);
    
    List<CursoPeopleSoft> getCursosPorCatalogo(String strm, String catalogoNbr);
    
    List<CursoPeopleSoft> getCursosExistePeople(String strm, String catalogoNbr);

    void insertCopiaCurso(String codigo, String grupo, String periodo, String plantilla);

    String insertCopiaCurso2(String codigo, String grupo, String periodo, String plantilla);

    List<CursoCopiado> getCursosCopiadosPorCodigo(String codigo, String periodo, String grupo);
    
    public List<Parametro> getMonitorPool() throws SQLException;
}
