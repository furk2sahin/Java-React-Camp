package hw3.core;

import java.rmi.RemoteException;
import java.util.Calendar;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class KPSPublicAdapter implements PersonCheckService{

	@Override
	public boolean checkIfRealPerson(String nationalIdentity, String firstName, String lastName, Calendar birthDate) {
		KPSPublicSoap client = new KPSPublicSoapProxy();
		boolean check = false;
		try {
			check = client.TCKimlikNoDogrula(Long.parseLong(nationalIdentity), 
						firstName.toUpperCase(), 
						lastName.toUpperCase(), 
						birthDate.get(Calendar.YEAR));
		} catch (NumberFormatException | RemoteException e) {
			System.out.println(e.toString());
		}
		return check;
	}

}
