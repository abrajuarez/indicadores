function validarFormulario(){
		
		$("#buscar").click(function(){
			var fechaInicial = new Date($('#datepicker').val());
			var fechaFinal = new Date($('#datepicker2').val());
			
		if (fechaInicial > fechaFinal) {
			alert('la fecha inicial debe ser menor a la fecha final')
			return false;
		} else if (fechaInicial == '' || fechaFinal == '') {
			alert('la fecha no debe estar vacia')
			return false;
		}
		});
	}
	
	
	
		$(function($) {

			$('#datepicker').datepicker({
				autoclose : true,
				dateFormat : "dd/mm/yyyy"
			})
			$('#datepicker2').datepicker({
				autoclose : true,
				dateFormat : "dd/mm/yyyy"
			})
			
			$('#datepickerY').datepicker({
				autoclose : true,
				dateFormat : "dd/mm/yyyy"
			})
			$('#datepicker2Y').datepicker({
				autoclose : true,
				dateFormat : "dd/mm/yyyy"
			})
			validarFormulario();
			
		});