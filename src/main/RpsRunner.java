package main;

import java.util.Scanner;

public class RpsRunner {
    public static void main(String[] args) {
        RpsGame game = new RpsGame();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Podaj swoje imie:");
        String scannedName = scanner.nextLine();
        game.greetingRpsMethod(scannedName);
        int numberOfVictories;
        
        boolean end = false;

        while (end==false) {
        	game.printOptions();
            String thisAction= game.getUser().userAction(scanner.next());
            scanner.nextLine();
            if (thisAction.equals("n")){
            	game.newGame();
            	String nrOfVicts = scanner.nextLine();
            	try {
            		numberOfVictories = Integer.parseInt(nrOfVicts);
            	} catch (NumberFormatException e) {
            		System.out.println("Wpisana wartosc ma nieprawidlowy format. Wpisz wartosc od 1 do 10");
            		continue;
            	}
            	if (game.setVictoriesInTheRound(numberOfVictories)) {
            		boolean userWins=true;
            		boolean compWins=true;
            	
            		while (userWins&&compWins) {   		
            			System.out.println("Wykonaj swoj ruch:");
            			String userAction = scanner.nextLine();
            			game.theGame(userAction);
            			userWins=!(game.getRpsRound().getUserWinCounter()>=numberOfVictories);
            			compWins=!(game.getRpsRound().getCompWinCounter()>=numberOfVictories);
            		}
            	} else continue;
            	
            } else if (thisAction.equals("x")){
                System.out.println("Czy jestes pewien, ze chcesz zakonczyc gre? 't' - Tak, 'n' - Nie");
                String endingAction = game.getUser().userAction(scanner.next());
                if (endingAction.equals("n")){
                    System.out.println(game.toString());
                } else if (endingAction.equals("t")){
                    end=true;
                }
            } else {
                System.out.println ("Nie moge tego zrobic. Wybierz opcje z menu:");
                System.out.println(game.toString());
            }
        }
        scanner.close();
    }
}
