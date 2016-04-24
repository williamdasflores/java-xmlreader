package xml_reader;

import java.util.List;

public class Employee {
	
	private String name;
	private int age;
	private List<Costumer> costumers;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Costumer> getCostumers() {
		return costumers;
	}
	public void setCostumers(List<Costumer> costumers) {
		this.costumers = costumers;
	} 

}
