package hw3.model.concretes;

import java.math.BigDecimal;

import hw3.model.abstracts.Product;

public class Game implements Product{
	private String description;
	private Category category;
	private int id;
	private String name;
	private BigDecimal price;
	
	public Game(int id, String name, BigDecimal price, String description, Category category) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}	
}