package main.java;

import java.util.logging.Logger;

public class TennisGame3 implements TennisGame {
	
	final static Logger	logger = Logger.getLogger("TennisGame");
    
    private int pointsplayer2;
    private int pointsplayer1;
    private String player1;
    private String player2;
    
    private static final int MINPOINT = 4; 
    private static final int POINTDIFFERNCE = 6; 

    public TennisGame3(String player1, String player2) {
    	logger.info("Try new TennisGame3 with " + player1 + " & " + player2);
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getScore() {
        String score;
        String player;
        if (reachedMinPoints() && !hasWonWithoutExtend()) {
            String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"}; 
            score = points[pointsplayer1];
            logger.info("Points Player1 " + score + " & Points Player2 " + points[pointsplayer2]);
            if (pointsplayer1 == pointsplayer2){
            	return score + "-All";
			} else {
				return score + "-" + points[pointsplayer2];
			}
        } else {
        	logger.info("Points equal or win/advantage for one player");
            if (pointsplayer1 == pointsplayer2) {
            	return "Deuce";
            } else {
            	if (pointsplayer1 > pointsplayer2){
            		player = player1;
            	} else {
            		player = player2;
            	}
            	logger.info("Player with more points " + player);
            	if (pointDiffernce() == 1){
            		return "Advantage " + player;
            	} else {
            		return "Win for " + player;
            	}
            }
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.pointsplayer1 += 1;
        else
            this.pointsplayer2 += 1;
    }
    
    private boolean reachedMinPoints(){
    	if (pointsplayer1 < MINPOINT && pointsplayer2 < MINPOINT){
    		return true;
    	} else {
    		return false; 
    	}		
    }
    
    private boolean hasWonWithoutExtend(){
    	if (pointsplayer1 + pointsplayer2 == POINTDIFFERNCE){
    		return true;
    	} else {
    		return false; 
    	}		
    }
    
    private int pointDiffernce(){
    	return Math.abs(pointsplayer1-pointsplayer2);		
    }
    
}



