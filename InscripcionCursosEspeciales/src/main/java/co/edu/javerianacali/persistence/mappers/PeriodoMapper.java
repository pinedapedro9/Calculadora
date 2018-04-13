/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.javerianacali.persistence.mappers;

import co.edu.javerianacali.entities.Periodo;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author afgomez
 */
public class PeriodoMapper implements RowMapper<Periodo> {

    public Periodo mapRow(ResultSet rs, int row) throws SQLException {
        Periodo per = new Periodo();
        per.setStrm(rs.getString(1));
        per.setPeriodo(rs.getString(2));
        return per;
    }
}
