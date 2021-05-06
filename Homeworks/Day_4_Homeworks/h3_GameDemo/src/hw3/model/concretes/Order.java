package hw3.model.concretes;

import java.util.Date;

public class Order {
	private int id;
	private Player player;
	private Salesman salesman;
	private Game game;
	private Campaign campaign;
	private Date orderDate;
	private String status;
	
	public Order(int id, Player player, Salesman salesman, Game game, Campaign campaign, Date orderDate, String status) {
		super();
		this.id = id;
		this.player = player;
		this.salesman = salesman;
		this.game = game;
		this.campaign = campaign;
		this.orderDate = orderDate;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Salesman getSalesman() {
		return salesman;
	}

	public void setSalesman(Salesman salesman) {
		this.salesman = salesman;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Campaign getCampaign() {
		return campaign;
	}

	public void setCampaign(Campaign campaign) {
		this.campaign = campaign;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
