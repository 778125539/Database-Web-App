package in.cezarzosin.entity;

public class Employee {

	private String name;
	private String department;
	private int age;
	private String dateOfBirth;

	public Employee(String name, String department, int age, String dateOfBirth) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(" Employee name: " + this.getName() + "_age: " + this.getAge() + " _dateOfBirth: "
				+ this.getDateOfBirth() + "_department: " + this.getDepartment());

		return sBuilder.toString();

	}

}
