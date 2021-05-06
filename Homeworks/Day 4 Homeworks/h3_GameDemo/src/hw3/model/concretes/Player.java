package hw3.model.concretes;

import java.util.Calendar;
import java.util.List;

import hw3.model.abstracts.Entity;

public class Player implements Entity{
	private int id;
	private String firstName;
	private String lastName;
	private String nationalIdentity;
	private Calendar birthDate;
	private String nickName;
	private List<Game> games;
	
	public Player(int id, String firstName, String lastName, String nationalIdentity, Calendar birthDate,
			String nickName, List<Game> games) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
		this.birthDate = birthDate;
		this.nickName = nickName;
		this.games = games;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNationalIdentity() {
		return nationalIdentity;
	}

	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Calendar birthDate) {
		this.birthDate = birthDate;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}	
}
