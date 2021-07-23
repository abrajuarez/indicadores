package com.indicador.mapfre.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CMReportUtil {
	
	public static String getSector(Long codSector) {
		Optional<Long> opt = Optional.ofNullable(codSector);
		Long result = opt.orElse(0L);
		
		if(result == 1) {
			return "VIDA";
		}
		if(result == 2) {
			return "AyE";
		}
		if(result == 3) {
			return "DAÑOS";
		}
		if(result == 4) {
		return "AUTOS";
		}
		return "";
		
	}
	
	

	public static List<String> title(){
		List<String> list = new ArrayList<String>();
		list.add("FECHA DE CREACION");
		list.add("HORA DE CREACION");
		list.add("SECTOR");
		list.add("TIPO DE SOLICITUD");
		list.add("FOLIO BPM");
		list.add("FOLIO CARTA");
		list.add("FOLIO TRAMITE");
		list.add("SUBTIPO TRAMITE");
		list.add("FOLIO PRE-AUTORIZACION");
		list.add("NO. FOLIO PRE-AUTORIZACION");
		list.add("PROVEEDOR HOSPITALARIO");
		list.add("ESTADO");
		list.add("NIVEL HOSPITALRIO");
		list.add("FECHA DE INGRESO");
		list.add("HORA DE INGRESO");
		list.add("URGENCIAS");
		list.add("HABITACION ASIGNADA");
		list.add("NUMERO POLIZA");
		list.add("RAMO");
		list.add("PAGADA HASTA");
		list.add("INICIO VIGENCIA");
		list.add("FIN VIGENCIA");
		list.add("POLIZA EN PROCESO EMISION");
		list.add("CONTRATANTE");
		list.add("RECIEN NACIDO/RIESGO NO ENCONTRADO");
		list.add("RIESGO APELLIDO 1");
		list.add("RIESGO APELLIDO 2");
		list.add("RIESGO NOMBRE 1");
		list.add("RIESGO NOMBRE 2");
		list.add("NUMERO RIESGO");
		list.add("RIESGO FECHA NACIMIENTO");
		list.add("RIESGO GENERO");
		list.add("RIESGO TITULAR DE POLIZA");
		list.add("MEDICO RED");
		list.add("NOMBRE MEDICO TRATANTE");
		list.add("ESPECIALIDAD");
		list.add("TIPO RED MEDICO");
		list.add("SINTOMAS");
		list.add("FAMILIAR RESPONSABLE");
		list.add("TELEFONO FAMILIAR");
		list.add("REPORTANTE");
		list.add("TELEFONO REPORTANTE");
		list.add("CORREO REPORTANTE");
		list.add("OBSERVACIONES");
		list.add("FECHA CIERRE REPORTE");
		list.add("HORA CIERRE REPORTE");
		list.add("USUARIO REPORTE");
		list.add("NIVEL COMPLEJIDAD");
		list.add("USUARIO ASIGNADO");
		list.add("FECHA ASIGNACION");
		list.add("HORA ASIGNACION");
		list.add("NOMBRE ASIGNADOR");
		list.add("TIPO TRAMITE");
		
		//list.add("TIPO TRAMITE 2");
		list.add("TERRITORIO");
		list.add("TIPO MONEDA");
		list.add("FECHA PRE-ALTA");
		list.add("HORA PRE-ALTA");
		list.add("FECHA EGRESO");
		list.add("HORA EGRESO");
		list.add("INSUMOS RECOBROS");
		list.add("IMPORTE EDO CUENTA SIN DESVIOS");
		list.add("DESVIOS EDO CUENTA");
		list.add("BASE INDEMNIZACION");
		list.add("MONTO AUT HOSPITAL");
		list.add("MONTO CON IVA");
		list.add("NO. SINIESTRO 1");
		list.add("ESTADO SINIESTRO 1");
		list.add("TIPO DE SINIESTRO 1");
		list.add("% EDO CUENTA 1");
		list.add("MONTO SINIESTRO 1");
		list.add("RAM HOSP SINIESTRO 1");
		list.add("NO.ICD");
		list.add("DESCRIPCIÓN ICD");
		list.add("FECHA OCURRIDO");
		list.add("CAUSA");
		list.add("CONSECUENCIA");
		list.add("INICIO SINTOMAS");
		list.add("COBERTURA AFECTADA");
		list.add("TIPO PAGO");
		list.add("TIPO RESERVA");
		list.add("MONTO RESERVA");
		list.add("NO.CPT1");
		list.add("DESCRIPCIÓN CPT1");
		list.add("NO.CPT2");
		list.add("DESCRIPCIÓN CPT2");
		list.add("NO.CPT3");
		list.add("DESCRIPCIÓN CPT3");
		list.add("NO.CPT4");
		list.add("DESCRIPCIÓN CPT4");
		list.add("NO.CPT");
		list.add("DESCRIPCIÓN CPT N");
		list.add("DED1 CONTRATADO");
		list.add("REDUCCIÓN DED1");
		list.add("INCREMENTO DED1");
		list.add("TOTAL DED1");
		list.add("COA1 HOSP CONTRATADO");
		list.add("REDUCCION COA1 HOSP");
		list.add("INCREMENTO COA1 HOSP");
		list.add("TOPE COA1 HOSP");
		list.add("CON TOPE COA1 HOSP");
		list.add("SIN TOPE COA1 HOSP");
		list.add("TOPE ALCANZADO COA1 HOSP");
		list.add("TOTAL COA1 HOSP");
		list.add("INTEGRANTE 1");
		list.add("NOMBRE MEDICO 1");
		list.add("ESPECIALIDAD 1");
		list.add("MONTO  AUTORIZADO 1");
		list.add("FOLIO RAM 1");
		list.add("TIPO DE PAGO 1");
		list.add("TIPO RESERVA 1");
		list.add("INTEGRANTE 2");
		list.add("NOMBRE MEDICO 2");
		list.add("ESPECIALIDAD 2");
		list.add("MONTO  AUTORIZADO 2");
		list.add("FOLIO RAM 2");
		list.add("TIPO DE PAGO 2");
		list.add("TIPO RESERVA 2");
		list.add("INTEGRANTE 3");
		list.add("NOMBRE MÉDICO 3");
		list.add("ESPECIALIDAD 3");
		list.add("MONTO  AUTORIZADO 3");
		list.add("FOLIO RAM 3");
		list.add("TIPO DE PAGO 3");
		list.add("TIPO RESERVA 3");
		list.add("INTEGRANTE 4");
		list.add("NOMBRE MEDICO 4");
		list.add("ESPECIALIDAD 4");
		list.add("MONTO  AUTORIZADO 4");
		list.add("FOLIO RAM 4");
		list.add("TIPO DE PAGO 4");
		list.add("TIPO RESERVA 4");
		list.add("INTEGRANTE 5");
		list.add("NOMBRE MÉDICO 5");
		list.add("ESPECIALIDAD 5");
		list.add("MONTO  AUTORIZADO 5");
		list.add("FOLIO RAM 5");
		list.add("TIPO DE PAGO 5");
		list.add("TIPO RESERVA 5");
		list.add("INTEGRANTE 6");
		list.add("NOMBRE MÉDICO 6");
		list.add("ESPECIALIDAD 6");
		list.add("MONTO  AUTORIZADO 6");
		list.add("FOLIO RAM 6");
		list.add("TIPO DE PAGO 6");
		list.add("TIPO RESERVA 6");
		list.add("INTEGRANTE 7");
		list.add("NOMBRE MEDICO 7");
		list.add("ESPECIALIDAD 7");
		list.add("MONTO  AUTORIZADO 7");
		list.add("FOLIO RAM 7");
		list.add("TIPO DE PAGO 7");
		list.add("TIPO RESERVA 7");
		list.add("INTEGRANTE 8");
		list.add("NOMBRE MÉDICO 8");
		list.add("ESPECIALIDAD 8");
		list.add("MONTO  AUTORIZADO 8");
		list.add("FOLIO RAM 8");
		list.add("TIPO DE PAGO 8");
		list.add("TIPO RESERVA 8");
		list.add("INTEGRANTE 9");
		list.add("NOMBRE MEDICO 9");
		list.add("ESPECIALIDAD 9");
		list.add("MONTO  AUTORIZADO 9");
		list.add("FOLIO RAM 9");
		list.add("TIPO DE PAGO 9");
		list.add("TIPO RESERVA 9");
		list.add("INTEGRANTE 10");
		list.add("NOMBRE MÉDICO 10");
		list.add("ESPECIALIDAD 10");
		list.add("MONTO  AUTORIZADO 10");
		list.add("FOLIO RAM 10");
		list.add("TIPO DE PAGO 10");
		list.add("TIPO RESERVA 10");
		list.add("TOTAL HONORARIOS SIN1");
		list.add("COA1 MED");
		list.add("RED COA 1");
		list.add("TOTAL MED COA1");
		list.add("GASTOS NO CUBIERTOS");
		list.add("COASEGURO MEDICO");
		list.add("TOTAL A CARGO DEL PACIENTE");
		list.add("MEDICAMENTO1 RS");
		list.add("MEDICAMENTO1 NOMBRE");
		list.add("MEDICAMENTO1 CODIGO");
		list.add("CANTIDAD 1");
		list.add("PRECIO 1");
		list.add("MEDICAMENTO2 RS");
		list.add("MEDICAMENTO2 NOMBRE");
		list.add("MEDICAMENTO2 CODIGO");
		list.add("CANTIDAD 2");
		list.add("PRECIO 2");
		list.add("MEDICAMENTO3 RS");
		list.add("MEDICAMENTO3 NOMBRE");
		list.add("MEDICAMENTO3 CODIGO");
		list.add("CANTIDAD 3");
		list.add("PRECIO 3");
		list.add("MEDICAMENTO4 RS");
		list.add("MEDICAMENTO4 NOMBRE");
		list.add("MEDICAMENTO4 CODIGO");
		list.add("CANTIDAD 4");
		list.add("PRECIO 4");
		list.add("MEDICAMENTO5 RS");
		list.add("MEDICAMENTO5 NOMBRE");
		list.add("MEDICAMENTO5 CODIGO");
		list.add("CANTIDAD 5");
		list.add("PRECIO 5");
		list.add("MEDICAMENTO6 RS");
		list.add("MEDICAMENTO6 NOMBRE");
		list.add("MEDICAMENTO6 CODIGO");
		list.add("CANTIDAD 6");
		list.add("PRECIO 6");
		list.add("MEDICAMENTO7 RS");
		list.add("MEDICAMENTO7 NOMBRE");
		list.add("MEDICAMENTO7 CODIGO");
		list.add("CANTIDAD 7");
		list.add("PRECIO 7");
		list.add("MEDICAMENTO8 RS");
		list.add("MEDICAMENTO8 NOMBRE");
		list.add("MEDICAMENTO8 CODIGO");
		list.add("CANTIDAD 8");
		list.add("PRECIO 8");
		list.add("MEDICAMENTO9 RS");
		list.add("MEDICAMENTO9 NOMBRE");
		list.add("MEDICAMENTO9 CODIGO");
		list.add("CANTIDAD 9");
		list.add("PRECIO 9");
		list.add("MEDICAMENTO10 RS");
		list.add("MEDICAMENTO10 NOMBRE");
		list.add("MEDICAMENTO10 CODIGO");
		list.add("CANTIDAD 10");
		list.add("PRECIO 10");
		list.add("TOTAL AUT MEDICAMENTO");
		list.add("FOLIO RAM MEDICAMENTO");
		list.add("DED MEDICAMENTO");
		list.add("COA MEDICAMENTOS");
		list.add("MEDICAMENTOS MONTO A CARGO DEL PACIENTE");
		list.add("OTROS1 TIPO SERVICIO");
		list.add("OTROS1 RS");
		list.add("OTROS1 CANTIDAD");
		list.add("OTROS1 PRECIO");
		list.add("OTROS2 TIPO SERVICIO");
		list.add("OTROS2 RS");
		list.add("OTROS2 CANTIDAD");
		list.add("OTROS2 PRECIO");
		list.add("OTROS3 TIPO SERVICIO");
		list.add("OTROS3 RS");
		list.add("OTROS3 CANTIDAD");
		list.add("OTROS3 PRECIO");
		list.add("OTROS4 TIPO SERVICIO");
		list.add("OTROS4 RS");
		list.add("OTROS4 CANTIDAD");
		list.add("OTROS4 PRECIO");
		list.add("OTROS5 TIPO SERVICIO");
		list.add("OTROS5 RS");
		list.add("OTROS5 CANTIDAD");
		
		list.add("OTROS5 PRECIO");
		list.add("OTROS TOTAL AUTORIZADO");
		list.add("OTROS RAM");
		list.add("OTROS DED");
		list.add("OTROS COA");
		list.add("OTROS MONTO A CARGO DEL PAC.");
		list.add("RECHAZO BASES");
		list.add("SOL. INF TIPO DOC.");
		list.add("2DA MEDICO");
		list.add("2DA ESPECILIDAD");
		list.add("2DA MONTO AUT");
		list.add("2DA TIPO PAGO");
		list.add("2DA TIPO RESERVA");
		list.add("NOMBRE TRAMITADOR");
		list.add("FECHA FIN TRAMITE");
		list.add("HORA FIN TRAMITE");
		
		
		return list;
	}
	
	public static List<String> titleReport(){
		List<String> list = new ArrayList<String>();
		list.add("FECHA DE CREACION");
		list.add("HORA DE CREACION");
		list.add("SECTOR");
		list.add("TIPO DE SOLICITUD");
		list.add("FOLIO BPM");
		list.add("FOLIO CARTA");
		list.add("FOLIO TRAMITE");
		list.add("SUBTIPO TRAMITE");
		list.add("FOLIO PRE-AUTORIZACION");
		list.add("NO. FOLIO PRE-AUTORIZACION");
		list.add("PROVEEDOR HOSPITALARIO");
		list.add("ESTADO");
		list.add("NIVEL HOSPITALRIO");
		list.add("FECHA DE INGRESO");
		list.add("HORA DE INGRESO");
		list.add("URGENCIAS");
		list.add("HABITACION ASIGNADA");
		list.add("NUMERO POLIZA");
		list.add("RAMO");
		list.add("PAGADA HASTA");
		list.add("INICIO VIGENCIA");
		list.add("FIN VIGENCIA");
		list.add("POLIZA EN PROCESO EMISION");
		list.add("CONTRATANTE");
		list.add("RECIEN NACIDO/RIESGO NO ENCONTRADO");
		list.add("RIESGO APELLIDO 1");
		list.add("RIESGO APELLIDO 2");
		list.add("RIESGO NOMBRE 1");
		list.add("RIESGO NOMBRE 2");
		list.add("NUMERO RIESGO");
		list.add("RIESGO FECHA NACIMIENTO");
		list.add("RIESGO GENERO");
		list.add("RIESGO TITULAR DE POLIZA");
		list.add("MEDICO RED");
		list.add("NOMBRE MEDICO TRATANTE");
		list.add("ESPECIALIDAD");
		list.add("TIPO RED MEDICO");
		list.add("SINTOMAS");
		list.add("FAMILIAR RESPONSABLE");
		list.add("TELEFONO FAMILIAR");
		list.add("REPORTANTE");
		list.add("TELEFONO REPORTANTE");
		list.add("CORREO REPORTANTE");
		list.add("OBSERVACIONES");
		list.add("FECHA CIERRE REPORTE");
		list.add("HORA CIERRE REPORTE");
		list.add("USUARIO REPORTE");
		list.add("NIVEL COMPLEJIDAD");
		list.add("USUARIO ASIGNADO");
		list.add("FECHA ASIGNACION");
		list.add("HORA ASIGNACION");
		list.add("NOMBRE ASIGNADOR");
		list.add("TIPO TRAMITE");
		//list.add("TIPO TRAMITE 2");
		list.add("TERRITORIO");
		list.add("TIPO MONEDA");
		list.add("FECHA PRE-ALTA");
		list.add("HORA PRE-ALTA");
		list.add("FECHA EGRESO");
		list.add("HORA EGRESO");
		list.add("INSUMOS RECOBROS");
		list.add("IMPORTE EDO CUENTA SIN DESVIOS");
		list.add("DESVIOS EDO CUENTA");
		list.add("BASE INDEMNIZACION");
		list.add("MONTO AUT HOSPITAL");
		list.add("MONTO CON IVA");
		list.add("NO. SINIESTRO 1");
		list.add("ESTADO SINIESTRO 1");
		list.add("TIPO DE SINIESTRO 1");
		list.add("% EDO CUENTA 1");
		list.add("MONTO SINIESTRO 1");
		list.add("RAM HOSP SINIESTRO 1");
		list.add("NO.ICD");
		list.add("DESCRIPCIÓN ICD");
		list.add("FECHA OCURRIDO");
		list.add("CAUSA");
		list.add("CONSECUENCIA");
		list.add("INICIO SINTOMAS");
		list.add("COBERTURA AFECTADA");
		list.add("TIPO PAGO");
		list.add("TIPO RESERVA");
		list.add("MONTO RESERVA");
		list.add("NO.CPT1");
		list.add("DESCRIPCIÓN CPT1");
		list.add("DED1 CONTRATADO");
		list.add("REDUCCIÓN DED1");
		list.add("INCREMENTO DED1");
		list.add("TOTAL DED1");
		list.add("COA1 HOSP CONTRATADO");
		list.add("REDUCCION COA1 HOSP");
		list.add("INCREMENTO COA1 HOSP");
		list.add("TOPE COA1 HOSP");
		list.add("CON TOPE COA1 HOSP");//91
		//list.add("TOPE ALCANZADO COA1 HOSP");
		list.add("TOTAL COA1 HOSP");
		list.add("INTEGRANTE 1");
		list.add("NOMBRE MEDICO 1");
		list.add("ESPECIALIDAD 1");
		list.add("MONTO  AUTORIZADO 1");
		list.add("FOLIO RAM 1");
		list.add("TIPO DE PAGO 1");
		list.add("TIPO RESERVA 1");
		list.add("TOTAL HONORARIOS SIN1");//100
		list.add("COA1 MED");
		list.add("RED COA 1");
		list.add("TOTAL MED COA1");
		list.add("GASTOS NO CUBIERTOS");
		list.add("COASEGURO MEDICO");//105
		list.add("TOTAL A CARGO DEL PACIENTE");
		list.add("MEDICAMENTO1 RS");
		list.add("MEDICAMENTO1 NOMBRE");
		list.add("MEDICAMENTO1 CODIGO");
		list.add("CANTIDAD 1");//110
		list.add("PRECIO 1");
		list.add("TOTAL AUT MEDICAMENTO");
		list.add("FOLIO RAM MEDICAMENTO");
		list.add("DED MEDICAMENTO");
		list.add("COA MEDICAMENTOS");//115
		list.add("MEDICAMENTOS MONTO A CARGO DEL PACIENTE");
		list.add("OTROS1 TIPO SERVICIO");
		list.add("OTROS1 RS");
		list.add("OTROS1 CANTIDAD");
		list.add("OTROS1 PRECIO");//120
		list.add("OTROS TOTAL AUTORIZADO");
		list.add("OTROS RAM");
		list.add("OTROS DED");
		list.add("OTROS COA");
		list.add("OTROS MONTO A CARGO DEL PAC.");//125
		list.add("RECHAZO BASES");
		list.add("SOL. INF TIPO DOC.");
		list.add("2DA MEDICO");
		list.add("2DA ESPECILIDAD");
		list.add("2DA MONTO AUT");//130
		list.add("2DA TIPO PAGO");
		list.add("2DA TIPO RESERVA");//132
		list.add("NOMBRE TRAMITADOR");
		list.add("FECHA FIN TRAMITE");
		list.add("HORA FIN TRAMITE");
		
		
		return list;
	}
	
	public static String containFolio(String folio) {
		if(folio == null || folio.isEmpty()) {
			return "NO";
		}
		
		if(folio.contains("bpm")) {
			return "SI";
		}
		return "NO";
	}
	
	public static String tipoSolicitud(String codigo) {
		if(codigo == null || codigo.isEmpty()) {
			return "";
		}
		int numCodigo = Integer.parseInt(codigo);
		if(numCodigo == 121) {
			return "REPORTE SIN CARTA";
		}
		if(numCodigo == 122) {
			return "REPORTE CON CARTA";
		}
		if(numCodigo == 123) {
			return "EVENTO PROGRAMADO";
		}
		if(numCodigo == 632) {
			return "REAPERTURA";
		}
		return "";
	}
}