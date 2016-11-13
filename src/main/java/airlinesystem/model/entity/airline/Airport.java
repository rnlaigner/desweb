/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.entity.airline;

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
public class Airport 
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	@Column(nullable = true)
    private String name;
	
	@Column(nullable = true)
    private String city;
	
	public Airport() 
	{
    }

    public Airport(String name, String city) {
        this.name = name;
        this.city = city;
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
    
    
}
