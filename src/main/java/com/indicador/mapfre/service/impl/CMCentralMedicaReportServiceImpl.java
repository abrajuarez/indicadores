package com.indicador.mapfre.service.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.procedure.ProcedureCall;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.model.ReportCentralMedicaModel;
import com.indicador.mapfre.service.CMCentralMedicaReportService;
import com.indicador.mapfre.util.ConvertUtil;
import com.indicador.mapfre.util.ScriptReportCentralMedica;

import oracle.jdbc.OracleType;
import oracle.jdbc.internal.OracleTypes;


//import oracle.jdbc.OracleTypes;

@Service
public class CMCentralMedicaReportServiceImpl implements CMCentralMedicaReportService {
	private static final Logger logger = LogManager.getLogger(CMCentralMedicaReportServiceImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private void ejecutar() {
		
        int id = -1;
        Connection cn = null;

        

        try {
        	ResultSet rs = null; 
            // Carga el driver de oracle
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            
            // Conecta con la base de datos XE con el usuario system y la contraseña password
            cn = DriverManager.getConnection("jdbc:oracle:thin:@10.184.60.72:1521/WMT9DES", "USRWM9COM", "RWM93560");
            
            // Llamada al procedimiento almacenado
            CallableStatement cst = cn.prepareCall("{call XXMPF_BPM_CENTRAL_MED_01_PKG.xxmpf_consulta_excel_cms (?,?,?)}");

            
              
                
                // Parametro 1 del procedimiento almacenado
                cst.setString(1, "01/06/2019");
                cst.setString(2, "06/12/2019");
                
                // Definimos los tipos de los parametros de salida del procedimiento almacenado
                cst.registerOutParameter(3, OracleTypes.CURSOR);
                
                
                // Ejecuta el procedimiento almacenado
                cst.execute();
                rs = (java.sql.ResultSet)cst.getObject(3);
                // Se obtienen la salida del procedimineto almacenado
                while (rs.next()) {
                	//String name = rs.getString("NAME");
                }
                
                rs.close();

        } catch (SQLException ex) {
        	logger.info("Method: ejecutar Error: " + ex.getMessage()+" SqlState "+ex.getSQLState());
        	 ex.printStackTrace();
        } finally {
        	
            
    }
           
	}
	private void procedure() {
		//StoredProcedureQuery query = entityManager.createStoredProcedureQuery("XXMPF_BPM_CENTRAL_MED_01_PKG.xxmpf_consulta_excel_cms","CentralValueMapping","CentralValueMapping");
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("XXMPF_BPM_CENTRAL_MED_01_PKG.xxmpf_consulta_excel_cms","CentralValueMapping");
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, void.class, ParameterMode.REF_CURSOR);
       // query.registerStoredProcedureParameter(3, String.class, ParameterMode.OUT);
        //query.registerStoredProcedureParameter(4, String.class, ParameterMode.OUT);
       // query.registerStoredProcedureParameter(5, String.class, ParameterMode.OUT);
        
       query.setParameter(1, "06/06/2019");
        query.setParameter(2, "06/12/2019");
       
        
        
        

        query.execute();
        //List<Object[]> results = query.getResultList();
        
        List<ReportCentralMedicaModel> r = query.getResultList();
	}

