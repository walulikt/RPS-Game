package main;

public class RpsGame {

    private final static String ROCK ="1";
    private final static String PAPER ="2";
    private final static String SCISSORS ="3";
    private RpsRound rpsRound;
    private User user;

    public RpsGame() {
        this.user = new User();
        this.rpsRound = new RpsRound();
    }

    public static String getRock() {
        return ROCK;
    }

    public static String getPaper() {
        return PAPER;
    }

    public static String getScissors() {
        return SCISSORS;
    }

    public RpsRound getRpsRound() {
		return rpsRound;
	}

	public void setRpsRound(RpsRound rpsRound) {
		this.rpsRound = rpsRound;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
        return user;
    }
	
    public void greetingRpsMethod(String userName) {
        user.setUserName(userName);
        System.out.println("Witaj w grze " + user.getUserName());
    }
    
    public boolean setVictoriesInTheRound (int numberOfVictories) {
    	if (numberOfVictories>0&&numberOfVictories<=10) {
    		rpsRound.setRound(numberOfVictories);
    		return true;
    	} else {
    		System.out.println("Wpisana wartosc jest z poza zakresu 1-10");
    		return false;
    	}
    }

    public void printOptions() {
    	System.out.println("\nW grze RPS dostepne sa nastepujace opcje: \n"+
        		"Klawisz: n - rozpocznij nowa gra \n"+
                "Klawisz: x - zakonczenie gry \n" +
                "Ktora opcje wybierasz? :");
    }
    
    public void newGame() {
    	System.out.println("Mozliwe zagrania \n"+
    			"Klawisz: " + ROCK + " - zagranie: 'kamien' \n" +
                "Klawisz: " + PAPER + " - zagranie: 'papier' \n" +
                "Klawisz: " + SCISSORS + " - zagranie: 'nozyczki' ");
    	getRpsRound().setUserWinCounter(0);
    	getRpsRound().setCompWinCounter(0);
    	getRpsRound().setRoundCounter(0);
    	System.out.println("Na poczatek podaj ilosc zwyciêstw wymaganych do zkoñczenia rundy: ");
    }

    public void printRoundResult(){
        System.out.println("Wynik po rundzie " + rpsRound.getRoundCounter() + ": " + user.getUserName() + " " +rpsRound.getUserWinCounter()
                + ", Komputer " + rpsRound.getCompWinCounter());
    }

    public void theGame (String userShapeNumber){       
    	rpsRound.roundLoop(user, userShapeNumber);
            printRoundResult();
            if (rpsRound.getUserWinCounter()==rpsRound.getRound()){
                System.out.println ("****** Ta rozgrywke wygral " + user.getUserName()+ " z wynikiem: " + rpsRound.getUserWinCounter() +" do " +rpsRound.getCompWinCounter() +" ******");
            } else if (rpsRound.getCompWinCounter()==rpsRound.getRound()) {
                System.out.println("****** Ta rozgrywke wygral KOMPUTER z wynikiem: " + rpsRound.getUserWinCounter() + " do " + rpsRound.getCompWinCounter() + " ******");
            }
        }
    
}
