package in.cezarzosin.entity;

public class Employee {

	private String name;
	private String department;
	private String dateOfBirth;



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

	

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(" Employee name: " + this.getName() +" _dateOfBirth: "
				+ this.getDateOfBirth() + "_department: " + this.getDepartment());

		return sBuilder.toString();

	}

}
