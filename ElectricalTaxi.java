
public class ElectricalTaxi extends Taxi {

	private int batteries;
	
	
	public ElectricalTaxi(String licencePlate, String driversName, int batteries) {
		super(licencePlate, driversName);
		this.batteries = batteries;
	}

	public double calculateAutonomy() {
		return 70*batteries;
	}
	
	

}
