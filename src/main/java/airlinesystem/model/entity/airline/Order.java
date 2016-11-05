package airlinesystem.model.entity.airline;

import airlinesystem.model.entity.payment.Payment;
import airlinesystem.model.entity.user.User;
import java.util.List;

public class Order 
{
    private List<Ticket> tickets;
    private double totalPrice;
    private User user;
    private Payment payment;
    private int orderNumber;
    
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

    public int getOrderNumber() 
    {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber)
    {
        this.orderNumber = orderNumber;
    }
}
