package tester;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import app.*;

public class Tester {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		String input = "";
		boolean blockchainLoaded = false;
		
		BufferedReader br = null;
		String line = "";
		
		Blockchain blockchain = null;
		
		do {
			System.out.println("Ensurance CLI Beta");
			System.out.println("1. Load blockchain from file (.CSV)");
			System.out.println("2. Check insurance claim against blockchain");
			System.out.println("3. Append insurance claim to blockchain");
			System.out.println("4. Save blockchain to file (.CSV)");
			System.out.println("5. Exit\n");
			System.out.print("Choice: ");
			
			// TODO remove absolute path pastes
			input = scanner.nextLine();
			
			if (input.equals("1")) {
				System.out.print("\nPlease specify filename of blockchain: ");
				input = scanner.nextLine();
				System.out.println("\nSpecified " + input + "\n");
				blockchain = new Blockchain(input);
				blockchainLoaded = true;
				
			} else if (input.equals("2")) {
				if (blockchainLoaded == false) {
					System.out.println("Existing blockchain not loaded! Try again.");
				}
				else {
					System.out.print("\nPlease specify filename of claim: ");
					input = scanner.nextLine();
					System.out.println("Specified " + input + "\n");
					Claim test = new Claim(input);
					Block block = new Block(test, blockchain.getLastHash());
					if (blockchain.addAndCheckUnique(block) != true) {
						System.out.println("Added! But not unique.\n");
					} else {
						System.out.println("Added! Unique.\n");
					}
				}
				
			} else if (input.equals("3")) {
				if (blockchainLoaded == false) {
					System.out.println("\nExisting blockchain not loaded! Will create new blockchain.");
					System.out.print("\nPlease specify filename of claim: ");
					input = scanner.nextLine();
					System.out.println("\nSpecified " + input + "\n");
					blockchain = new Blockchain();
					Claim claim = new Claim(input);
					Block block = new Block(claim, "0");
					blockchain.add(block);
					blockchainLoaded = true;
					System.out.println("Added to new blockchain!\n");
				}
				else {
					System.out.print("\nPlease specify filename of claim: ");
					input = scanner.nextLine();
					System.out.println("Specified " + input + "\n");
					Claim claim = new Claim(input);
					Block block = new Block(claim, blockchain.getLastHash());
					if (blockchain.addAndCheckUnique(block) != true) {
						System.out.println("Added! But not unique.\n");
					} else {
						System.out.println("Added! Unique.\n");
					}
				}
				
			} else if (input.equals("4")) {
				if (blockchainLoaded == true) {
					System.out.print("\nPlease specify filename to save as: ");
					input = scanner.nextLine();
					FileWriter fileOut = new FileWriter(input);
					fileOut.append(blockchain.fileOutput());
					fileOut.flush();
					fileOut.close();
					System.out.println("\nSaved as " + input + "\n");
				} else {
					System.out.println("\nExisting blockchain not loaded! Try again.\n");
				}
				
			} else if (!input.equals("5")) {
				System.out.println("Invalid input! Try again." + "\n");
			}
		} while (!input.equals("5"));
		scanner.close();
	}

}
