package airlinesystem.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import airlinesystem.model.abstracts.Payment;

//Nome de tabela gerado `order` da problema no hibernate

@Entity
@Table(name="orders")
public class Order 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",unique=true, nullable = false)
	private Long id;
	
	@OneToMany(mappedBy = "order")
    private List<Ticket> tickets;
    
	@Column(nullable = true)
    private double totalPrice;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
    private User user;
    
    @OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="payment_id")
    private Payment payment;
    
    @Column(nullable = true)
    private Long orderNumber;
    
    public Order()
    {
    	
    }
    
    public Order(List<Ticket> tickets, User user, Payment payment)
    {
        this.tickets = tickets;
        this.user = user;
        this.payment = payment;
    }
    
    @SuppressWarnings("unused")
	private double calcTotalPrice()
    {
        double total = 0;
        for (Ticket ticket : this.tickets) 
        {
            total += ticket.getPrice();
        }
        return total;
    }

    public List<Ticket> getTickets() 
    {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) 
    {
        this.tickets = tickets;
    }

    public double getTotalPrice() 
    {
        return totalPrice;
    }

    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Payment getPayment() 
    {
        return payment;
    }

    public void setPayment(Payment payment) 
    {
        this.payment = payment;
    } 

    public Long getOrderNumber() 
    {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber)
    {
        this.orderNumber = orderNumber;
    }
}