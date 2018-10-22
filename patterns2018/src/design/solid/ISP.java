package design.solid;


class Document {}


interface Machine {
	void print(Document d);
	void fax(Document d);
	void scarn(Document d);
}


class MuntiFunctionPrinter implements Machine {

	@Override
	public void print(Document d) {		
		
	}

	@Override
	public void fax(Document d) {
		
	}

	@Override
	public void scarn(Document d) {
				
	}
	
}
/*
class OldFashionedPrinter implements Machine {
	...
}
*/

interface Printer {
	void print(Document d);
}

interface Scanner {
	void scarn(Document d);
}

class JustAPrinter implements Printer {

	@Override
	public void print(Document d) {
		
	}
}

class Photocopier implements Printer, Scanner {

	@Override
	public void scarn(Document d) {		
		
	}

	@Override
	public void print(Document d) {
		
	}
	
}

interface MuntiFunctionDevice extends Printer, Scanner {}

class MultiFunctionMachine implements MuntiFunctionDevice {
	
	private Printer printer;
	private Scanner scanner;
	
	public MultiFunctionMachine(Printer printer, Scanner scanner) {	
		this.printer = printer;
		this.scanner = scanner;
	}

	@Override
	public void print(Document d) {
		printer.print(d);
	}

	@Override
	public void scarn(Document d) {
		scanner.scarn(d);
	}
	
}

public class ISP {

	public static void main(String[] args) {

	}

}
