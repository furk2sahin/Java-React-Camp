package hw3.service.abstracts;

import java.util.List;

import hw3.model.concretes.Order;

public interface OrderDao {
	void add(Order order);
	void delete(int id);
	void update(Order order);
	Order getOrderById(int id);
	List<Order> getOrders();
	void deleteOrderByPlayerId(int playerId);
}
