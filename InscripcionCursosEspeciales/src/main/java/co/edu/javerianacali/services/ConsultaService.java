package co.edu.javerianacali.services;

import co.edu.javerianacali.entities.CursoCopiado;
import co.edu.javerianacali.entities.CursoPeopleSoft;
import co.edu.javerianacali.entities.Parametro;
import co.edu.javerianacali.entities.Periodo;
import co.edu.javerianacali.entities.Profesor;
import co.edu.javerianacali.entities.TblConfiguracion;
import co.edu.javerianacali.interfaces.persistence.IConsultaDao;
import co.edu.javerianacali.interfaces.services.IConsultaService;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional()
public class ConsultaService implements IConsultaService {

    @Autowired
    IConsultaDao consultaDao;

    public List<TblConfiguracion> getParametrosLDAP() {
        return consultaDao.getParametrosLDAP();
    }

    public List<Periodo> getPeriodoActual() {
        return consultaDao.getPeriodoActual();
    }

    public List<Profesor> getCursosNombreCorreoDeProfesor(String oprid) {
        return consultaDao.getCursosNombreCorreoDeProfesor(oprid);
    }

    public List<CursoPeopleSoft> getCursosProfesorEnUnPeriodo(String strm, String oprid) {
        return consultaDao.getCursosProfesorEnUnPeriodo(strm, oprid);
    }
    
    public List<CursoPeopleSoft> getCursosPorCatalogo(String strm, String catalogoNbr) {
        return consultaDao.getCursosPorCatalogo(strm, catalogoNbr);
    }
    
    public List<CursoPeopleSoft> getCursosExistePeople(String strm, String catalogoNbr) {
        return consultaDao.getCursosExistePeople(strm, catalogoNbr);
    }

    public void insertCopiaCurso(String codigo, String grupo, String periodo, String plantilla) {
        consultaDao.insertCopiaCurso(codigo, grupo, periodo, plantilla);
    }

    public String insertCopiaCurso2(String codigo, String grupo, String periodo, String plantilla) {
        return consultaDao.insertCopiaCurso2(codigo, grupo, periodo, plantilla);
    }

    public List<CursoCopiado> getCursosCopiadosPorCodigo(String codigo, String periodo, String grupo) {
        return consultaDao.getCursosCopiadosPorCodigo(codigo, periodo, grupo);
    }
    

    
    public List<Parametro> getMonitorPool() throws SQLException {
          return consultaDao.getMonitorPool();
    }

}
