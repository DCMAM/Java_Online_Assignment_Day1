import java.util.Scanner;

public class Main {
	static Scanner input = new Scanner(System.in);
	
	public static void printMenu() {
		System.out.println("1. Start Simulation");
		System.out.println("2. How to play");
		System.out.println("3. Exit");
		System.out.print(">> ");
	}
	
	public static void printMenu2() {
		System.out.println("1. Introduction");
		System.out.println("Hamster Master is a Simulation Application for someone that want to practice their nurture skill before actually buy a real hamster to pet\n");
		System.out.println("2. Guide to be a better Hamster Master");
		System.out.println("- You need to make score as much as possible");
		System.out.println("- Make your hasmter work so you can earn score");
		System.out.println("- Make your hamster play if its Happiness points are low");
		System.out.println("- Make your hamster sleep if its Energy point are low");
		System.out.println("- The simulation will end if its Energy point are below or equal to 0\n");
	}
	
	public static void clearScreen() {
		for(int i=0; i<30; i++) System.out.println(" ");
	}
	
	public static void printMenu1() {
		System.out.println("Simulation Status");
		System.out.println("=================");
		System.out.println("1. Work");
		System.out.println("2. Play");
		System.out.println("3. Sleep");
		System.out.println("4. End Simulation");
		System.out.print(">> ");
	}
	
	public static void gameplay() {
		String name;
		do {
			System.out.print("What's your hamster name [5..12]: ");
			name = input.nextLine();			
		}while(name.length() < 5 || name.length() > 12);
		do {
			printMenu1();
			String menu1 = input.nextLine();
			if(menu1.equals("1")) {
				if(happiness <= 50) {
					System.out.println(name + "doesn't have enough happiness!");
				}
				else if(happiness > 50 ) {
					int num1 = (int)(Math.random()*99)+1;
					int num2 = 2;
					int num3 = (int)(Math.random()*99)+1;
					hour = (hour + 1) % 24;
					happiness = happiness - 10;
					int lostEnergy = (int)(Math.random()*19)+1;
					energy = energy - lostEnergy;
					System.out.println("What's the result fot the following equation?");
					if(num3 == 0) {
						System.out.println(num1 + " + " + num2 + " = ");
						int num4 = input.nextInt();
						System.out.println("right answer: " + (num1 + num2));
						if(num4 == num1 + num2) {
							int increasingScore = 10 + day;
							score = score + increasingScore;
							System.out.println(name + "'s answer is right!");
							System.out.println(name + " gets " + increasingScore + " score!");
						}
						else {
							System.out.println(name + " answer is wrong!");
							System.out.println(name + " doesn't get any score!");
						}
						System.out.println(name + " uses 10 of its happiness!");
						System.out.println(name + " uses " + lostEnergy + " of its energy!");
					}
					else {
						System.out.println(num1 + " - " + num2 + " = ");
						int num4 = input.nextInt();
						System.out.println("right answer: " + (num1 - num2));
						if(num4 == num1 - num2) {
							int increasingScore = 10 + day;
							score = score + increasingScore;
							System.out.println(name + "'s answer is right!");
							System.out.println(name + " gets " + increasingScore + " score!");
						}
						else {
							System.out.println(name + " answer is wrong!");
							System.out.println(name + " doesn't get any score!");
						}
						System.out.println(name + " uses 10 of its happiness!");
						System.out.println(name + " uses " + lostEnergy + " of its energy!");
					}
				}
			}
			else if(menu1.equals("2")) {
				energy = energy - 10;
				if(happiness >= 100) {
					System.out.println(name + " is playing!");
					System.out.println(name + "'s happiness are full!");
				}
				else {
					happiness = happiness + ((happiness + 15) % 100);
					System.out.println(name + " is playing!");
					System.out.println(name + " gets 15 point of happiness!");
				}
				System.out.println(name + " uses 10 of its energy!");
			}
			else if(menu1.equals("3")) {
				if(energy >= 50) {
					System.out.println(name + " doesn't want to sleep!");
				}
				else {
					System.out.println(name + " is sleeping!");
					System.out.println(name + " gets " + (100-energy) + " point of energy!");
					day = day + 1;
					hour = 5;
					energy = 100;
				}
			}
			else if(menu1.equals("4")) {
				System.out.println("Game over!");
				System.out.println("Your total score is: " + score);
				break;
			}
			else {
				System.out.println("You should input 1-4!");
			}
		}while(true);
	}
	
	static int score = 0;
	static int day = 1;
	static float hour = 5;
	static int happiness = 100;
	static int energy = 100;
	
	public static void init() {
		score = 0;
		day = 1;
		hour = 5;
		happiness = 100;
		energy = 100;
	}
	
	public static void main(String[] args) {
		do {
			clearScreen();
			printMenu();
			String menu = input.nextLine();
			if(menu.equals("1")) {
				init();
				clearScreen();
				gameplay();
			}
			else if(menu.equals("2")) {
				printMenu2();
				input.nextLine();
			}
			else if(menu.equals("3")) {
				break;
			}
			else {
				System.out.println("You should input 1-3!");
			}
		}while(true);
	}
}
