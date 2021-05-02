package adapters;

import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import abstracts.CustomerCheckService;
import entities.Customer;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisServiceAdapter implements CustomerCheckService{

	@Override
	public boolean checkIfRealPerson(Customer customer) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		boolean check = false;
		try {
			check = client.TCKimlikNoDogrula(Long.parseLong(customer.nationalityId), 
					customer.firstName.toUpperCase(), 
					customer.lastName.toUpperCase(),
					customer.dateOfBirth.get(Calendar.YEAR));
		} catch (NumberFormatException | RemoteException e) {
			e.printStackTrace();
		}
		return check;
	}
	
}
