package main.java;

public class TennisGame3 implements TennisGame {

	private int p2;
	private int p1;
	private String p1Name;
	private String p2Name;

	public TennisGame3(String p1Name, String p2Name) {
		this.p1Name = p1Name;
		this.p2Name = p2Name;
	}

	public String getScore() {
		String score;
		if (p1 < 4 && p2 < 4 && !(p1 + p2 == 6)) {
			
			String[] p = new String[] { "Love", "Fifteen", "Thirty", "Forty" };
			score = p[p1];
			MyLogger.getLogger().info("Value of getScore(): " + score);
			return (p1 == p2) ? score + "-All" : score + "-" + p[p2];
		} 
		else {
			
			if (p1 == p2) {
			MyLogger.getLogger().info("Value of getScore(): " + "Deuce");
			return "Deuce";
			}
			
			score = p1 > p2 ? p1Name : p2Name;
			MyLogger.getLogger().info("Value of getScore(): " + score);
			return ((p1 - p2) * (p1 - p2) == 1) ? "Advantage " + score : "Win for " + score;
		}
	}

	public void wonPoint(String playerName) {
		if (playerName.equals("player1"))
			this.p1 += 1;
		else
			this.p2 += 1;
	}

}
