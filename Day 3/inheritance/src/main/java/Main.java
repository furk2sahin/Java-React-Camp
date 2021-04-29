
public class Main {
    public static void main(String[] args) {
        IndividualCustomer engin = new IndividualCustomer();
        engin.customerNumber = "12345";
        
        CorporateCustomer hepsiBurada = new CorporateCustomer();
        hepsiBurada.customerNumber = "78910";
        
        SendikaCustomer sendikaCustomer = new SendikaCustomer();
        sendikaCustomer.customerNumber = "99999";
        
        CustomerManager customerManager = new CustomerManager();
        //customerManager.add(hepsiBurada);
        //customerManager.add(engin); 
        //customerManager.add(sendikaCustomer);C
        Customer[] customers = {engin, hepsiBurada, sendikaCustomer};
        customerManager.addMultiple(customers);
    }
}
