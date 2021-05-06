package hw3.business.abstracts;

import java.util.List;

import hw3.model.concretes.Game;
import hw3.model.concretes.Player;

public interface PlayerService {
	void add(Player player);
	void delete(int playerId);
	void update(Player player);
	Player getPlayerById(int id);
	Player getPlayerByNickName(String nickName);
	List<Player> getPlayers();
	void addGame(Player player, Game game);
}
