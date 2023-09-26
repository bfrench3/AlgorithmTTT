package all;
import java.util.*;
public class Tictactoe {

	public static void main(String[] args) {
		
		Scanner scnr = new Scanner(System.in);

		String loop = ""; //initialize loop check variable
		do {
			char[][] arr = new char[3][3];	//initialize tic tac toe grid
			fill(arr); //fill with dashes
			boolean x = false; //initialize all exit cases x, o , tie to false
			boolean o = false;
			boolean tie = false;


			System.out.println("WARNING: IF YOU CHOOSE A SQUARE THAT'S ALREADY BEEN "
					+ "SELECTED, YOU WILL LOSE YOUR TURN!");
			System.out.println("0 is row/column 1\n1 is row/column 2\nand 2 is row"
					+ "/column 3");
			System.out.println("Have fun!"); //print message to warn players of incorrect moves
			System.out.println("Would you like to play 1 player or 2 player? (1 for "
					+ "one player, 2 for 2 players)");
			int mode = scnr.nextInt();

			if (mode == 2) {
				System.out.println("Player 1 name (1 word): ");
				String name1 = scnr.next();
				
				System.out.println("Player 2 name (1 word): ");
				String name2 = scnr.next();
				do {
					System.out.println(name1 + " (x) make your turn (row then column): ");
					int row = scnr.nextInt(); //gets both coordinates for their move
					int column = scnr.nextInt();

					try {
						if(arr[row][column] == '-') { //makes sure space is open
							arr[row][column] = 'x'; //adds x in that location if true
						}
					}catch(ArrayIndexOutOfBoundsException ex) { //throws exception if player uses
						//invalid input
					}

					System.out.println(); //empty line

					x = xWin(arr);
					if(x == true) {
						print(arr);
						System.out.println(name1+ " wins!");
						break;
					}

					tie = isFull(arr);
					if(tie == true) {
						System.out.println("The game ends in a tie!");
						print(arr);
						break;
					}


					print(arr);//invoke print to show grid so player knows whats available

					System.out.println(name2 + " (o) make your turn (row,column): ");
					row = scnr.nextInt();
					column = scnr.nextInt(); //same thing but for player 2

					try {
						if(arr[row][column] == '-') {
							arr[row][column] = 'o'; //adds x in that location
						}
					}catch(ArrayIndexOutOfBoundsException ex) {

					}
					o = oWin(arr); //once again checks for winning conditions
					if(o == true) {
						print(arr);
						System.out.println(name2+ " wins!");
						break;
					}
					tie = isFull(arr);
					if(tie == true) {
						print(arr);
						System.out.println("The game ends in a tie!");
						break;
					}
					//invoke print to show grid	
					print(arr);


				}while(true);	

			}




			int min = 0; //initialize vars for random move selection for cpu
			int max = 2;




			if(mode == 1) {
				System.out.println("Player 1 name: ");
				String name1 = scnr.next();

				System.out.println("Choose difficulty, type Easy Medium or Hard: ");
				String difficulty = scnr.next();
				if(difficulty.equalsIgnoreCase("easy")) {
					do {
						System.out.println(name1 + " (x) make your turn (row then column): ");
						int row = scnr.nextInt(); //gets both coordinates for their move
						int column = scnr.nextInt();
						try {
							if(arr[row][column] == '-') { //makes sure space is open
								arr[row][column] = 'x'; //adds x in that location if true
							}
						}catch(ArrayIndexOutOfBoundsException ex) { //throws exception if player uses
							//invalid input
						}

						System.out.println(); //empty line

						x = xWin(arr);
						if(x == true) { //check if game has been won or is a tie if not it will  brewak
							print(arr);
							System.out.println(name1+ " wins!");
							break;
						}

						tie = isFull(arr);
						if(tie == true) {
							System.out.println("The game ends in a tie!");
							print(arr);
							break;
						}


						print(arr);//invoke print to show grid so player knows whats available


						row = (int)Math.floor(Math.random() *(max - min + 1) + min);
						column = (int)Math.floor(Math.random() *(max - min + 1) + min);

						if(arr[row][column] != 'x') {
							arr[row][column] = 'o'; //adds x in that location
						}


						o = oWin(arr);  //these 3 conditions check if game has been won yet and if so,
						if(o == true) { //break
							System.out.println("CPU wins!");
							print(arr);
							break;
						}
						tie = isFull(arr);
						if(tie == true) {
							System.out.println("The game ends in a tie!");
							print(arr);
							break;
						}
						System.out.println("Computer move: ");
						print(arr);
					}while(true);
				}

				if(difficulty.equalsIgnoreCase("medium")) {
					do {
						System.out.println(name1 + " (x) make your turn (row then column): ");
						int row = scnr.nextInt(); //gets both coordinates for their move
						int column = scnr.nextInt();
						try {
							if(arr[row][column] == '-') { //makes sure space is open
								arr[row][column] = 'x'; //adds x in that location if true
							}
						}catch(ArrayIndexOutOfBoundsException ex) { //throws exception if player uses
							//invalid input
						}

						System.out.println(); //empty line

						x = xWin(arr);
						if(x == true) {
							print(arr);
							System.out.println(name1+ " wins!");
							break;
						}

						tie = isFull(arr);
						if(tie == true) {
							System.out.println("The game ends in a tie!");
							print(arr);
							break;
						}


						print(arr);//invoke print to show grid so player knows whats available

						do {
							row = (int)Math.floor(Math.random() *(max - min + 1) + min);
							column = (int)Math.floor(Math.random() *(max - min + 1) + min);

							if(arr[row][column] == '-') {
								arr[row][column] = 'o';
								break;//adds x in that location
							}
						}while(true);


						o = oWin(arr);  //these 3 conditions check if game has been won yet and if so,
						if(o == true) { //break
							System.out.println("CPU wins!");
							print(arr);
							break;
						}
						tie = isFull(arr);
						if(tie == true) {
							System.out.println("The game ends in a tie!");
							print(arr);
							break;
						}
						System.out.println("Computer move: ");
						print(arr);
					}while(true);
				}
				if(difficulty.equalsIgnoreCase("hard")) {
					do {
						System.out.println(name1 + " (x) make your turn (row then column): ");
						int row = scnr.nextInt(); //gets both coordinates for their move
						int column = scnr.nextInt();
						try {
							if(arr[row][column] == '-') { //makes sure space is open
								arr[row][column] = 'x'; //adds x in that location if true
							}
						}catch(ArrayIndexOutOfBoundsException ex) { //throws exception if player uses
							//invalid input
						}

						System.out.println(); //empty line

						x = xWin(arr);
						if(x == true) {
							print(arr);
							System.out.println(name1+ " wins!");
							break;
						}

						tie = isFull(arr);
						if(tie == true) {
							System.out.println("The game ends in a tie!");
							print(arr);
							break;
						}


						print(arr);//invoke print to show grid so player knows whats available

						do {
							int count=0;
							boolean moved = false;

							for(int i = 0;i<3;i++) {
								for(int j = 0;j<3;j++) {
									if(arr[i][j] == 'x') {
										count++;
									}
								}if (count == 2) {
									for(int k = 0;k<3;k++) {
										if(arr[i][k] == '-') {
											arr[i][k] = 'o';
											moved = true;
											break;
										}
									}
								}
								count = 0;
							}
							if(moved == true) {
								break;
							}
							
							for(int i = 0;i<3;i++) {
								for(int j = 0;j<3;j++) {
									if(arr[j][i] == 'x') {
										count++;
									}
								}if(count == 2) {
									for(int k = 0;k<3;k++) {
										if(arr[j][k] == '-') {
											
										}
									}
								}
							}
							
							if(moved == true) {
								break;
							}

							else {
								row = (int)Math.floor(Math.random() *(max - min + 1) + min);
								column = (int)Math.floor(Math.random() *(max - min + 1) + min);

								if(arr[row][column] == '-') {
									arr[row][column] = 'o';
									break;//adds x in that location
								}
							}
					
						}while(true);


						o = oWin(arr);  //these 3 conditions check if game has been won yet and if so,
						if(o == true) { //break
							System.out.println("CPU wins!");
							print(arr);
							break;
						}
						tie = isFull(arr);
						if(tie == true) {
							System.out.println("The game ends in a tie!");
							print(arr);
							break;
						}
						System.out.println("Computer move: ");
						print(arr);
					}while(true);

				}
				else
					System.out.println("you entered an invalid input");

			}
			System.out.println("Would you like to play again? (yes or no)");
			loop = scnr.next();
		}while (!loop.equalsIgnoreCase("no"));
		System.out.println("Goodbye :)");
	}
	public static void fill(char[][] ar) { //method to fil grid with dashes so it is 
		for(int i = 0;i<3;i++) {			//uniform
			for(int j = 0;j<3;j++) {		
				ar[i][j] = '-';
			}
		}
	}

