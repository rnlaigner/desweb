/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Rodrigo
 */
@Entity
@Table(name="airport")
public class Airport implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5657194060479595887L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;	

	@Column(nullable = false)
    private String name;
	
	@Column(nullable = false)
    private String city;
	
	@Column(nullable = false)
	private Float fee;

	public Airport() 
	{
    }

    public Airport(String name, String city, Float fee) {
        this.name = name;
        this.city = city;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public Long getId() {
		return id;
	}
    
    public Float getFee() {
		return fee;
	}

	public void setFee(Float fee) {
		this.fee = fee;
	}
}
