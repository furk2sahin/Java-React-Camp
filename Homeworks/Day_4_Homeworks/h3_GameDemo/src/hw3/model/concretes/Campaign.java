package hw3.model.concretes;

import java.math.BigDecimal;
import java.util.Calendar;

public class Campaign {
	private int id;
	private String code;
	private BigDecimal discount;
	private Calendar expiryDate;
	private Game game;
	
	public Campaign(int id, String code, BigDecimal discount, Calendar expiryDate, Game game) {
		this.id = id;
		this.code = code;
		this.discount = discount;
		this.expiryDate = expiryDate;
		this.game = game;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public Calendar getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Calendar expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
}
