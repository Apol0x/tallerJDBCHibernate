package org.springframework.samples.petclinic.bill;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.visit.Visit;

@Entity
@Table(name = "bill")
public class Bill extends BaseEntity {
	
	@Digits(integer=10,fraction=0)
	private long IdNumber;
	
	//@Column(name = "fecha_pago")
	@Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date date;
	
	//@Column(name = "cuantia")
	@Digits(integer=5,fraction=2)
	@DecimalMin("0,0")
	private Integer price;
	
//	@ManyToOne
//	@JoinColumn(name="owner")
//	private Owner owner;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="bill", cascade=CascadeType.ALL)
	@JoinColumn(name="visit_id")
	private Visit visit;
	
	public Bill() {}
}