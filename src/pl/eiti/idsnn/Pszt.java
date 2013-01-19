package pl.eiti.idsnn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import au.com.bytecode.opencsv.CSVReader;
import pl.eiti.idsnn.model.Layer;
import pl.eiti.idsnn.model.Network;

public class Pszt {
	public static void main(String arg[]) {
		System.out.println("Tak.");
		Network net = new Network();
		net.addLayer(new Layer(4));
		net.addLayer(new Layer(4));
		net.addLayer(new Layer(1));
		train(net);
		
	}

	private static void train(Network net) {
		CSVReader reader = null;
		try {
			reader = new CSVReader(new FileReader("test.csv"));
		} catch (FileNotFoundException e1) {
			System.out.println("No such file");
			e1.printStackTrace();
		}
		String[] nextLine;
		try {
			int i = 0;
			while ((nextLine = reader.readNext()) != null && i < 100) {
				LinkedList<Double> data = new LinkedList<Double>();
				data.add(Double.parseDouble(nextLine[0]));
				data.add(Double.parseDouble(nextLine[1]));
				data.add(Double.parseDouble(nextLine[2]));
				data.add(Double.parseDouble(nextLine[3]));
				
				net.forwardPropagate(data);
				Boolean result;
				if (nextLine[4] == "normal")
					 result = false;
				else
					result = true;
				
				net.backPropagate(result);
				i++;
			}
		} catch (IOException e) {
			System.out.println("Error reading");
			e.printStackTrace();
		}
	}
}