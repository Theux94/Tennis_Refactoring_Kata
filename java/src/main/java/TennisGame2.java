package main.java;

public class TennisGame2 implements TennisGame {

	public int P1point = 0;
	public int P2point = 0;

	public String P1res = "";
	public String P2res = "";

	public String getScore() {
		String score = "";
		if (P1point == P2point && P1point < 4) {
			if (P1point == 0)
				score = "Love";
			else if (P1point == 1)
				score = "Fifteen";
			else if (P1point == 2)
				score = "Thirty";
			score += "-All";
		}
		if (P1point == P2point && P1point >= 3)
			score = "Deuce";

		if (P1point > 0 && P2point == 0) {
			if (P1point == 1)
				P1res = "Fifteen";
			else if (P1point == 2)
				P1res = "Thirty";
			else if (P1point == 3)
				P1res = "Forty";

			P2res = "Love";
			score = P1res + "-" + P2res;
		}
		if (P2point > 0 && P1point == 0) {
			if (P2point == 1)
				P2res = "Fifteen";
			else if (P2point == 2)
				P2res = "Thirty";
			else if (P2point == 3)
				P2res = "Forty";

				P1res = "Love";
			score = P1res + "-" + P2res;
		}

		if (P1point > P2point && P1point < 4) {
			if (P1point == 2)
				P1res = "Thirty";
			else if (P1point == 3)
				P1res = "Forty";
			if (P2point == 1)
				P2res = "Fifteen";
			else if (P2point == 2)
				P2res = "Thirty";
			
			score = P1res + "-" + P2res;
		}
		if (P2point > P1point && P2point < 4) {
			if (P2point == 2)
				P2res = "Thirty";
			else if (P2point == 3)
				P2res = "Forty";
			if (P1point == 1)
				P1res = "Fifteen";
			else if (P1point == 2)
				P1res = "Thirty";
			
			score = P1res + "-" + P2res;
		}

		if (P1point > P2point && P2point >= 3) {
			score = "Advantage player1";
		}

		if (P2point > P1point && P1point >= 3) {
			score = "Advantage player2";
		}

		if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
			score = "Win for player1";
		}
		if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
			score = "Win for player2";
		}
		MyLogger.getLogger().info("Value of getScore() in TennisGame2: " + score);
		return score;
	}

	public void setP1Score(int number) {
			P1point=number;	
	}

	public void setP2Score(int number) {
			P2point=number;
	}

	public void wonPoint(String player) {
		if (player.equals("player1"))
			P1point++;
		else
			P2point++;
	}
}