package intro;

public class Main {

	public static void main(String[] args) {
		
		String internetSubeButonu = "Ýnternet Þubesi";
		
		double dolarDun = 8.15;
		double dolarBugun = 8.18;
		int vade = 36;
		boolean dustuMu = false;
		
		System.out.println(internetSubeButonu);
		if(dolarDun > dolarBugun)
			System.out.println("Dolar düþtü");
		
		String kredi1 = "Hýzlý Kredi";
		String kredi2 = "Mutlu emekli kredisi";
		String kredi3 = "Konut kredisi";
		String kredi4 = "Çiftçi kredisi";
		String kredi5 = "Msb Kredisi";
		String kredi6 = "Meb kredisi";

		System.out.println(kredi1);
		System.out.println(kredi2);
		System.out.println(kredi3);
		System.out.println(kredi4);
		System.out.println(kredi5);
		System.out.println(kredi6);
	
		String[] krediler = 
			{
				"Hýzlý Kredi",
				"Mutlu emekli kredisi",
				"Konut kredisi",
				"Çiftçi kredisi",
				"Msb Kredisi",
				"Meb kredisi"	
			};
	}

}
