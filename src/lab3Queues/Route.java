package lab3Queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Route {
	public static Station[] stations;
	
	public Route(String fileName) {
		//read file 
		try(Scanner scan = new Scanner(new File("orange.txt"));){
			int temp = 0;
			while (scan.hasNextLine())
			{
				stations[temp] = new Station(scan.nextLine());
				temp++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initiallizeStations() {
		//for each statement generate a random number 0-15
		//for each passenger numbers, create new passenger
		//add it to queue
		for( Station eachStation : stations )
		{
			for(int i = 0; i < ((int)Math.random()*16); i++)
			{
				eachStation.add( new Passenger(/*PARAMETERS*/) );
			}
		}
	}
	
	public static void main(String[] args) {
		
		
	}
}
