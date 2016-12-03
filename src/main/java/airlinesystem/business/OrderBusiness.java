package airlinesystem.business;

public class OrderBusiness {

	private static final OrderBusiness orderBusiness = new OrderBusiness();
	
	private OrderBusiness()
	{
		
	}
	
	public static OrderBusiness getInstance()
	{
		return orderBusiness;
	}
	
	
	
}
