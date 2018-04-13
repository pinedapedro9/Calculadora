/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.persistence.mappers;

import co.edu.javerianacali.entities.Profesor;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author afgomez
 */
public class ProfesorMapper implements RowMapper<Profesor> {

    public Profesor mapRow(ResultSet rs, int row) throws SQLException {
        Profesor pro = new Profesor();
        pro.setNombre(rs.getString(1));
        pro.setCorreo(rs.getString(2));
        pro.setUsuario(rs.getString(3));
        return pro;
    }
}
