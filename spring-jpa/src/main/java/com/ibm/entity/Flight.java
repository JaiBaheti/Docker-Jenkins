package com.ibm.entity;

import javax.persistence.*;

@Entity
@Table(name="flight")
//@NamedQueries({@NamedQuery(name="allFetch",query="SELECT f from Flight f")})
@NamedQueries({@NamedQuery(name="findByCarrier", query="Select f from Flight f where f.carrier=:carrier")})
public class Flight {
	@Id	
	private String code;
	@Column(name = "Source",length=10)
	private String from;
	@Column(name="destination",length=10)
	private String to;
	@Column(length=10)
	private String carrier;
	
	public Flight() {
		
	}
	public Flight(String code, String from, String to, String carrier) {
		super();
		this.code = code;
		this.from = from;
		this.to = to;
		this.carrier = carrier;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	@Override
	public String toString() {
		return "Flight [code=" + code + ", from=" + from + ", to=" + to + ", carrier=" + carrier + "]";
	}
	
	
}
