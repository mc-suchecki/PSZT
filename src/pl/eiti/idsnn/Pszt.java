package pl.eiti.idsnn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;
import pl.eiti.idsnn.model.Layer;
import pl.eiti.idsnn.model.Network;

public class Pszt {
	public static void main(String arg[]) {

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
			while ((nextLine = reader.readNext()) != null && i < 2) {
				int dataSize = nextLine.length - 1; // all except the result

				double[] data = new double[dataSize];

				for (int j = 0; j < dataSize; ++j)
					data[j] = Double.parseDouble(nextLine[j]);

				try {
					List<Double> results = net.forwardPropagate(data);
					System.out.println(results);
				} catch (Exception e) {
					System.out.println("Unsuitable data");
				}

				Double result = (nextLine[4] == "normal") ? 0.0 : 1.0;

				net.backPropagate(result);
				i++;
			}
		} catch (IOException e) {
			System.out.println("Error reading");
			e.printStackTrace();
		}
	}
}