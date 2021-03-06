package airlinesystem.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="`user`")
public class User implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8988921681994368610L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
    private Long id;
	
	@Column(nullable = false)
    private String email;
    
	@Column(nullable = false)
	private String password;
    
	@OneToMany(mappedBy = "user")
	@OrderBy
    private List<Order> orders;
    
    public User()
    {
    	
    }
    
    public User(String email, String password)
    {
        this.email = email;
        this.password = password;
    }

    public String getUsername() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public List<Order> getOrders() 
    {
        return orders;
    }

    public void setOrders(List<Order> orders) 
    {
        this.orders = orders;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}   

}
