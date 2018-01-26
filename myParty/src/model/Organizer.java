package model;

public class Organizer {
	
	private int id;
	private String name;
	private String password;
	private String city;
	private String address;
	
	public Organizer() {
		
	}
	
	public Organizer(int id, String name, String password, String city, String address) {
		super();
		this.id=id;
		this.name=name;
		this.password=password;
		this.city=city;
		this.address=address;
	}
	
	public int getId() {
		return id;
	}
	 
	public void setId(int id) {
		this.id = id;
	}
	 
	public String getName() {
		return name;
	}
	 
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	 
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getCity() {
		return city;
	}
	 
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAddress() {
		return address;
	}
	 
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Organizer [id=" + id + ", name=" + name + ", password=" + password + ", city=" + city + ", address=" + address + "]";
	}
	
	public String toStringNoId()
	{
		return "Organizer [name=" + name + ", password=" + password + ", city=" + city + ", address=" + address + "]";
	}

}
