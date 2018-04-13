package co.edu.javerianacali.services;

import co.edu.javerianacali.entities.CursoBlackboard;
import co.edu.javerianacali.interfaces.services.IExcelService;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author afgomez
 */
@Service
@Transactional()
public class ExcelService implements IExcelService {

    public String getPlantillaDeExcel(HttpServletRequest request, String usuario, String codCurso) {

        String campoPlantilla;
        try {
        	HttpServletRequestWrapper srw = new HttpServletRequestWrapper(request);
            String ruta = srw.getRealPath("");
            //ruta += "/resources/archivos/ListaUsuariosPorAsginatura.xls";
            //System.out.println(ruta);
            //POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(ruta));
            ruta = "http://javevirtual.javerianacali.edu.co/jv/joomla/Excel%20aplicaciones/ListaUsuariosPorAsginatura.xls";
            System.out.println(ruta);
            InputStream is;
            is = new URL(ruta).openStream();
            POIFSFileSystem fs = new POIFSFileSystem(is);
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);

            boolean terminoLectura = false;
            //boolean encontrado = false;
            int i = 0;

            while (terminoLectura == false) {

                HSSFRow row1 = sheet.getRow(i);
                if (row1 != null) {
                    HSSFCell celda1 = row1.getCell(0);
                    HSSFCell celda2 = row1.getCell(1);

                    if (celda1 != null) {
                        String nombreUsuario = celda2.getStringCellValue();
                        campoPlantilla = celda1.getStringCellValue();

                        String[] separa = campoPlantilla.split("-");

                        String codigoCurso = separa[0];

                        if (nombreUsuario != null) {
                            

                            if (nombreUsuario.equalsIgnoreCase(usuario) && codigoCurso.equalsIgnoreCase(codCurso)) {

                                return campoPlantilla;

                            }
                        } else {
                            terminoLectura = true;
                        }
                    } else {
                        terminoLectura = true;
                    }
                } else {
                    terminoLectura = true;
                }

                i++;
            }

////            if (encontrado == true) {
////            } else {
////                System.out.println("No se ha encontrado al usuario " + usuario);
////            }

        } catch (Exception e) {
            Logger.getLogger(ExcelService.class.getName()).log(Level.SEVERE, null, e);
        }

        return "plantilla";
    }

    public List getCursosProfesorBlackboard(HttpServletRequest request, String usuario) {
        List cursosBlackboard = new ArrayList();
        try {
            HttpServletRequestWrapper srw = new HttpServletRequestWrapper(request);
            String ruta = srw.getRealPath("");
            ruta += "/resources/archivos/ListaUsuariosPorAsginatura20122.xls";
            
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(ruta));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);

            boolean terminoLectura = false;
            boolean encontrado = false;
            int i = 1;

            while (terminoLectura == false) {

                HSSFRow row1 = sheet.getRow(i);
                if (row1 != null) {
                    HSSFCell celda1 = row1.getCell(0);
                    HSSFCell celda2 = row1.getCell(1);
                    HSSFCell celda3 = row1.getCell(2);

                    if (celda1 != null) {
                        String nombreUsuario = celda2.getStringCellValue();
                        String codigoCurso = celda1.getStringCellValue();
                        String nombreCurso = celda3.getStringCellValue();
                        

                        

                        if (nombreUsuario != null) {
                            

                            if (nombreUsuario.equalsIgnoreCase(usuario) ) {
                                CursoBlackboard cursoBlackboard = new CursoBlackboard();
                                cursoBlackboard.setCodigo(codigoCurso);
                                cursoBlackboard.setNombre(nombreCurso);
                                cursosBlackboard.add(cursoBlackboard);
                            }
                        } else {
                            terminoLectura = true;
                        }
                    } else {
                        terminoLectura = true;
                    }
                } else {
                    terminoLectura = true;
                }

                i++;
            }

//            if (encontrado == true) {
//            } else {
//                System.out.println("No se ha encontrado al usuario " + usuario);
//            }

        } catch (Exception e) {
            Logger.getLogger(ExcelService.class.getName()).log(Level.SEVERE, null, e);
        }

        return cursosBlackboard;
    }
}
