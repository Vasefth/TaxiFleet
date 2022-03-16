import java.io.Serializable;

public abstract class Taxi implements Serializable {
	
	protected String licencePlate;
	protected String driversName;
	
	
	public Taxi(String licencePlate, String driversName) {
		this.licencePlate = licencePlate;
		this.driversName = driversName;
	}
	
	public String getDriversName() {
		return driversName;
	}
	
	public String getLicencePlate() {
		return licencePlate;
	}
	
	public abstract double calculateAutonomy();

}
