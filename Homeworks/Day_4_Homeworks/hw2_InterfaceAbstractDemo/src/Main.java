import java.text.ParseException;
import java.util.GregorianCalendar;

import abstracts.BaseCustomerManager;
import adapters.MernisServiceAdapter;
import concrete.NeroCustomerManager;
import concrete.StarbucksCustomerManager;
import entities.Customer;

public class Main {

	public static void main(String[] args) {
		BaseCustomerManager customerManager = new  NeroCustomerManager(new MernisServiceAdapter());
		//BaseCustomerManager customerManager = new  StarbuckCustomerManager(new MernisServiceAdapter());
		try {
			// CustomerManager(String, String, new GregorianCalendar(Year, Month, Day), String);
			customerManager.save(new Customer("<your-firstname>", "<your-lastname>", new GregorianCalendar(1111, 1, 1), "<TC>"));
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
