package hw3.service.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hw3.model.concretes.Salesman;
import hw3.service.abstracts.SalesmanDao;

public class SalesmanDaoImpl implements SalesmanDao {
	
	private static List<Salesman> salesmanPeople = new ArrayList<Salesman>();
	
	@Override
	public void add(Salesman salesman) {
		salesmanPeople.add(salesman);
	}

	@Override
	public void delete(int salesmanId) {
		for(Iterator<Salesman> iterator = salesmanPeople.listIterator(); iterator.hasNext(); ) {
			if(iterator.next().getId() == salesmanId) {
				iterator.remove();
				System.out.println("Salesman successfully removed by id: " + salesmanId);
			}
		}
	}

	@Override
	public void update(Salesman salesman) {
		int indexOfSalesman = salesmanPeople.indexOf(salesman);
		Salesman salesmanToUpdate = salesmanPeople.get(indexOfSalesman);
		if(!salesmanToUpdate.getFirstName().equals(salesman.getFirstName())) {
			salesmanToUpdate.setFirstName(salesman.getFirstName());
			System.out.println(salesman.getFirstName() + "'s first name successfully changed.");
		} 
		
		if(!salesmanToUpdate.getLastName().equals(salesman.getLastName())) {
			salesmanToUpdate.setLastName(salesman.getLastName());
			System.out.println(salesman.getFirstName() + "'s last name successfully changed.");
		} 
	}

	@Override
	public Salesman getSalesmanById(int id) {
		for(Iterator<Salesman> iterator = salesmanPeople.listIterator(); iterator.hasNext(); ) {
			Salesman salesman = iterator.next();
			if(salesman.getId() == id) {
				return salesman;
			}
		}
		System.out.println("Cannot find salesman with id: " + id);
		return null;
	}

	@Override
	public List<Salesman> getSalespeople() {
		return salesmanPeople;
	}

}
