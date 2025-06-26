package labs.lab6_adapter.original.model;

public class Restaurant {

	public Restaurant(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	// Call the restaurant
	public void call() {
		System.out.printf("Calling %s...\n", phone);
	}
	
	private String name;
	private String address;
	private String phone;
}
