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
    
    public void setVictoriesInTheRound (int numberOfVictories) {
        rpsRound.setRound(numberOfVictories);
    }

    @Override
    public String toString() {
        return "W grze RPS dostepne sa nastepujace opcje: \n"+
                "Klawisz: " + ROCK + " - zagranie: 'kamien' \n" +
                "Klawisz: " + PAPER + " - zagranie: 'papier' \n" +
                "Klawisz: " + SCISSORS + " - zagranie: 'nozyczki' \n" +
                "Klawisz: x - zakonczenie gry \n" +
                "Klawisz: n - rozpocznij nowa gra \n";
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
                System.out.println(toString());
            } else if (rpsRound.getCompWinCounter()==rpsRound.getRound()) {
                System.out.println("****** Ta rozgrywke wygral KOMPUTER z wynikiem: " + rpsRound.getUserWinCounter() + " do " + rpsRound.getCompWinCounter() + " ******");
                System.out.println(toString());
            }
        }
    
}
