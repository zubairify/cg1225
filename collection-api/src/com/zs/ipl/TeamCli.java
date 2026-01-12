package com.zs.ipl;

import java.util.Scanner;

public class TeamCli {
	private static TeamService service = new TeamServiceImpl(new TeamDaoImpl());

	public static void main(String[] args) {
		// Show the menu
		int choice;
		while(true) {
			Scanner console = new Scanner(System.in);
			System.out.println("1. Add\n2. Find\n3. List\n4. Delete\n5. Exit");
			System.out.print("Enter your choice: ");
			choice = console.nextInt();
			switch(choice) {
			case 1 : addTeam(); break;
			case 2 : findTeam(); break;
			case 3 : listTeams(); break;
			case 4 : delTeam(); break;
			case 5 : System.exit(0);
			default : System.out.println("Invalid choice");
			}
		}
	}

	private static void delTeam() {
		
	}

	private static void listTeams() {
		
	}

	private static void findTeam() {
		
	}

	private static void addTeam() {
		
	}
}
