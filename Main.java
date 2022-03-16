import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Fleet> fleets = new ArrayList<>();
		
		Fleet f1 = new Fleet("Hrakleio");
		Fleet f2 = new Fleet("Rethymno");
		
		Taxi et1 = new ElectricalTaxi("ABC 4137", "Kostas Gianakis", 7);
		Taxi et2 = new ElectricalTaxi("DEF 4138", "Giorgos Odigos", 9);
		
		Taxi gt1 = new GasolineTaxi("GHI 4237", "Eleni Karadimou", 15, 1);
		Taxi gt2 = new GasolineTaxi("JKL 4238", "Stef Bartsi", 21, 1.5);
		
		f1.storeTaxi(et1);
		f1.storeTaxi(gt1);
		f2.storeTaxi(et2);
		f2.storeTaxi(gt2);
		
		fleets.add(f1);
		fleets.add(f2);
		
		try {
			FileOutputStream outFile = new FileOutputStream("fleets.ser");
			ObjectOutputStream out = new ObjectOutputStream(outFile);
			out.writeObject(fleets);
			out.close();
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new Gui();
		
	}

}
