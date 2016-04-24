package xml_reader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XmlReader {
	
	public List<Employee> search(String fileName, String findName) {
		
		File file = new File(fileName);
		SAXBuilder builder = new SAXBuilder();
		Document document;
		List<Employee> listEmployee = new ArrayList<Employee>();
		
		
		try {
		
			document = builder.build(file);
			Element employee = document.getRootElement();
			
			//below employee's root has a list of seller.
			Employee emp;
			
			List sellers = employee.getChildren("seller");
			
			
			Iterator it = sellers.iterator();
			while(it.hasNext()) {
				Element seller = (Element)it.next();
				
				//below we have a list of seller with names, age and the costumers
				Element name = seller.getChild("name");
				if(name.getText().equals(findName)) {
					emp = new Employee();
					emp.setName(name.getText());
				
					Element age = seller.getChild("age");
					emp.setAge(Integer.parseInt(age.getText()));
					
					Element costumers = seller.getChild("costumers") ;
					
					List buyers = costumers.getChildren("buyer");
					if(buyers != null && buyers.size() > 0) {
						List<Costumer> listCostumer = new ArrayList<Costumer>();
						Iterator i = buyers.iterator();
						
						while(i.hasNext()) {
							Costumer c = new Costumer();
							Element buyer = (Element)i.next();
							c.setCompanyName(buyer.getText());
							listCostumer.add(c);
						}
						
						emp.setCostumers(listCostumer);
						
					}
					
					listEmployee.add(emp);
					
				}
			}
		} catch(JDOMException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return listEmployee;
		
	}
}
