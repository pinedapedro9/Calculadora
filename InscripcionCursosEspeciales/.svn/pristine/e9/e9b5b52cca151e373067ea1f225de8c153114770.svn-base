package co.edu.javerianacali.persistence.mappers;

import co.edu.javerianacali.entities.CursoCopiado;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author afgomez
 */
public class CursoCopiadoMapper implements RowMapper<CursoCopiado> {

    public CursoCopiado mapRow(ResultSet rs, int row) throws SQLException {
        CursoCopiado curso = new CursoCopiado();
        curso.setCatalog_nbr(rs.getString(1));
        curso.setSesion(rs.getString(2));
        curso.setPeriodo(rs.getString(3));
        curso.setCrse_id_template(rs.getString(4));
        return curso;
    }
}
