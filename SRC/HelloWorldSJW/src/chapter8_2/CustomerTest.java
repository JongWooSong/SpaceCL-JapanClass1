package chapter8_2;

import chapter8.Customer;

public class CustomerTest {

	public static void main(String[] args) {

		VIPCustomer vip = new VIPCustomer(500);
		vip.calcPrice(100);
		System.out.println( vip.showCustomerInfo() );
		
//		Customer cu = new Customer();
//		cu.calcPrice(200);
//		System.out.println( cu.showCustomerInfo() );
		
		Customer cc = new VIPCustomer();
		System.out.println( cc );
		
	}

}
