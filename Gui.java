import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class Gui extends JFrame {
	
	private ArrayList<Fleet> fleets;
	
	private JPanel panel;
	private JTextField fleetNameField;
	private JButton autonomyButton, fileButton;
	
	public Gui() {
		
		try {
			FileInputStream inFile = new FileInputStream("fleets.ser");
			ObjectInputStream in = new ObjectInputStream(inFile);
			fleets = (ArrayList<Fleet>) in.readObject();
			in.close();
			inFile.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		panel = new JPanel();
		fleetNameField = new JTextField("Fleet Name");
		autonomyButton = new JButton("Calculate Autonomy");
		fileButton = new JButton("Serialization");
		
		autonomyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String fleetName = fleetNameField.getText();
				Fleet selectedFleet = null;
				for(Fleet fleet : fleets) {
					if(fleetName.equals(fleet.getName()))
						selectedFleet = fleet;
				}
				
				System.out.println("Fleet Name: " + selectedFleet.getName());
				System.out.println("Number of Taxis: " + selectedFleet.calculateTaxisNumber());
				System.out.println("Total Autonomy: " + selectedFleet.calculateTotalAutonomy());
			}
			
		});
		
		fileButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String fleetName = fleetNameField.getText();
				
				Fleet selectedFleet = null;
				for(Fleet fleet : fleets) {
					if(fleetName.equals(fleet.getName()))
						selectedFleet = fleet;
				}
				
				File file = new File("Paraskevi_Xanthopoulou.txt");
				try {
					FileWriter writer = new FileWriter(file);
					writer.write(fleetName);
					writer.write(System.lineSeparator());
					
					for(Taxi taxi : selectedFleet.getTaxis()) {
						writer.write(taxi.getDriversName() + ", " + taxi.getLicencePlate() + ", " + taxi.calculateAutonomy());
						writer.write(System.lineSeparator());
					}
					
					writer.write(Double.toString(selectedFleet.calculateTotalAutonomy()));
					writer.close();
					
				} catch (IOException e1) {
					e1.printStackTrace();
					System.out.println("!!!");
				}				
			}
			
		});
		
		panel.add(fleetNameField);
		panel.add(autonomyButton);
		panel.add(fileButton);
		
		this.setContentPane(panel);
		
		
		this.setVisible(true);
		this.setSize(400,400);
		this.setTitle("Fleet");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

}
