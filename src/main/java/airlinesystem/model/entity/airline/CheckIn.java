/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.entity.airline;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Rodrigo
 */
public class CheckIn 
{
    private Ticket ticket;
    private GregorianCalendar checkinDate;
    
    public CheckIn(Ticket ticket)
    {
        this.ticket = ticket;
        
        Date date = new Date();
        GregorianCalendar cal;
        cal = (GregorianCalendar) GregorianCalendar.getInstance();
        cal.setTime(date);
        
        this.checkinDate = cal;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public GregorianCalendar getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(GregorianCalendar checkinDate) {
        this.checkinDate = checkinDate;
    }
    
    
    
}
