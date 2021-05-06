package hw3.service.abstracts;

import java.util.List;

import hw3.model.concretes.Game;
import hw3.model.concretes.Player;

public interface PlayerDao {
	void add(Player player);
	void delete(int playerId);
	void update(Player player);
	Player getPlayerById(int id);
	Player getPlayerByNickName(String nickName);
	List<Player> getPlayers();
	void addGame(Player player, Game game);
}
