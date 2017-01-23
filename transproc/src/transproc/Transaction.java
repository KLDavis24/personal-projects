package transproc;

public class Transaction 
{
	int transID = -1;		//	Transid matches a product id that the transaction is against. (-1 = not set) 
	String transType = ".";		//	'D' to delete; 'P' to print; '.' = no operation to perform
}
