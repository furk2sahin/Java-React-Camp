package hw3.business.concretes;

import java.util.List;

import hw3.business.abstracts.OrderService;
import hw3.model.concretes.Order;
import hw3.service.abstracts.OrderDao;

public class OrderManager implements OrderService{

	private OrderDao orderDao;
	
	public OrderManager(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	
	@Override
	public void add(Order order) {
		orderDao.add(order);
	}

	@Override
	public void delete(int id) {
		if(id <= 0) {
			System.out.println("ID cannot be less than 0.");
			return;
		}
		orderDao.delete(id);
	}

	@Override
	public void update(Order order) {
		orderDao.update(order);
	}

	@Override
	public Order getOrderById(int id) {
		if(id <= 0) {
			System.out.println("ID cannot be less than 0.");
			return null;
		}
		return orderDao.getOrderById(id);
	}

	@Override
	public List<Order> getOrders() {
		return orderDao.getOrders();
	}

	@Override
	public void deleteOrderByPlayerId(int playerId) {
		if(playerId <= 0) {
			System.out.println("ID cannot be less than 0.");
			return;
		}
		orderDao.deleteOrderByPlayerId(playerId);;
	}

}
