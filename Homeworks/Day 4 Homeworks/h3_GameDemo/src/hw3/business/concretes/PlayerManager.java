package hw3.business.concretes;

import java.util.List;

import hw3.business.abstracts.PlayerService;
import hw3.core.PersonCheckService;
import hw3.model.concretes.Game;
import hw3.model.concretes.Player;
import hw3.service.abstracts.OrderDao;
import hw3.service.abstracts.PlayerDao;

public class PlayerManager implements PlayerService {
	
	private PlayerDao playerDao;
	private OrderDao orderDao;
	private PersonCheckService personCheckService;
	
	public PlayerManager(PlayerDao playerDao, OrderDao orderDao, PersonCheckService personCheckService) {
		this.playerDao = playerDao;
		this.orderDao = orderDao;
		this.personCheckService = personCheckService;
	}

	@Override
	public void add(Player player) {
		if(personInformationCheck(player)) 
			playerDao.add(player);
	}

	@Override
	public void delete(int playerId) {
		if(playerId <= 0) {
			System.out.println("Unsuccessful. ID cannot be less than 1.");
			return;
		}
		playerDao.delete(playerId);
		orderDao.deleteOrderByPlayerId(playerId);
	}

	@Override
	public void update(Player player) {
		if(personInformationCheck(player)) 
			playerDao.update(player);
	}

	@Override
	public Player getPlayerById(int id) {
		if(id <= 0) {
			System.out.println("Unsuccessfull. ID cannot be less than 1.");
			return null;
		}
		return playerDao.getPlayerById(id);
	}

	@Override
	public Player getPlayerByNickName(String nickName) {
		if(nickName.length() < 3 && nickName.length() > 24) {
			System.out.println("Unsuccessfull. First name must be between 3-24 characters.");
			return null;
		}
		return playerDao.getPlayerByNickName(nickName);
	}

	@Override
	public List<Player> getPlayers() {
		return playerDao.getPlayers();
	}
	
	public boolean personInformationCheck(Player player) {
		if(player.getId() <= 0) {
			System.out.println("Unsuccessfull. ID cannot be less than 1.");
			return false;
		}
		if(player.getFirstName().length() < 3 && player.getFirstName().length() > 24) {
			System.out.println("Unsuccessfull. First name must be between 3-24 characters.");
			return false;
		}
		if(player.getLastName().length() < 3 && player.getLastName().length() > 24) {
			System.out.println("Unsuccessfull. First name must be between 3-24 characters.");
			return false;
		}
		if(player.getNickName().length() < 3 && player.getNickName().length() > 24) {
			System.out.println("Unsuccessfull. First name must be between 3-24 characters.");
			return false;
		}
		if(!personCheckService.checkIfRealPerson(player.getNationalIdentity(), 
				player.getFirstName(), 
				player.getLastName(), 
				player.getBirthDate())) {
			System.out.println("Unsuccessfull. This informations dosen't match with a real person.");
			return false;
		}
		return true;
	}

	@Override
	public void addGame(Player player, Game game) {
		playerDao.addGame(player, game);
	}
}
