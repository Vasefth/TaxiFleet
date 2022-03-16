
public class GasolineTaxi extends Taxi {
	
	private int reservoir;
	private double consumption;
	

	public GasolineTaxi(String licencePlate, String driversName, int reservoir, double consumption) {
		super(licencePlate, driversName);
		this.reservoir = reservoir;
		this.consumption = consumption;
	}

	public double calculateAutonomy() {
		return 90*(reservoir/consumption);
	}

	
}
