package hw3.business.abstracts;

import java.util.List;

import hw3.model.concretes.Order;

public interface OrderService {
	void add(Order order);
	void delete(int id);
	void update(Order order);
	Order getOrderById(int id);
	List<Order> getOrders();
	void deleteOrderByPlayerId(int playerId);
}
