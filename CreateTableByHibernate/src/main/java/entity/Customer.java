package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author La Vo Minh Quan
 * @version 1.0
 * @created 21-Apr-2022 4:45:34 PM
 */
@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name", columnDefinition = "NVARCHAR(50)", nullable = false)
	private String firstName;

	@Column(name = "last_name", columnDefinition = "NVARCHAR(50)", nullable = false)
	private String lastName;

	@Column(name = "username", columnDefinition = "NVARCHAR(50)", nullable = false)
	private String username;

	@Column(columnDefinition = "NVARCHAR(200)", nullable = true)
	private String email;

	@Column(columnDefinition = "NVARCHAR(200)", nullable = true)
	private String address;

	@Column(name = "phone_number", columnDefinition = "VARCHAR(10)", nullable = true)
	private String phoneNumber;

//	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	private Set<Order> orders = new HashSet<Order>();

	public Customer() {

	}

	public Customer(String firstName, String lastName, String username, String email, String address,
			String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

//	public Set<Order> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(Set<Order> orders) {
//		this.orders = orders;
//	}

}// end UserInfo