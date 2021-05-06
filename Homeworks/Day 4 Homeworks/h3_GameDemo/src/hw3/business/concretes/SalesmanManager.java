package hw3.business.concretes;

import java.util.List;

import hw3.business.abstracts.SalesmanService;
import hw3.core.PersonCheckService;
import hw3.model.concretes.Salesman;
import hw3.service.abstracts.SalesmanDao;

public class SalesmanManager implements SalesmanService{

	private SalesmanDao salesmanDao;
	private PersonCheckService personCheckService;
	
	public SalesmanManager(SalesmanDao salesmanDao, PersonCheckService personCheckService) {
		this.salesmanDao = salesmanDao;
		this.personCheckService = personCheckService;
	}
	
	@Override
	public void add(Salesman salesman) {
		if(personInformationCheck(salesman))
			salesmanDao.add(salesman);
	}

	@Override
	public void delete(int salesmanId) {
		if(salesmanId <= 0) {
			System.out.println("Unsuccessfull. ID cannot be less than 1.");
			return;
		}
		salesmanDao.delete(salesmanId);
	}

	@Override
	public void update(Salesman salesman) {
		if(personInformationCheck(salesman))
			salesmanDao.update(salesman);
		
	}

	@Override
	public Salesman getSalesmanById(int id) {
		if(id <= 0) {
			System.out.println("Unsuccessfull. ID cannot be less than 1.");
			return null;
		}
		return salesmanDao.getSalesmanById(id);
	}

	@Override
	public List<Salesman> getSalespeople() {
		return salesmanDao.getSalespeople();
	}
	
	public boolean personInformationCheck(Salesman salesman) {
		if(salesman.getId() <= 0) {
			System.out.println("Unsuccessfull. ID cannot be less than 1.");
			return false;
		}
		if(salesman.getFirstName().length() < 3 && salesman.getFirstName().length() > 24) {
			System.out.println("Unsuccessfull. First name must be between 3-24 characters.");
			return false;
		}
		if(salesman.getLastName().length() < 3 && salesman.getLastName().length() > 24) {
			System.out.println("Unsuccessfull. First name must be between 3-24 characters.");
			return false;
		}
		
		if(!personCheckService.checkIfRealPerson(salesman.getNationalIdentity(), 
				salesman.getFirstName(), 
				salesman.getLastName(), 
				salesman.getBirthDate())) {
			System.out.println("Unsuccessfull. This informations dosen't match with a real person.");
			return false;
		}
		return true;
	}

}
