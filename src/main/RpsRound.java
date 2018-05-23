package main;

import java.util.Random;

import static main.RpsGame.getPaper;
import static main.RpsGame.getRock;
import static main.RpsGame.getScissors;

public class RpsRound {
    private int round;
    private int roundCounter;
    private int userWinCounter;
    private int compWinCounter;

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }

    public int getUserWinCounter() {
        return userWinCounter;
    }

    public void setUserWinCounter(int userWinCounter) {
        this.userWinCounter = userWinCounter;
    }

    public int getCompWinCounter() {
        return compWinCounter;
    }

    public void setCompWinCounter(int compWinCounter) {
        this.compWinCounter = compWinCounter;
    }

    public void roundLoop(User user, String userAction) {
        Random rnd = new Random();
        int compShape = rnd.nextInt(3) + 1;
        int userShape = Integer.parseInt(userAction);  
        if (userShape==compShape) {
        	if(userShape==1) System.out.println("REMIS: " + user.getUserName() + " i komputer wybrali kamien");
        	else if (userShape==2)System.out.println("REMIS: " + user.getUserName() + " i komputer wybrali papier");
        	else if (userShape==3)System.out.println("REMIS: " + user.getUserName() + " i komputer wybrali nozyce");
        	setRoundCounter(getRoundCounter()+1);
        } else if ((userAction.equals(getRock())) && (compShape == 2)) {
            System.out.println("Komputer wygrywa: " +user.getUserName() + ": 'kamien', Komputer: 'papier'.");
            setRoundCounter(getRoundCounter()+1);
            setCompWinCounter(getCompWinCounter()+1);
        } else if ((userAction.equals(getRock())) && (compShape == 3)) {
            System.out.println(user.getUserName() + " wygrywa: " +user.getUserName() + ": 'kamien', Komputer: 'nozyce'.");
            setRoundCounter(getRoundCounter()+1);
            setUserWinCounter(getUserWinCounter()+1);
        } else if ((userAction.equals(getPaper())) && (compShape == 1)) {
            System.out.println(user.getUserName() + " wygrywa: " +user.getUserName() + ": 'papier', Komputer: 'kamien'.");
            setRoundCounter(getRoundCounter()+1);
            setUserWinCounter(getUserWinCounter()+1);;
        } else if ((userAction.equals(getPaper())) && (compShape == 3)) {
            System.out.println("Komputer wygrywa: " +user.getUserName() + ": 'papier', Komputer: 'nozyce'.");
            setRoundCounter(getRoundCounter()+1);
            setCompWinCounter(getCompWinCounter()+1);
        } else if ((userAction.equals(getScissors())) && (compShape == 1)) {
            System.out.println("Komputer wygrywa: " +user.getUserName() + ": 'nozyce', Komputer: 'kamien'.");
            setRoundCounter(getRoundCounter()+1);
            setCompWinCounter(getCompWinCounter()+1);
        } else if ((userAction.equals(getScissors())) && (compShape == 2)) {
            System.out.println(user.getUserName() + " wygrywa: " +user.getUserName() + ": 'nozyce', Komputer: 'papier'.");
            setRoundCounter(getRoundCounter()+1);
            setUserWinCounter(getUserWinCounter()+1);
        } else {
            System.out.println("Nie mozesz dokonac takiego wyboru.");
        }
    }
}

