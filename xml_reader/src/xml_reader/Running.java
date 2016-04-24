package xml_reader;

import java.util.Iterator;
import java.util.List;

public class Running {
	public static void main(String[] args) {
		
		XmlReader runXml = new XmlReader();
		List<Employee> teste = runXml.search("employee.xml", "Rodrigo Cesar");
		Iterator<Employee> it = teste.iterator();
		while(it.hasNext()) {
			System.out.println();
			Employee emp = it.next();
			System.out.println("Seller name -> " +emp.getName());
			System.out.println("Seller age -> " +emp.getAge());
			for(Costumer c : emp.getCostumers()) {
				System.out.println("Buyer -> " +c.getCompanyName());
			}
		}
	}
}
