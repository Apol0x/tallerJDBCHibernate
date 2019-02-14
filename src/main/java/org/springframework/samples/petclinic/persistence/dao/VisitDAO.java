package org.springframework.samples.petclinic.persistence.dao;

import java.util.List;

import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.stereotype.Repository;


@Repository
public class VisitDAO extends AbstractJpaDAO<Visit, Integer> implements  IVisitAO{

    public VisitDAO() {
    	super();
    	setClazz(Visit.class);
    }
    
    public List<Visit> getVisitByIdNumber(long idNumber) {
    	
    	return getEntityManager().createQuery("select v from Visit v where v.idNumber= " + idNumber).getResultList();
    	
    }
    // API


	@Override
	public List<Visit> getVisitsByIdNumberNamedQuery(long idNumber) {
		// TODO Auto-generated method stub
		return getEntityManager().createNamedQuery("visitByIdNumber").setParameter("idNumber", idNumber).getResultList();
	}

}
