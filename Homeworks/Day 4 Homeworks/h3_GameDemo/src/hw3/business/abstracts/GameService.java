package hw3.business.abstracts;

import java.util.List;

import hw3.model.concretes.Game;

public interface GameService {
	void add(Game game);
	void delete(int id);
	void update(Game game);
	Game getGameById(int id);
	List<Game> getGamesByCategoryId(int categoryId);
	List<Game> getGames();
}
