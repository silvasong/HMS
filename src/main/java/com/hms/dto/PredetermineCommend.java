package com.hms.dto;
// Generated 2015-1-11 18:26:37 by Hibernate Tools 4.0.0

/**
 * PredetermineCommend generated by hbm2java
 */
public class PredetermineCommend implements java.io.Serializable {

	private int commendId;
	private String predetermineId;
	private String commendContend;
	private float score1;
	private float score2;
	private float score3;

	public PredetermineCommend() {
	}

	public PredetermineCommend(int commendId, String predetermineId,
			String commendContend, float score1, float score2) {
		this.commendId = commendId;
		this.predetermineId = predetermineId;
		this.commendContend = commendContend;
		this.score1 = score1;
		this.score2 = score2;
	}

	public int getCommendId() {
		return this.commendId;
	}

	public void setCommendId(int commendId) {
		this.commendId = commendId;
	}

	public String getPredetermineId() {
		return this.predetermineId;
	}

	public void setPredetermineId(String predetermineId) {
		this.predetermineId = predetermineId;
	}

	public String getCommendContend() {
		return this.commendContend;
	}

	public void setCommendContend(String commendContend) {
		this.commendContend = commendContend;
	}

	public float getScore1() {
		return this.score1;
	}

	public void setScore1(float score1) {
		this.score1 = score1;
	}

	public float getScore2() {
		return this.score2;
	}

	public void setScore2(float score2) {
		this.score2 = score2;
	}

	public float getScore3() {
		return score3;
	}

	public void setScore3(float score3) {
		this.score3 = score3;
	}
	

}
