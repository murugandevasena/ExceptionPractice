package com.cricket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="players_data")
public class Cricket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String nTeamName;
	private int jercyNo;
	private int tTwentyRuns;
	private int iplRuns;
	private int n5050Runs;
	private int totalRuns;
	private int matchPlayed;
	private int highestScore;
	private int auctionPrice;
	private float strikeRate;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getnTeamName() {
		return nTeamName;
	}
	public void setnTeamName(String nTeamName) {
		this.nTeamName = nTeamName;
	}
	public int getJercyNo() {
		return jercyNo;
	}
	public void setJercyNo(int jercyNo) {
		this.jercyNo = jercyNo;
	}
	public int gettTwentyRuns() {
		return tTwentyRuns;
	}
	public void settTwentyRuns(int tTwentyRuns) {
		this.tTwentyRuns = tTwentyRuns;
	}
	public int getIplRuns() {
		return iplRuns;
	}
	public void setIplRuns(int iplRuns) {
		this.iplRuns = iplRuns;
	}
	public int getN5050Runs() {
		return n5050Runs;
	}
	public void setN5050Runs(int n5050Runs) {
		this.n5050Runs = n5050Runs;
	}
	public int getTotalRuns() {
		//totalRuns = tTwentyRuns+iplRuns+n5050Runs;
		return totalRuns;
	}
	public void setTotalRuns(int totalRuns) {
		this.totalRuns = totalRuns;
	}
	public int getMatchPlayed() {
		return matchPlayed;
	}
	public void setMatchPlayed(int matchPlayed) {
		this.matchPlayed = matchPlayed;
	}
	public int getHighestScore() {
		return highestScore;
	}
	public void setHighestScore(int highestScore) {
		this.highestScore = highestScore;
	}
	public int getAuctionPrice() {
		return auctionPrice;
	}
	public void setAuctionPrice(int auctionPrice) {
		this.auctionPrice = auctionPrice;
	}
	public float getStrikeRate() {
		return strikeRate;
	}
	public void setStrikeRate(float strikeRate) {
		this.strikeRate = strikeRate;
	}	
}
