package com.indicador.mapfre.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indicador.mapfre.entity.CMCentralMedica;
import com.indicador.mapfre.model.CMCentralMedicaModel;
import com.indicador.mapfre.repository.CMCentralMedicaRepository;
import com.indicador.mapfre.service.CMCentralMedicaService;
import com.indicador.mapfre.util.ScriptReportCentralMedica;
import com.indicador.mapfre.util.StringUtil;

@Service
public class CMCentralMedicaServiceImpl implements CMCentralMedicaService {
	
	private static final Logger logger = LogManager.getLogger(CMCentralMedicaServiceImpl.class);

	@Autowired
	private CMCentralMedicaRepository centralRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	@Override
	public List<Object[]> findAllByCreationDate2(String startDate, String finishDate) {
		//entityManager.createQuery(ScriptReportCentralMedica.REPORTQUERY+" AND cm.creationDate >= TO_DATE('"+startDate+ "', 'DD/MM/YY') AND cm.creationDate <= TO_DATE('"+finishDate+"','DD/MM/YY')").getResultList();
		
		List<Object[]> results = entityManager.createQuery(ScriptReportCentralMedica.REPORTQUERY+" AND cm.creationDate >= TO_DATE('"+startDate+ "', 'DD/MM/YY') AND cm.creationDate <= TO_DATE('"+finishDate+"','DD/MM/YY')").getResultList();
		
		return results;
	}
	
	@Override
	public List<CMCentralMedica> findAllByCreationDate(String dateStart, String dateFinish) {
		logger.info("Method:findAllByCreationDate");
		return centralRepository.findByCreation(dateStart, dateFinish);
	}
	
