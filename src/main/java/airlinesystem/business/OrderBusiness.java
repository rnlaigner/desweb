package airlinesystem.business;


import airlinesystem.dao.OrderAppService;
import airlinesystem.entity.Order;

public class OrderBusiness {

	private static final OrderBusiness orderBusiness = new OrderBusiness();
	
	private OrderAppService orderAppService;
	
	private OrderBusiness()
	{
		
	}
	
	public static OrderBusiness getInstance()
	{
		return orderBusiness;
	}
	
	public long save(Order order){
		
		orderAppService = OrderAppService.getInstance();
	    
	    return orderAppService.add(order);
	}
	
}
