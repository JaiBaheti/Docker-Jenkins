package com.ibm.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.*;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.hibernate.annotations.Parameter;
import org.jboss.logging.Param;
import org.springframework.stereotype.*;

import com.ibm.entity.Flight;

@Repository
public class FlightRepoImpl implements FlightRepo {
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value = TxType.REQUIRED)
	public String save(Flight f) {
		em.persist(f);
		return f.getCode();
	}

	public Flight fetch(String code) {		
		return em.find(Flight.class, code);
	}

	public List<Flight> fetchAll() {
		//Query sql = em.createQuery("from flight");
//		return sql.getResultList();
		return em.createNamedQuery("allFetch").getResultList();
	}
	
	@Transactional
	public boolean remove(String code) {
		Flight f = em.find(Flight.class,code);
		em.remove(f);
		return true;		
	}
	
	@Transactional
	public boolean update(Flight f) {
		em.merge(f);
		return true;
	}

	@Override
	public List<Flight> findbyCarrier(String carrier) {
		Query query = em.createNamedQuery("findByCarrier");
		return query.setParameter("carrier", carrier).getResultList();
		/*em.createNamedQuery("findByCarrier").setParameter("carrier", carrier).getResultList();
		return null;*/
		
	}

}
