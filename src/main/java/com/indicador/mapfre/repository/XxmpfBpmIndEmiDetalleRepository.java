package com.indicador.mapfre.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.indicador.mapfre.entity.XxmpfBpmIndEmiDetalle;;

@Repository
public interface XxmpfBpmIndEmiDetalleRepository extends JpaRepository<XxmpfBpmIndEmiDetalle, String>{
	
	@Query("SELECT AVG(detalle.tiempoActividad) FROM XxmpfBpmIndEmiDetalle detalle,XxmpfBpmIndEmision emision WHERE emision.idEmision = detalle.idEmisionFK AND detalle.estatus = 'Emitido' AND emision.sector = :sector")
	public BigDecimal AvgTiempoActividadBySector(@Param("sector") String sector);
	
	@Query("SELECT AVG(detalle.tiempoAtencion) FROM XxmpfBpmIndEmiDetalle detalle,XxmpfBpmIndEmision emision WHERE emision.idEmision = detalle.idEmisionFK AND detalle.estatus = 'Emitido' AND emision.sector = :sector")
	public BigDecimal AvgTiempoAtencionBySector(@Param("sector") String sector);
	
	@Query("SELECT TRUNC(SUM(detalle.tiempoAtencion) / SUM(emision.numRiesgos),2)FROM XxmpfBpmIndEmiDetalle detalle INNER JOIN XxmpfBpmIndEmision emision ON detalle.idEmisionFK = emision.idEmision  WHERE   detalle.estatus != 'Pendiente' AND detalle.area = 'Emisión' AND emision.sector = :sector")
	public BigDecimal truncTiempoActividadBySector(@Param("sector") String sector);

}
