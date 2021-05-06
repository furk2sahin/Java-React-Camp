package hw3.service.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hw3.model.concretes.Order;
import hw3.service.abstracts.OrderDao;

public class OrderDaoImpl implements OrderDao {
	
	private static List<Order> orders = new ArrayList<Order>();

	@Override
	public void add(Order order) {
		orders.add(order);
	}

	@Override
	public void delete(int id) {
		for(Iterator<Order> iterator = orders.listIterator(); iterator.hasNext(); ) {
			if(iterator.next().getId() == id) {
				iterator.remove();
				System.out.println("Order successfully deleted with id: " + id);
			}
		}
	}

	@Override
	public void update(Order order) {
		int indexOfOrder = orders.indexOf(order);
		Order orderToUpdate = orders.get(indexOfOrder);
		if(!orderToUpdate.getStatus().equals(order.getStatus())) {
			orderToUpdate.setStatus(order.getStatus());
			System.out.println("Order status successfully updated.");
		}
	}

	@Override
	public Order getOrderById(int id) {
		for(Iterator<Order> iterator = orders.listIterator(); iterator.hasNext(); ) {
			Order order = iterator.next();
			if(order.getId() == id) {
				return order;
			}
		}
		System.out.println("Order cannot found with id: " + id);
		return null;
	}

	@Override
	public List<Order> getOrders() {
		return orders;
	}

	@Override
	public void deleteOrderByPlayerId(int playerId) {
		for(Iterator<Order> iterator = orders.listIterator(); iterator.hasNext(); ) {
			Order order = iterator.next();
			if(order.getPlayer().getId() == playerId) {
				if(orders.remove(order)) {
					System.out.println("Order successfully deleted with player id: " + playerId);
				} else {
					System.out.println("Error when deleting order with player id: " + playerId);
				}
			}
		}
	}

}
