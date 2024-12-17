package train;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import train.Service.*;
import java.util.Scanner;

public class DataHub {

	static Scanner scan = new Scanner(System.in);

	/*
	 * Builds the API request using the apikey
	 */
	public static class generateAPI {
		final OkHttpClient client = new OkHttpClient();

		String run(String url) throws IOException {
			String apiKey = System.getenv("RAILDATA_API_KEY");

			Request request = new Request.Builder()
					.url(url)
					.addHeader("x-apikey", apiKey)
					.build();

			try (Response response = client.newCall(request).execute()) {
				return response.body().string();
			}
		}
	}

	/*
	 * Finds all the useful data that we need through the classes and adds to them
	 * to a new class
	 * called Trainboard for ease of use
	 */
	private static void addServicesToTrainBoard(Root root, ArrayList<TrainBoard> trainBoardInformation) {
		ArrayList<TrainService> trainServices = root.getTrainServices();

		for (TrainService trainService : trainServices) {
			TrainBoard trainBoard = new TrainBoard();

			trainBoard.setEstTime(trainService.getEtd());
			trainBoard.setDestination(trainService.getDestination().get(0).getLocationName());
			trainBoard.setDepartureTime(trainService.getStd());
			trainBoard.setPlatformNo(trainService.getPlatform());
			ArrayList<CallingPoint> callingPoints = new ArrayList<>();
			ArrayList<SubsequentCallingPoint> subCallPoints = trainService.getSubsequentCallingPoints();
			ArrayList<CallingPoint> callPoints = subCallPoints.get(0).getCallingPoint();
			for (CallingPoint callPoint : callPoints) {
				callingPoints.add(callPoint);
			}
			trainBoard.setCallingStations(callingPoints);
			trainBoard.setTrainService(trainService.getOperator());
			trainBoard.setOnTime(trainService.getEtd());
			trainBoard.setNoCarriages(trainService.getLength());
			trainBoard.setOrigin(root.getLocationName());
			if (trainService.getCancelReason() != null)
				trainBoard.setCancelReason(trainService.getCancelReason());
			else if (trainService.getDelayReason() != null)
				trainBoard.setCancelReason(trainService.getDelayReason());
			trainBoardInformation.add(trainBoard);

		}
	}

	/*
	 * A method just to ensure the data being produced from the API is correct
	 * and to visually see everything is ok
	 */
	private static void printTrainBoardInformation(ArrayList<TrainBoard> trainBoardInformation) {
		for (TrainBoard trainBoard : trainBoardInformation) {
			System.out.print("\n" + trainBoard.getDestination());
			System.out.print(" " + trainBoard.getDepartureTime());
			System.out.print(" Platform " + trainBoard.getPlatformNo() + " ");
			System.out.println();
			ArrayList<CallingPoint> callingPointTest = trainBoard.getCallingStations();
			for (CallingPoint testCallPoint : callingPointTest) {
				System.out.println("- " + testCallPoint.getLocationName());
			}
			System.out.println("\nThis train is operator is " + trainBoard.getTrainService());
		}
	}

	/*
	 * To validate the users input to edit the API request, compares it to list of
	 * station codes
	 * avaliable to the system
	 */
	public static boolean validateUserInput(String userInput, ArrayList<StationInformation> stations) {
		for (StationInformation station : stations) {
			if (station.getCrs().equalsIgnoreCase(userInput)) {
				return true;
			}
		}
		return false;
	}

	public static String getUserInput(ArrayList<StationInformation> stations) {
		String userInput = "";
		while (!validateUserInput(userInput, stations)) {
			System.out.print("Enter the CRS code for the station you would like to the view data for: ");
			userInput = scan.nextLine();
			if (!validateUserInput(userInput, stations)) {
				System.out.println("Please enter a corret station code");
			}
		}
		return userInput;
	}

	public void createBoard(int platformNo) throws IOException {
		ArrayList<TrainBoard> trainBoardInformation = new ArrayList<TrainBoard>();
		generateAPI example = new generateAPI();
		BitmapGenerator image = new BitmapGenerator();
		
		// Uncomment if you want user input
		//DataLoader loader = new DataLoader();
		//ArrayList<StationInformation> stations = loader.loadCSV();
		// String userInput = getUserInput(stations).toUpperCase(); // Generates the user input and adds it the end of the
		// 															// API request to allow the user to specify
		// String response = example.run(
		// 		"https://api1.raildata.org.uk/1010-live-departure-board-dep/LDBWS/api/20220120/GetDepBoardWithDetails/"
		// 				+ userInput);

		// Comment out if you want user input, default set to LIV
		String response = example.run(
				"https://api1.raildata.org.uk/1010-live-departure-board-dep/LDBWS/api/20220120/GetDepBoardWithDetails/GSW");

		try {
			// Create a new ObjectMapper object
			ObjectMapper mapper = new ObjectMapper();
			// Parse the JSON data and read it into the Root object
			Root root = mapper.readValue(response, Root.class);
			addServicesToTrainBoard(root, trainBoardInformation);
			System.out.println("\nGenerating train services for - " + root.getLocationName());
			//printTrainBoardInformation(trainBoardInformation); // uncomment out to not print the station data
			image.bitMapDrawing(trainBoardInformation,platformNo); // creates the trainboard image, at the platform default 0
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}