	@Override
	public List<CMCentralMedicaModel> reporte(String dateStart, String dateFinish){
		List<Object[]> listResult = findAllByCreationDate2(dateStart, dateFinish);
		List<CMCentralMedicaModel> listCentralMedica = new ArrayList<CMCentralMedicaModel>();
		
		//logger.info("Method:reporte add ["+l.get(0).getApellidoMaternoPaciente());
		
		for(int i = 0; i <listResult.size(); i++) {
			Object[] result = listResult.get(i);
			CMCentralMedicaModel central = new CMCentralMedicaModel();
			central.setIdSolicitud(StringUtil.convertObjectLong(result[0]));
			central.setCodSector(StringUtil.convertObjectLong(result[1]));
			central.setIdTipoSolicitud(StringUtil.convertObjectLong(result[2]));
			central.setFolio(StringUtil.convertObjetcToString(result[3]));
			central.setFolioReapertura(StringUtil.convertObjetcToString(result[4]));
			central.setTipoTramite(StringUtil.convertObjetcToString(result[5]));
			central.setSubTipoTramite(StringUtil.convertObjetcToString(result[6]));
			central.setTienePreautorizacion(StringUtil.convertObjetcToString(result[7]));
			central.setFolioPreautorizacion(StringUtil.convertObjetcToString(result[8]));
			central.setNombreProveedor(StringUtil.convertObjetcToString(result[9]));
			central.setEstadoRepublica(StringUtil.convertObjetcToString(result[10]));
			central.setNivelHospitalario(StringUtil.convertObjetcToString(result[11]));
			central.setFechaIngreso(StringUtil.convertObjetcToString(result[12]));
			central.setUrgencia(StringUtil.convertObjetcToString(result[13]));
			central.setHabitacionAsignada(StringUtil.convertObjetcToString(result[14]));
			central.setNumeroPoliza(StringUtil.convertObjetcToLong(result[15]));
			central.setRamo(StringUtil.convertObjetcToString(result[16]));
			central.setPolizaPagadaHasta(StringUtil.convertObjetcToString(result[17]));
			central.setInicioVigencia(StringUtil.convertObjetcToString(result[18]));
			central.setFinVigencia(StringUtil.convertObjetcToString(result[19]));
			central.setPolProcesoEmision(StringUtil.convertObjetcToString(result[20]));
			central.setNombreContratante(StringUtil.convertObjetcToString(result[21]));
			central.setRazonSocialContratante(StringUtil.convertObjetcToString(result[22]));
			central.setCategoriaAsegurado(StringUtil.convertObjetcToString(result[23]));
			central.setRecienNacido(StringUtil.convertObjetcToString(result[24]));
			central.setPrimerNombrePaciente(StringUtil.convertObjetcToString(result[25]));
			central.setSegundoNombrePaciente(StringUtil.convertObjetcToString(result[26]));
			central.setApellidoPaternoPaciente(StringUtil.convertObjetcToString(result[27]));
			central.setApellidoMaternoPaciente(StringUtil.convertObjetcToString(result[28]));
			central.setFechaNacimientoPaciente(StringUtil.convertObjetcToString(result[29]));
			central.setNumeroRiesgo(StringUtil.convertObjetcToLong(result[30]));
			central.setGeneroPaciente(StringUtil.convertObjetcToString(result[31]));
			central.setTitularPoliza(StringUtil.convertObjetcToString(result[32]));
			central.setMedicoRed(StringUtil.convertObjetcToString(result[33]));
			central.setNombreMedico(StringUtil.convertObjetcToString(result[34]));
			central.setEspecialidadMedico(StringUtil.convertObjetcToString(result[35]));
			central.setRedProveedor(StringUtil.convertObjetcToString(result[36]));
			central.setSintomasDiagnostico(StringUtil.convertObjetcToString(result[37]));
			central.setFemiliarResponsable(StringUtil.convertObjetcToString(result[38]));
			central.setTelFamiliarResponsable(StringUtil.convertObjetcToString(result[39]));
			central.setNombreReportante(StringUtil.convertObjetcToString(result[40]));
			central.setTelefonoReportante(StringUtil.convertObjetcToString(result[41]));
			central.setEmailReportante(StringUtil.convertObjetcToString(result[42]));
			central.setObservacionesIngreso(StringUtil.convertObjetcToString(result[43]));
			central.setEstatusTramite(StringUtil.convertObjetcToString(result[44]));
			central.setTienePrefacturas(StringUtil.convertObjetcToString(result[45]));
			central.setTieneHonMed(StringUtil.convertObjetcToString(result[46]));
			central.setTieneMedicamentos(StringUtil.convertObjetcToString(result[47]));
			central.setTieneServicios(StringUtil.convertObjetcToString(result[48]));
			central.setTerritorioAtencion(StringUtil.convertObjetcToString(result[49]));
			central.setTipoMoneda(StringUtil.convertObjetcToString(result[50]));
			central.setFechaEgresoHospitalaria(StringUtil.convertObjetcToString(result[51]));
			central.setTieneInsumoRecobro(StringUtil.convertObjetcToString(result[52]));
			central.setMontoAutProg(StringUtil.convertObjetcToString(result[53]));
			central.setImporteEdoCuentaSdesv(StringUtil.convertObjetcToString(result[54]));
			central.setDesviosEdoCuenta(StringUtil.convertObjetcToString(result[55]));
			central.setBaseIndemnizacion(StringUtil.convertObjetcToString(result[56]));
			central.setMontoAutHospital(StringUtil.convertObjetcToString(result[57]));
			central.setMontoConIva(StringUtil.convertObjetcToString(result[58]));
			central.setDeducibleConGastosNocub(StringUtil.convertObjetcToBigDecimal(result[59]));
			central.setCoaseguroMedico(StringUtil.convertObjetcToBigDecimal(result[60]));
			central.setTotalCargoPaciente(StringUtil.convertObjetcToString(result[61]));
			central.setBaseRechazo(StringUtil.convertObjetcToString(result[62]));
			central.setSubespecialidad(StringUtil.convertObjetcToString(result[63]));
			central.setDomicilioProveedor(StringUtil.convertObjetcToString(result[64]));
			central.setMontoAutorizadoSdava(StringUtil.convertObjetcToBigDecimal(result[65]));
			central.setFolioRamSgaval(StringUtil.convertObjetcToString(result[66]));
			central.setTelefonoUnoSdaval(StringUtil.convertObjetcToString(result[67]));
			central.setTelefonodosSdaval(StringUtil.convertObjetcToString(result[68]));
			central.setEmailUnoSdaval(StringUtil.convertObjetcToString(result[69]));
			central.setObservqacionesExternas(StringUtil.convertObjetcToString(result[70]));
			central.setObservacionesInternas(StringUtil.convertObjetcToString(result[71]));
			central.setUsuarioActual(StringUtil.convertObjetcToString(result[72]));
			central.setUsuarioReporte(StringUtil.convertObjetcToString(result[73]));
			central.setCorreoReporte(StringUtil.convertObjetcToString(result[74]));
			central.setUsuarioAsignado(StringUtil.convertObjetcToString(result[75]));
			central.setCorreoAsignado(StringUtil.convertObjetcToString(result[76]));
			central.setUsuarioDictaminador(StringUtil.convertObjetcToString(result[77]));
			central.setCorreoDictaminador(StringUtil.convertObjetcToString(result[78]));
			central.setTaskIdTomaReporte(StringUtil.convertObjetcToLong(result[79]));
			central.setTaskIdAsignacion(StringUtil.convertObjetcToLong(result[80]));
			central.setTaskIdDictaminacion(StringUtil.convertObjetcToLong(result[81]));
			central.setTaskIdActual(StringUtil.convertObjetcToLong(result[82]));
			central.setCreationDate(StringUtil.convertObjetcToString(result[83]));
			central.setCreateBy(StringUtil.convertObjetcToString(result[84]));
			central.setLastupdateDate(StringUtil.convertObjetcToString(result[85]));
			central.setLastUpdateBy(StringUtil.convertObjetcToString(result[86]));
			central.setTipoAsignacion(StringUtil.convertObjetcToString(result[87]));
			central.setNivelComplejidad(StringUtil.convertObjetcToString(result[88]));
			central.setTipoPagoSdaval(StringUtil.convertObjetcToString(result[89]));
			central.setTipoReservaSdal(StringUtil.convertObjetcToString(result[90]));
			central.setSubespecialidadSdaval(StringUtil.convertObjetcToString(result[91]));
			central.setDomicilioProveedorSdaval(StringUtil.convertObjetcToString(result[92]));
			central.setCiudadSdaval(StringUtil.convertObjetcToString(result[93]));
			central.setMunicipioSdaval(StringUtil.convertObjetcToString(result[94]));
			central.setTieneCartaPrefactura(StringUtil.convertObjetcToString(result[95]));
			central.setTramitadorReasignado(StringUtil.convertObjetcToString(result[96]));
			central.setEstado(StringUtil.convertObjetcToString(result[97]));
			central.setNumeroSiniestro(StringUtil.convertObjetcToLong(result[98]));
			central.setTipoSiniestro(StringUtil.convertObjetcToString(result[99]));
			central.setPorcentajeEdoCta(StringUtil.convertObjetcToInt(result[100]));
			central.setMontoSiniestro(StringUtil.convertObjetcToLong(result[101]));
			central.setFolioRam(StringUtil.convertObjetcToString(result[102]));
			central.setDescDiagnostico(StringUtil.convertObjetcToString(result[103]));
			central.setCodDiagnistico(StringUtil.convertObjetcToString(result[104]));
			central.setFechaOcurrencia(StringUtil.convertObjetcToString(result[105]));
			central.setCausa(StringUtil.convertObjetcToString(result[106]));
			central.setConsecuencia(StringUtil.convertObjetcToString(result[107]));
			central.setFechaInicioSintomas(StringUtil.convertObjetcToString(result[108]));
			central.setCoberturaAfectada(StringUtil.convertObjetcToString(result[109]));
			central.setTipoPago(StringUtil.convertObjetcToString(result[110]));
			central.setTipoReserva(StringUtil.convertObjetcToString(result[111]));
			central.setMontoReserva(StringUtil.convertObjetcToLong(result[112]));
			central.setRemanenteSumaAseg(StringUtil.convertObjetcToLong(result[113]));
			central.setTotalAutorizadoHm(StringUtil.convertObjetcToLong(result[114]));
			central.setFolioRamMed(StringUtil.convertObjetcToString(result[115]));
			central.setCiudadEntrega(StringUtil.convertObjetcToString(result[116]));
			central.setCodigoPostalEntrega(StringUtil.convertObjetcToString(result[117]));
			central.setDireccionEntrega(StringUtil.convertObjetcToString(result[118]));
			central.setTelContactoaseg(StringUtil.convertObjetcToString(result[119]));
			central.setCorreoNotifAseg(StringUtil.convertObjetcToString(result[120]));
			central.setTotalAutorizadoMed(StringUtil.convertObjetcToBigDecimal(result[121]));
			central.setFolioRamServ(StringUtil.convertObjetcToString(result[122]));
			
			central.setTotalAutorizadoServ(StringUtil.convertObjetcToString(result[123]));
			central.setDeducibleContratado(StringUtil.convertObjetcToLong(result[124]));
			central.setReduccionDeducible(StringUtil.convertObjetcToLong(result[125]));
			central.setIncrementoDeducible(StringUtil.convertObjetcToLong(result[126]));
			central.setTotalDeducible(StringUtil.convertObjetcToLong(result[127]));
			central.setCoaseguroContratado(StringUtil.convertObjetcToLong(result[128]));
			central.setRedCoaSeguroHosp(StringUtil.convertObjetcToLong(result[129]));
			central.setIncCoaseguroHosp(StringUtil.convertObjetcToLong(result[130]));
			central.setTopeCoaseguro(StringUtil.convertObjetcToLong(result[131]));
			central.setTipoTopeCoaseguro(StringUtil.convertObjetcToString(result[132]));
			central.setTotalCoaseguroHosp(StringUtil.convertObjetcToLong(result[133]));
			central.setRedCoaseguroMed(StringUtil.convertObjetcToLong(result[134]));	
			central.setTotalCoaseguroMed(StringUtil.convertObjetcToLong(result[135]));
			central.setReduccionCoaseguroMed(StringUtil.convertObjetcToString(result[136]));
			central.setTopeIndemnizacion(StringUtil.convertObjetcToString(result[137]));
			central.setTotalDeducibleMonto(StringUtil.convertObjetcToString(result[138]));
			central.setDeducibleMedicamentos(StringUtil.convertObjetcToString(result[139]));
			central.setCoaseguroMedicamentos(StringUtil.convertObjetcToString(result[140]));
			central.setTotalMedicamentos(StringUtil.convertObjetcToString(result[141]));
			central.setDeducibleServicios(StringUtil.convertObjetcToString(result[142]));
			central.setCoaseguroServicios(StringUtil.convertObjetcToString(result[143]));
			central.setTotalServicios(StringUtil.convertObjetcToString(result[144]));
			central.setTipoDocumento(StringUtil.convertObjetcToString(result[145]));
			central.setObservaciones(StringUtil.convertObjetcToString(result[146]));
			central.setNotificado(StringUtil.convertObjetcToString(result[147]));
			central.setRecibido(StringUtil.convertObjetcToString(result[148]));
			central.setIndiceProvider(StringUtil.convertObjetcToString(result[149]));
			central.setIntegrante(StringUtil.convertObjetcToString(result[150]));
			central.setEspecialidad(StringUtil.convertObjetcToString(result[151]));
			central.setMedicoTratante(StringUtil.convertObjetcToString(result[152]));
			central.setMontoAutorizado(StringUtil.convertObjetcToInt(result[153]));
			central.setSdafolioRam(StringUtil.convertObjetcToString(result[154]));
			central.setSdatipoPago(StringUtil.convertObjetcToString(result[155]));
			central.setSdatipoReserva(StringUtil.convertObjetcToString(result[156]));
			central.setSdaindiceProvider(StringUtil.convertObjetcToString(result[157]));
			central.setHintegrante(StringUtil.convertObjetcToString(result[158]));
			central.setHnombreMedico(StringUtil.convertObjetcToString(result[159]));
			central.setHespecialidad(StringUtil.convertObjetcToString(result[160]));
			central.setHmontoAutorizado(StringUtil.convertObjetcToBigDecimal(result[161]));
			central.setHfolioRam(StringUtil.convertObjetcToString(result[162]));
			central.setHtipoPago(StringUtil.convertObjetcToString(result[163]));
			central.setHtipoReserva(StringUtil.convertObjetcToString(result[164]));
			central.setHindiceProvider(StringUtil.convertObjetcToString(result[165]));
			central.setProveedor(StringUtil.convertObjetcToString(result[166]));
			central.setCodigoMedicamento(StringUtil.convertObjetcToString(result[167]));
			central.setDescripcionMedicamento(StringUtil.convertObjetcToString(result[168]));
			central.setCantidad(StringUtil.convertObjetcToInt(result[169]));
			central.setPrecioAutUnidad(StringUtil.convertObjetcToBigDecimal(result[170]));
			central.setTotalAutorizado(StringUtil.convertObjetcToBigDecimal(result[171]));
			central.setMindiceProvider(StringUtil.convertObjetcToString(result[172]));
			central.setRazonSocial(StringUtil.convertObjetcToString(result[173]));
			central.setTipoServicio(StringUtil.convertObjetcToString(result[174]));
			central.setSubtipoServicio(StringUtil.convertObjetcToString(result[175]));
			central.setSercantidad(StringUtil.convertObjetcToInt(result[176]));
			central.setSerprecioAutUnidad(StringUtil.convertObjetcToBigDecimal(result[177]));
			central.setSertotalAutorizado(StringUtil.convertObjetcToBigDecimal(result[178]));
			central.setSerindiceProvider(StringUtil.convertObjetcToString(result[179]));
			central.setDescripcionCpt(StringUtil.convertObjetcToString(result[180]));
			central.setClaveCpt(StringUtil.convertObjetcToString(result[181]));
			central.setProcsesocodSector(StringUtil.convertObjetcToInt(result[182]));
			central.setCodProceso(StringUtil.convertObjetcToInt(result[183]));
			central.setBitacodSector(StringUtil.convertObjetcToInt(result[184]));
			central.setNombreProceso(StringUtil.convertObjetcToString(result[185]));
			central.setNombreActividad(StringUtil.convertObjetcToString(result[186]));
			central.setFechaInicioActividad(StringUtil.convertObjetcToString(result[187]));
			central.setFechaFinActividad(StringUtil.convertObjetcToString(result[188]));
			central.setClaveEstatus(StringUtil.convertObjetcToString(result[189]));
			central.setSecuencia(StringUtil.convertObjetcToString(result[190]));
			central.setUsuarioEjecutivo(StringUtil.convertObjetcToString(result[191]));
			
			listCentralMedica.add(central);
		}
		
		 return listCentralMedica;
	}

}
