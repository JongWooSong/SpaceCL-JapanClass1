package chapter12;

public class GenericPrinter<T extends Meterial> {

	private T meterial;
	
	
	
	public static void main(String[] args) {
			
		GenericPrinter<Plastic> gp = new GenericPrinter<Plastic>();
		
		
	}
	
}
