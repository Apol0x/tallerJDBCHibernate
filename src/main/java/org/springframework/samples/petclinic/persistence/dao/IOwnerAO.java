package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;
import org.springframework.samples.petclinic.owner.Owner;

/**
 * Interfaz para definir los métodos especificos para la entidad Owner
 * @author operator
 *
 */
public interface IOwnerAO extends IBaseDAO<Owner, Integer> {
	
	List<Owner> getOwnerByIdNumber(long idNumber);
	
	List<Owner> getOwnerByIdNumberNamedQuery(long idNumber);

	List<Owner> getOwnerByCityNamedQuery(String city);
}
