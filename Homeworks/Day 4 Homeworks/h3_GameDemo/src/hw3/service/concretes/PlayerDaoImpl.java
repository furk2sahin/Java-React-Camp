package hw3.service.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hw3.model.concretes.Game;
import hw3.model.concretes.Player;
import hw3.service.abstracts.PlayerDao;

public class PlayerDaoImpl implements PlayerDao {
	
	private static List<Player> players = new ArrayList<Player>();

	@Override
	public void add(Player player) {
		players.add(player);
	}

	@Override
	public void delete(int playerId) {
		for(Iterator<Player> iterator = players.listIterator(); iterator.hasNext();) {
			if(iterator.next().getId() == playerId) {
				iterator.remove();
				System.out.println("Player successfully deleted with id: " + playerId);
			}
		}
	}

	@Override
	public void update(Player player) {
		int indexOfPlayer = players.indexOf(player);
		Player playerToUpdate = players.get(indexOfPlayer);
		
		if(!playerToUpdate.getFirstName().equals(player.getFirstName())) {
			playerToUpdate.setFirstName(player.getFirstName());
			System.out.println(player.getFirstName() + "'s first name successfully changed.");
		}
		
		if(!playerToUpdate.getLastName().equals(player.getLastName())) {
			playerToUpdate.setLastName(player.getLastName());
			System.out.println(player.getFirstName() + "'s last name successfully changed.");
		}
		
		if(!playerToUpdate.getNickName().equals(player.getNickName())) {
			playerToUpdate.setNickName(player.getNickName());
			System.out.println(player.getFirstName() + "'s nickname successfully changed.");
		}
	}

	@Override
	public Player getPlayerById(int id) {
		for(Iterator<Player> iterator = players.listIterator(); iterator.hasNext();) {
			Player player = iterator.next();
			if(player.getId() == id)
				return player;
		}
		System.out.println("Cannot find player with id: " + id);
		return null;
	}

	@Override
	public Player getPlayerByNickName(String nickName) {
		for(Iterator<Player> iterator = players.listIterator(); iterator.hasNext();) {
			Player player = iterator.next();
			if(player.getNickName().equals(nickName))
				return player;
		}
		System.out.println("Cannot find player with nickname: " + nickName);
		return null;
	}

	@Override
	public List<Player> getPlayers() {
		return players;
	}

	@Override
	public void addGame(Player player, Game game) {
		player.getGames().add(game);
	}
}
