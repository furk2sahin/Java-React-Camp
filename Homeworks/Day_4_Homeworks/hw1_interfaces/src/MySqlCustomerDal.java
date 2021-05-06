
public class MySqlCustomerDal implements CustomerDal, Repository{

	@Override
	public void add() {
		System.out.println("My Sql Eklendi");
	}

}
