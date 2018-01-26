package model;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Party {
	private int id;
	private String name;
	private String organizerId;
	private String organizerName;
	private String date;
	private String city;
	private String address;
	private String description;
	private double price;
	private int tickets;
	private double latitude;
	private double longitude;
	
	public Party(){
		
	}
	
	public Party(int id, String name, String organizerId, String organizerName, String date, 
			String city, String address,String description, double price, int tickets, double latitude, double longitude){
		super();
		this.id=id;
		this.name=name;
		this.organizerId=organizerId;
		this.organizerName=organizerName;
		this.date=date;
		this.city=city;
		this.address=address;
		this.description=description;
		this.price=price;
		this.tickets=tickets;
		this.latitude=latitude;
		this.longitude=longitude;
	}
		
		public int getId()
		{
		return id;
		}
		 
		public void setId(int id)
		{
		this.id = id;
		}
		 
		public String getName()
		{
		return name;
		}
		 
		public void setName(String name)
		{
		this.name = name;
		}
		 
		public String getOrganizerId()
		{
		return organizerId;
		}
		 
		public void setOrganizerId(String organizerId)
		{
		this.organizerId = organizerId;
		}
		
		public String getOrganizerName()
		{
		return organizerName;
		}
		 
		public void setOrganizerName(String organizerName)
		{
		this.organizerName = organizerName;
		}
		 
		public String getDate()
		{
		return date;
		}
		 
		public void setDate(String date)
		{
		this.date = date;
		}
		
		public String getCity()
		{
		return city;
		}
		 
		public void setCity(String city)
		{
		this.city = city;
		}
		
		public String getAddress()
		{
		return address;
		}
		 
		public void setAddress(String address)
		{
		this.address = address;
		}
		
		public String getDescription()
		{
		return description;
		}
		 
		public void setDescription(String description)
		{
		this.description = description;
		}
		
		public double getPrice()
		{
		return price;
		}
		 
		public void setPrice(double price)
		{
		this.price = price;
		}
		
		public int getTickets()
		{
		return tickets;
		}
		 
		public void setTickets(int tickets)
		{
		this.tickets = tickets;
		}
		
		public double getLatitude()
		{
		return latitude;
		}
		 
		public void setLatitude(double latitude)
		{
		this.latitude = latitude;
		}
		
		public double getLongitude()
		{
		return longitude;
		}
		 
		public void setLongitude(double longitude)
		{
		this.longitude = longitude;
		}
		
		@Override
		public String toString()
		{
		return "Party [id=" + id + ", name=" + name + ", organizerId=" + organizerId
		+ ", organizerName=" + organizerName+ ", date=" + date + ", city=" + city + ", address=" + address + ", tickets= " + tickets + "]";
		}
		
		public String toStringNoId()
		{
		return "Party [name=" + name + ", organizerId=" + organizerId
		+ ", organizerName=" + organizerName+ ", date=" + date + ", city=" + city + ", address=" + address + ", tickets= " + tickets + "]";
		}
}

