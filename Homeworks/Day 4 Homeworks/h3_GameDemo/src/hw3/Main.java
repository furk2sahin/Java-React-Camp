package hw3;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import hw3.business.abstracts.CampaignService;
import hw3.business.abstracts.CategoryService;
import hw3.business.abstracts.GameService;
import hw3.business.abstracts.OrderService;
import hw3.business.abstracts.PlayerService;
import hw3.business.abstracts.SalesmanService;
import hw3.business.concretes.CampaignManager;
import hw3.business.concretes.CategoryManager;
import hw3.business.concretes.GameManager;
import hw3.business.concretes.OrderManager;
import hw3.business.concretes.PlayerManager;
import hw3.business.concretes.SalesmanManager;
import hw3.core.KPSPublicAdapter;
import hw3.model.concretes.Campaign;
import hw3.model.concretes.Category;
import hw3.model.concretes.Game;
import hw3.model.concretes.Order;
import hw3.model.concretes.Player;
import hw3.model.concretes.Salesman;
import hw3.service.abstracts.CampaignDao;
import hw3.service.concretes.CampaignDaoImpl;
import hw3.service.concretes.CategoryDaoImpl;
import hw3.service.concretes.GameDaoImpl;
import hw3.service.concretes.OrderDaoImpl;
import hw3.service.concretes.PlayerDaoImpl;
import hw3.service.concretes.SalesmanDaoImpl;
import hw3.util.CodeGenerator;

public class Main {

	public static void main(String[] args) {
		Salesman salesman1 = new Salesman(1, "Furkan", "Þahin", "10063498584", new GregorianCalendar(2004, 9, 20));
		SalesmanService salesmanService = new SalesmanManager(new SalesmanDaoImpl(), new KPSPublicAdapter());
		salesmanService.add(salesman1);
		
		Category category = new Category(1, "MMORPG", "");
		CategoryService categoryService = new CategoryManager(new CategoryDaoImpl(), new GameDaoImpl());
		categoryService.add(category);
		
		Game game = new Game(1, "Warframe", new BigDecimal("17.00"), "Space game", category);
		GameService gameService = new GameManager(new GameDaoImpl(), new CampaignDaoImpl());
		gameService.add(game);
		
		Player player1 = new Player(1, "Furkan", "Þahin", "10063498584", new GregorianCalendar(1999, 4, 7),"furk2sahin",
				Collections.emptyList());
		PlayerService playerService = new PlayerManager(new PlayerDaoImpl(), new OrderDaoImpl(), new KPSPublicAdapter());
		playerService.add(player1);
		playerService.addGame(player1, game);
		
		Campaign campaign = new Campaign(1, CodeGenerator.generateCode(50), new BigDecimal("5.5"), new GregorianCalendar(2021, 5, 8), game);
		CampaignService campaignService = new CampaignManager(new CampaignDaoImpl(), new GameDaoImpl());
		campaignService.add(campaign);
		
		Order order = new Order(1, player1, salesman1, game, campaign, new Timestamp(System.currentTimeMillis()), "Successfull");
		OrderService orderService = new OrderManager(new OrderDaoImpl());
		orderService.add(order);
		
		for(Player player : playerService.getPlayers()) {
			System.out.println(player.getId());
			System.out.println(player.getFirstName());
			System.out.println(player.getLastName());
			System.out.println(player.getNationalIdentity());
			System.out.println(player.getNickName());
			System.out.println(player.getBirthDate().get(Calendar.YEAR) + "-" + player.getBirthDate().get(Calendar.MONTH) + "-" + player.getBirthDate().get(Calendar.DAY_OF_MONTH));
			System.out.println("////////////////////////////////////");
		}
		for(Salesman salesman : salesmanService.getSalespeople()) {
			System.out.println(salesman.getFirstName());
		}
		for(Category category2 : categoryService.getCategories()) {
			System.out.println("Category name: " + category2.getCategoryName());
		}
		for(Game game2 : gameService.getGames()) {
			System.out.println("Game name:"  + game2.getName());
		}
		
		for(Campaign campaign2 : campaignService.getCampaigns()) {
			System.out.println("Campaign game: " + campaign2.getGame().getName() + " Campaign discount: " + campaign2.getDiscount());
		}
	}

}
