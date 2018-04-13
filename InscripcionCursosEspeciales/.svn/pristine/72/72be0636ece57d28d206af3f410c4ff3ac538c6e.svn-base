package co.edu.javerianacali.persistence.mappers;

import co.edu.javerianacali.entities.CursoPeopleSoft;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author afgomez
 */
public class CursoPeopleSoftMapper implements RowMapper<CursoPeopleSoft> {

    public CursoPeopleSoft mapRow(ResultSet rs, int row) throws SQLException {
        CursoPeopleSoft curso = new CursoPeopleSoft();
        curso.setUsuario(rs.getString(1));
        curso.setCodigoCurso(rs.getString(2));
        curso.setNombreCurso(rs.getString(3));
        curso.setGrupo(rs.getString(4));
        curso.setTipoCurso(rs.getString(5));
        curso.setIdCurso(rs.getInt(6));
        return curso;
    }
}