	@Override
	public List<ReportCentralMedicaModel> findByCreationDate(String fechaInicial, String fechaFinal) {
StoredProcedureQuery query = entityManager.createStoredProcedureQuery("XXMPF_BPM_CENTRAL_MED_01_PKG.xxmpf_consulta_excel_cms","CentralValueMapping");
		
		query.registerStoredProcedureParameter(1, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(2, String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter(3, void.class, ParameterMode.REF_CURSOR);
        query.setParameter(1, fechaInicial);
        query.setParameter(2, fechaFinal);
        query.execute();
        List<ReportCentralMedicaModel> r = query.getResultList();
        logger.info("Method:reporte execute store a size = "+r.size());
        entityManager.close();
        return r;
	}
	/*public List<ReportCentralMedicaModel> findByCreationDate(String fechaInicial, String fechaFinal) {
		List<ReportCentralMedicaModel> listCentral = new ArrayList<ReportCentralMedicaModel>();
		procedure();
       logger.info("Method:reporte execute store a = ");
        List<Object[]> results = new ArrayList<Object[]>();//= query.getResultList();
		//List<Object[]> results = entityManager.createQuery(ScriptReportCentralMedica.REPORT+" AND cm.creationDate >= TO_DATE('"+fechaInicial+ "', 'DD/MM/YY') AND cm.creationDate <= TO_DATE('"+fechaFinal+"','DD/MM/YY')").getResultList();
		
		for(int index = 0;  index< results.size(); index++) {
			Object[] central = results.get(index);
			ReportCentralMedicaModel cm = new ReportCentralMedicaModel();
			
			cm.setCmcreationDate(ConvertUtil.objectToString(central[0]));
			cm.setCmcodSector(ConvertUtil.objectToString(central[1]));
			cm.setCmidTipoSolicitud(ConvertUtil.objectToString(central[2]));
			cm.setCmfolioReapertura(ConvertUtil.objectToString(central[3]));
			cm.setCmfolio(ConvertUtil.objectToString(central[4]));
			cm.setCmSubTipoTramite(ConvertUtil.objectToString(central[5]));
			cm.setCmtienePreautorizacion(ConvertUtil.objectToString(central[6]));
			cm.setCmfolioPreautorizacion(ConvertUtil.objectToString(central[7]));
			cm.setCmnombreProveedor(ConvertUtil.objectToString(central[8]));
			cm.setCmestadoRepublica(ConvertUtil.objectToString(central[9]));
			cm.setCmnivelHospitalario(ConvertUtil.objectToString(central[10]));
			cm.setCmfechaIngreso(ConvertUtil.objectToString(central[11]));
			cm.setCmurgencia(ConvertUtil.objectToString(central[12]));
			cm.setCmhabitacionAsignada(ConvertUtil.objectToString(central[13]));
			cm.setCmnumeroPoliza(ConvertUtil.objectToString(central[14]));
			cm.setCmramo(ConvertUtil.objectToString(central[15]));
			cm.setCmpolizaPagadaHasta(ConvertUtil.objectToString(central[16]));
			cm.setCminicioVigencia(ConvertUtil.objectToString(central[17]));
			cm.setCmfinVigencia(ConvertUtil.objectToString(central[18]));
			cm.setCmpolProcesoEmision(ConvertUtil.objectToString(central[19]));
			cm.setCmnombreContratante(ConvertUtil.objectToString(central[20]));
			cm.setCmrecienNacido(ConvertUtil.objectToString(central[21]));
			cm.setCmapellidoPaternoPaciente(ConvertUtil.objectToString(central[22]));
			cm.setCmapellidoMaternoPaciente(ConvertUtil.objectToString(central[23]));
			cm.setCmprimerNombrePaciente(ConvertUtil.objectToString(central[24]));
			cm.setCmsegundoNombrePaciente(ConvertUtil.objectToString(central[25]));
			cm.setCmnumeroRiesgo(ConvertUtil.objectToString(central[26]));
			cm.setCmfechaNacimientoPaciente(ConvertUtil.objectToString(central[27]));
			cm.setCmgeneroPaciente(ConvertUtil.objectToString(central[28]));
			cm.setCmtitularPoliza(ConvertUtil.objectToString(central[29]));
			cm.setCmmedicoRed(ConvertUtil.objectToString(central[30]));
			cm.setCmnombreMedico(ConvertUtil.objectToString(central[31]));
			cm.setCmespecialidadMedico(ConvertUtil.objectToString(central[32]));
			cm.setCmredProveedor(ConvertUtil.objectToString(central[33]));
			cm.setCmsintomasDiagnostico(ConvertUtil.objectToString(central[34]));
			cm.setCmfemiliarResponsable(ConvertUtil.objectToString(central[35]));
			cm.setCmtelFamiliarResponsable(ConvertUtil.objectToString(central[36]));
			cm.setCmnombreReportante(ConvertUtil.objectToString(central[37]));
			cm.setCmtelefonoReportante(ConvertUtil.objectToString(central[38]));
			cm.setCmemailReportante(ConvertUtil.objectToString(central[39]));
			cm.setCmobservacionesIngreso(ConvertUtil.objectToString(central[40]));
			cm.setCmnivelComplejidad(ConvertUtil.objectToString(central[41]));
			cm.setCmusuarioAsignado(ConvertUtil.objectToString(central[42]));
			cm.setCmtipoTramite(ConvertUtil.objectToString(central[43]));
			cm.setCmterritorioAtencion(ConvertUtil.objectToString(central[44]));
			cm.setCmtipoMoneda(ConvertUtil.objectToString(central[45]));
			cm.setCmfechaPrealtaHospitalaria(ConvertUtil.objectToString(central[46]));
			cm.setCmfechaEgresoHospitalaria(ConvertUtil.objectToString(central[47]));
			cm.setCmtieneInsumoRecobro(ConvertUtil.objectToString(central[48]));
			cm.setCmimporteEdoCuentaSdesv(ConvertUtil.objectToString(central[49]));
			cm.setCmdesviosEdoCuenta(ConvertUtil.objectToString(central[50]));
			cm.setCmbaseIndemnizacion(ConvertUtil.objectToString(central[51]));
			cm.setCmmontoAutHospital(ConvertUtil.objectToString(central[52]));
			cm.setCmmontoConIva(ConvertUtil.objectToString(central[53]));
			cm.setSinnumeroSiniestro(ConvertUtil.objectToString(central[54]));
			cm.setSinestado(ConvertUtil.objectToString(central[55]));
			cm.setSintipoSiniestro(ConvertUtil.objectToString(central[56]));
			cm.setSinporcentajeEdoCta(ConvertUtil.objectToString(central[57]));
			cm.setSinmontoSiniestro(ConvertUtil.objectToString(central[58]));
			cm.setSinfolioRam(ConvertUtil.objectToString(central[59]));
			cm.setSincodDiagnistico(ConvertUtil.objectToString(central[60]));
			cm.setSindescDiagnostico(ConvertUtil.objectToString(central[61]));
			cm.setSinfechaOcurrencia(ConvertUtil.objectToString(central[62]));
			cm.setSincausa(ConvertUtil.objectToString(central[63]));
			cm.setSinconsecuencia(ConvertUtil.objectToString(central[64]));
			cm.setSinfechaInicioSintomas(ConvertUtil.objectToString(central[65]));
			cm.setSincoberturaAfectada(ConvertUtil.objectToString(central[66]));
			cm.setSintipoPago(ConvertUtil.objectToString(central[67]));
			cm.setSintipoReserva(ConvertUtil.objectToString(central[68]));
			cm.setCptclaveCpt(ConvertUtil.objectToString(central[69]));
			cm.setCptdescripcionCpt(ConvertUtil.objectToString(central[70]));
			cm.setSindeducibleContratado(ConvertUtil.objectToString(central[71]));
			cm.setSinreduccionDeducible(ConvertUtil.objectToString(central[72]));
			cm.setSinincrementoDeducible(ConvertUtil.objectToString(central[73]));
			cm.setSintotalDeducible(ConvertUtil.objectToString(central[74]));
			cm.setSincoaseguroContratado(ConvertUtil.objectToString(central[75]));
			cm.setSinredCoaSeguroHosp(ConvertUtil.objectToString(central[76]));
			cm.setSinincCoaseguroHosp(ConvertUtil.objectToString(central[77]));
			cm.setSintopeCoaseguro(ConvertUtil.objectToString(central[78]));
			cm.setSintipoTopeCoaseguro(ConvertUtil.objectToString(central[79]));
			cm.setSintotalCoaseguroHosp(ConvertUtil.objectToString(central[80]));
			cm.setHmedintegrante(ConvertUtil.objectToString(central[81]));
			cm.setHmednombreMedico(ConvertUtil.objectToString(central[82]));
			cm.setHmedespecialidad(ConvertUtil.objectToString(central[83]));
			cm.setHmedmontoAutorizado(ConvertUtil.objectToString(central[84]));
			cm.setHmedfolioRam(ConvertUtil.objectToString(central[85]));
			cm.setHmedtipoPago(ConvertUtil.objectToString(central[86]));
			cm.setHmedtipoReserva(ConvertUtil.objectToString(central[87]));
			cm.setSintotalAutorizadoHm(ConvertUtil.objectToString(central[88]));
			cm.setSincoaseguroMedico(ConvertUtil.objectToString(central[89]));
			cm.setSinredCoaseguroMed(ConvertUtil.objectToString(central[90]));
			cm.setSintotalCoaseguroMed(ConvertUtil.objectToString(central[91]));
			cm.setCmcoaseguroMedico(ConvertUtil.objectToString(central[92]));
			cm.setCmtotalCargoPaciente(ConvertUtil.objectToString(central[93]));
			cm.setMediproveedor(ConvertUtil.objectToString(central[94]));
			cm.setMedidescripcionMedicamento(ConvertUtil.objectToString(central[95]));
			cm.setMedicodigoMedicamento(ConvertUtil.objectToString(central[96]));
			cm.setMedicantidad(ConvertUtil.objectToString(central[97]));
			cm.setMediprecioAutUnidad(ConvertUtil.objectToString(central[98]));
			cm.setSintotalAutorizadoMed(ConvertUtil.objectToString(central[99]));
			cm.setSinfolioRamMed(ConvertUtil.objectToString(central[100]));
			cm.setSindeducibleMedicamentos(ConvertUtil.objectToString(central[101]));
			cm.setSincoaseguroMedicamentos(ConvertUtil.objectToString(central[102]));
			cm.setSintotalMedicamentos(ConvertUtil.objectToString(central[103]));
			cm.setServiciotipoServicio(ConvertUtil.objectToString(central[104]));
			cm.setServiciorazonSocial(ConvertUtil.objectToString(central[105]));
			cm.setServiciocantidad(ConvertUtil.objectToString(central[106]));
			cm.setServicioprecioAutUnidad(ConvertUtil.objectToString(central[107]));
			cm.setSintotalAutorizadoServ(ConvertUtil.objectToString(central[108]));
			cm.setSinfolioRamServ(ConvertUtil.objectToString(central[109]));
			cm.setSindeducibleServicios(ConvertUtil.objectToString(central[110]));
			cm.setSincoaseguroServicios(ConvertUtil.objectToString(central[111]));
			cm.setSintotalServicios(ConvertUtil.objectToString(central[112]));
			cm.setCmbaseRechazo(ConvertUtil.objectToString(central[113]));
			cm.setValorMedicoTratante(ConvertUtil.objectToString(central[114]));
			cm.setValorEspecialidad(ConvertUtil.objectToString(central[115]));
			cm.setValorMontoAutorizado(ConvertUtil.objectToString(central[116]));
			cm.setValorTipoPago(ConvertUtil.objectToString(central[117]));
			cm.setValorTipoReserva(ConvertUtil.objectToString(central[118]));
			cm.setDocTipoDocumento(ConvertUtil.objectToString(central[119]));
			cm.setCmidSolicitud(Long.parseLong(ConvertUtil.objectToString(central[120])));
			
			listCentral.add(cm);
		}
		

		return listCentral;
	}*/

}
