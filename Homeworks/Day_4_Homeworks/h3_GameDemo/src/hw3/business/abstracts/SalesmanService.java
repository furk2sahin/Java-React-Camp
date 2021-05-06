package hw3.business.abstracts;

import java.util.List;

import hw3.model.concretes.Salesman;

public interface SalesmanService {
	void add(Salesman salesman);
	void delete(int salesmanId);
	void update(Salesman salesman);
	Salesman getSalesmanById(int id);
	List<Salesman> getSalespeople();
}
