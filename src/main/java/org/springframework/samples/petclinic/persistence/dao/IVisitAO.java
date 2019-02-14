package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;
import org.springframework.samples.petclinic.visit.Visit;

/**
 * Interfaz para definir los métodos especificos para la entidad Owner
 * @author operator
 *
 */
public interface IVisitAO extends IBaseDAO<Visit, Integer> {
	
	List<Visit> getVisitByIdNumber(long idNumber);
	
	List<Visit> getVisitsByIdNumberNamedQuery(long idNumber);

}
