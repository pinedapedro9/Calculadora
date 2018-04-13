package co.edu.javerianacali.persistence.mappers;

import co.edu.javerianacali.entities.TblConfiguracion;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author afgomez
 */
public class TblConfiguracionMapper implements RowMapper<TblConfiguracion> {

    public TblConfiguracion mapRow(ResultSet rs, int row) throws SQLException {
        TblConfiguracion configuracion = new TblConfiguracion();
        configuracion.setNidConfiguracion(rs.getDouble("nidconfiguracion"));
        configuracion.setVcParametro(rs.getString("vcparametro"));
        configuracion.setVcValor(rs.getString("vcvalor"));
        return configuracion;
    }
}
