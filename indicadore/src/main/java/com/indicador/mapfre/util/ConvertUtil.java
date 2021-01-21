package com.indicador.mapfre.util;



public class ConvertUtil {
	
	public static String objectToString(Object obj) {
		if(obj == null) {
			return "";
		}
		return obj.toString();
	}
	
	public static Long StringToLong(String obj) {
		if(obj == null) {
			return 0l;
		}
		return Long.parseLong(obj);
	}
}
