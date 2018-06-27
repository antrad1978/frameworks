package hibernate2;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	   @Column(name = "id")
	   private int id;
	@Column(name = "firstName")
	   private String firstName; 
	@Column(name = "lastName")
	   private String lastName;   
	@Column(name = "salary")
	   private int salary;  
	private List<Job> jobs;

	   public Employee() {}
	   public Employee(String fname, String lname, int salary) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.salary = salary;
	   }
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getFirstName() {
	      return firstName;
	   }
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   public String getLastName() {
	      return lastName;
	   }
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   public int getSalary() {
	      return salary;
	   }
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
}
