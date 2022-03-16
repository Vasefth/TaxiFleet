import java.io.Serializable;
import java.util.ArrayList;

public class Fleet implements Serializable {
	
	private String name;
	private ArrayList<Taxi> taxis;
	
	
	public Fleet(String name) {
		this.name = name;
		taxis = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<Taxi> getTaxis(){
		return taxis;
	}

	public void storeTaxi(Taxi t) {
		taxis.add(t);
	}
	
	public int calculateTaxisNumber() {
		int counter = 0;
		for(Taxi taxi: taxis)
			counter++;
		return counter;
	}
	
	public double calculateTotalAutonomy() {
		double totalAutonomy = 0;
		for(Taxi taxi : taxis) {
			totalAutonomy+=taxi.calculateAutonomy();
		}
		return totalAutonomy;
	}
}
