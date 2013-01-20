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
    if(arg.length == 0) {
      System.out.println("No arguments specified. Amounts of neurons in each layer expected.");
      return;
    }

    for(String numOfNeurons : arg) {
      net.addLayer(new Layer(Integer.parseInt(numOfNeurons)));
    }

    Integer totalNumberOfIterations = train(net);
    System.out.println("Total number of iterations: ".concat(totalNumberOfIterations.toString()));
	}

	private static int train(Network net) {
		int totalNumOfIters = 0;
	  try {
			CSVReader reader = new CSVReader(new FileReader("test.csv"));
			String[] nextLine;
			int i = 0;
			while ((nextLine = reader.readNext()) != null && i < 40) {
				// convert data to doubles
				int dataSize = nextLine.length - 1; // all except the result
				double[] data = new double[dataSize];
				for (int j = 0; j < dataSize; ++j)
					data[j] = Double.parseDouble(nextLine[j]);

				// get result
				Double result = (nextLine[4] == "normal") ? 0.0 : 1.0;

				// training session
				double error;
				double eps = 0.01;
				int j = 0;
				do {
					error = trainingSession(net, data, result);
					j++;
					totalNumOfIters++;
				} while (error > eps);
				System.out.println("Completed training session in " + j
						+ " iterations");

				i++;
			}
			reader.close();
		} catch (FileNotFoundException e1) {
			System.out.println("No such file");
			e1.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading");
			e.printStackTrace();
		} catch (UnsuitableDataException e) {
			System.out.println("Unsuitable data");
		}
	  
	  return totalNumOfIters;
	}

	private static double trainingSession(Network net, double[] data,
			Double result) throws UnsuitableDataException {
		List<Double> results = net.forwardPropagate(data);
		//System.out.println(results.get(0).toString() + " blad: "
		//		+ (new Double((result - results.get(0)))).toString());
		net.backPropagate(result);
		return result - results.get(0);

	}
}