package hw3.service.abstracts;

import java.util.List;

import hw3.model.concretes.Game;

public interface GameDao {
	void add(Game game);
	void delete(int id);
	void update(Game game);
	Game getGameById(int id);
	List<Game> getGamesByCategoryId(int categoryId);
	List<Game> getGames();
	void deleteGamesByCategoryId(int categoryId);
}
