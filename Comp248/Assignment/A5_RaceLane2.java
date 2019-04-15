// -------------------------------------------------------
// Assignment 5 Question 3
// Written by: Jingchao Zhang 40049474
// For COMP 248 Section R – Fall 2017
// Date: Nov 25, 2017
// Purpose: Simulate a car race with the defined class Car. 
// --------------------------------------------------------
import java.util.Scanner;
public class A5_RaceLane2 {
	
	public static void main(String[] args) {
		
		//Read information of the race.
		int numberOfCars = 0, laps = 0; 
		Scanner keyIn = new Scanner(System.in);
		System.out.println("How many cars are going to race:");
		numberOfCars = keyIn.nextInt();
		A5_Car[] cars = new A5_Car[numberOfCars];
	
		System.out.println("How many laps: ");
		laps = keyIn.nextInt();
		
		//Read the initial information of the racing cars, and create each car object in the Car[] array.
		for (int i=0; i<numberOfCars; i++)
		{
			keyIn.nextLine();//The last keyIn is nextInt, so need to change to the next line.
			System.out.println("Please enter the model of car " + i);
			String model = keyIn.nextLine();
			System.out.println("Please enter the max speed of car " + i);
			int maxSpeed = keyIn.nextInt();
			while(maxSpeed<2 || maxSpeed>7) //Check the validity of maxSpeed
			{
				System.out.println("The maximum speed of a car ranges from 2 to 7. Enter again.");
				System.out.println("Please enter the max speed of car " + i);
				maxSpeed = keyIn.nextInt();
			}
			cars[i] = new A5_Car(model, maxSpeed);
		}
		
		//Start race
		int numberOfCrashedCarsInTotal = 0, numberOfCrashedCarsInThisRound = 0, numberOfArrivedCars = 0;
		A5_Car[] winners = new A5_Car[3];
		boolean isInFirstLap = true;
		boolean raceEnd = false;
		
		//If the race has not ended, go into the while loop.
		while(!raceEnd)
		{	
			for (int i = 0; i<numberOfCars; i++)
			{
				if(!cars[i].getStatusOfCrash() && !cars[i].getStatusOfArriving())
				{//if the car has not crashed and has not arrived, accelerate and move.
					cars[i].accelerate();
					cars[i].move();
				}
				System.out.println(cars[i]);
				//Check weather it is still in the first lap after each moving
				//Any car's location larger than 100 leads to the race getting out of the first lap.
				if (cars[i].getLocation() > 100)
					isInFirstLap = false;
			}
			
			if(!isInFirstLap)//Crash is detected after the first lap.
			{
				//detect the crash here
				//Compare the location of each car with all the other cars that have a higher index.
				for(int i=0; i<numberOfCars-1; i++) 
				{
					//The variable below is the number of crashed cars in a single round, 
					//so initialize it to zero at the beginning of each round.
					numberOfCrashedCarsInThisRound = 0;
					if (cars[i].getStatusOfCrash() || cars[i].getLocation() > (laps * 100))
						continue;//if a car is crashed or arrived, will not crash any more, so check the next car.
					int sameLocationCounter = 1;//Tracking the number of Cars at a same location
					for (int j=i+1; j<numberOfCars; j++)//Compare to the next car following
						//Compare the location of two cars on the race track.
					{
						if (cars[j].getStatusOfCrash() || cars[i].getLocation() > (laps * 100))
							continue;//only compare the cars in race
						if(cars[i].getLocation() % 100 == cars[j].getLocation() % 100) //at the same location on the lap.
							sameLocationCounter++;
					}
					if (sameLocationCounter > 2)//Crash happens!!!
					{
						//All cars must stop
						for (int j=0; j<numberOfCars; j++)
							cars[j].stop();
						
						System.out.println("The following cars got crashed: ");
						System.out.println(cars[i]);
						//Change the status of cars[i] to crashed.
						cars[i].crash();
						numberOfCrashedCarsInThisRound++;
						
						//Review the cars after cars[i] again and 
						//find all the other cars with the same location with cars[i], and also cash them!
						for (int j=i+1; j<numberOfCars; j++)
							//only consider the cars still in race
							if(cars[i].getLocation() % 100 == cars[j].getLocation() % 100 && 
									!cars[j].getStatusOfCrash() && !cars[j].getStatusOfArriving()) 
							{
								cars[j].crash();
								numberOfCrashedCarsInThisRound++;
								System.out.println(cars[j]);
							}
					}
					numberOfCrashedCarsInTotal += numberOfCrashedCarsInThisRound;
				}
				//If the car arrive the finish line, stop and copy this car to winners
				for (int i = 0; i<numberOfCars; i++)
					if (cars[i].getLocation() > (laps * 100) && !cars[i].getStatusOfArriving())
					{
						cars[i].arrive();
						cars[i].stop();
						numberOfArrivedCars++;
						if (numberOfArrivedCars<=3)
							winners[numberOfArrivedCars-1] = new A5_Car(cars[i]);//using copy constructor
					}
				
				//After counting the number of crashed cars, display the result below.
				System.out.println("Number of crashed cars: " + numberOfCrashedCarsInThisRound);
				System.out.println("Number of current cars in race " + 
									(numberOfCars - numberOfCrashedCarsInTotal - numberOfArrivedCars));
			}
			
			//Check race end.
			if (numberOfCrashedCarsInTotal == numberOfCars) //If all cars have crashed, race ends.
				raceEnd = true;
			else if ((numberOfCars - numberOfCrashedCarsInTotal)>=3 && numberOfArrivedCars >= 3)
				// If the the number of remaining cars is greater than or equal to 3, and at least 3 cars arrives, race ends.
				raceEnd = true;
			// If the the number of remaining cars is less than 3, but all of them arrive, race ends.
			else if (numberOfArrivedCars == (numberOfCars - numberOfCrashedCarsInTotal)) 
				raceEnd = true;
		}//if the race has not ended, go back to the beginning and start another round.
		
		//Race ends and display the winners
		if(numberOfCrashedCarsInTotal == numberOfCars)
			System.out.println("All cars have crashed! No winner.");
		else
		{
			System.out.println("The winners are: ");
			for(int i=0; i<3 && i<numberOfCars-numberOfCrashedCarsInTotal; i++)
				System.out.println(winners[i]);
		}
		
		keyIn.close();
	}
	
	
	
}
