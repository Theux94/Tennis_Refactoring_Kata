package main.java;

public class TennisGame1 implements TennisGame {

	private int m_score1 = 0;
	private int m_score2 = 0;

	public void wonPoint(String playerName) {
		if (playerName.equals("player1"))
			m_score1 += 1;
		else
			m_score2 += 1;
	}

	public String getScore() {
		String score = "";
		int tempScore = 0;
		if (m_score1 == m_score2) {
			switch (m_score1) {
			case 0:
				score = "Love-All";
				break;
			case 1:
				score = "Fifteen-All";
				break;
			case 2:
				score = "Thirty-All";
				break;
			default:
				score = "Deuce";
				break;

			}
		} else if (m_score1 >= 4 || m_score2 >= 4) {
			int minusResult = m_score1 - m_score2;
			if (minusResult == 1)
				score = "Advantage player1";
			else if (minusResult == -1)
				score = "Advantage player2";
			else if (minusResult >= 2)
				score = "Win for player1";
			else
				score = "Win for player2";
		} else {
			StringBuffer buf = new StringBuffer();
			for (int i = 1; i < 3; i++) {
				if (i == 1)
					tempScore = m_score1;
				else {
					buf.append("-");
					tempScore = m_score2;
				}
				switch (tempScore) {
				case 0:
					buf.append("Love");
					break;
				case 1:
					buf.append("Fifteen");
					break;
				case 2:
					buf.append("Thirty");
					break;
				case 3:
					buf.append("Forty");
					break;
				default:
					buf.append("Love");
					break;
				}
				score = buf.toString();
			}
		}
		MyLogger.getLogger().info("Value of getScore() in TennisGame1: " + score);
		return score;
	}
}