	public static boolean xWin(char [][] ar) { //checks all cases for x winning
		int count = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(ar[i][j] == 'x')
					count++;
			}
			if (count == 3) {

				return true;
			}
			count = 0;
		}
		count = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(ar[j][i] == 'x')
					count++;
			}
			if(count == 3) {

				return true;
			}
			count = 0;
		}

		if((ar[0][0] == 'x' && ar[1][1] == 'x' && ar[2][2] == 'x') || (ar[0][2] == 'x' 
				&& ar[1][1] == 'x' && ar[2][0] == 'x')) {
			return true;
		}

		return false; //if none are true, return false



	}

	public static boolean oWin(char [][] ar) { //checks all cases for o winning
		int count = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(ar[i][j] == 'o')
					count++;
			}
			if (count == 3)
				return true;
			count = 0;
		}
		count = 0;
		for(int i = 0;i<3;i++) {
			for(int j = 0;j<3;j++) {
				if(ar[j][i] == 'o')
					count++;
			}
			if(count == 3)
				return true;
			count = 0;
		}

		if((ar[0][0] == 'o' && ar[1][1] == 'o' && ar[2][2] == 'o') || (ar[0][2] == 'o' && ar[1][1] == 'o' && ar[2][0] == 'o')) {
			return true;
		}

		return false; //if none are true, return false
	}

	public static boolean isFull(char [][] ar) {
		int count = 0;
		for(int i = 0; i<3;i++) {
			for(int j = 0;j<3;j++) {
				if (ar[i][j] == 'o' || ar[i][j] == 'x')
					count++;
			}
		}
		if(count == 9)
			return true;
		else
			return false;		
	}

	public static void print(char [][] ar) {

		for(int i = 0;i<ar.length;i++) {
			for(int j = 0;j<ar[i].length;j++) {
				System.out.print(ar[i][j] + " "); //prints out each element
				//of 2d array
			}
			System.out.println();
		}

	}

}

