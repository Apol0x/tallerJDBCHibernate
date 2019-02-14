package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.stereotype.Repository;


@Repository
public class OwnerDAO extends AbstractJpaDAO<Owner, Integer> implements  IOwnerAO{

    public OwnerDAO() {
    	super();
    	setClazz(Owner.class);
    }
    
    public List<Owner> getOwnerByIdNumber(long idNumber) {
    	
    	return getEntityManager().createQuery("select o from Owner o where o.idNumber= " + idNumber).getResultList();
    	
    }
    // API


	@Override
	public List<Owner> getOwnerByIdNumberNamedQuery(long idNumber) {
		// TODO Auto-generated method stub
		return getEntityManager().createNamedQuery("ownerByIdNumber").setParameter("idNumber", idNumber).getResultList();
	}
	
	@Override
	public List<Owner> getOwnerByCityNamedQuery(String city) {
		return getEntityManager().createNamedQuery("ownerByCityr").setParameter("city", city).getResultList();
	}

}
