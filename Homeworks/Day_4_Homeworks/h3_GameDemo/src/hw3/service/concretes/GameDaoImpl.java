package hw3.service.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hw3.model.concretes.Game;
import hw3.service.abstracts.GameDao;

public class GameDaoImpl implements GameDao {

	private static List<Game> games = new ArrayList<Game>();
	
	@Override
	public void add(Game game) {
		games.add(game);
	}

	@Override
	public void delete(int id) {
		for(Iterator<Game> iterator = games.listIterator(); iterator.hasNext();) {
			Game game = iterator.next();
			if(game.getId() == id) {
				iterator.remove();
				System.out.println(game.getName() + " successfully deleted.");
			}
		}
	}

	@Override
	public void update(Game game) {
		int indexOfGame = games.indexOf(game);
		Game gameToUpdate = games.get(indexOfGame);
		
		if(!gameToUpdate.getCategory().equals(game.getCategory())) {
			gameToUpdate.setCategory(game.getCategory());
			System.out.println(game.getName() + "'s category successfully changed.");
		}
		
		if(!gameToUpdate.getPrice().equals(game.getPrice())) {
			gameToUpdate.setPrice(game.getPrice());
			System.out.println(game.getName() + " price successfully changed.");
		}
		
		if(!gameToUpdate.getName().equals(game.getName())) {
			gameToUpdate.setName(game.getName());
			System.out.println(game.getName() + " game name successfully changed.");
		} 
		
		if(!gameToUpdate.getDescription().equals(game.getDescription())) {
			gameToUpdate.setDescription(game.getDescription());
			System.out.println(game.getName() + "'s nickname successfully changed.");
		}
	}

	@Override
	public Game getGameById(int id) {
		for(Iterator<Game> iterator = games.listIterator(); iterator.hasNext();) {
			Game game = iterator.next();
			if(game.getId() == id) {
				return game;
			}
		}
		System.out.println("Cannot find game with id: " + id);
		return null;
	}

	@Override
	public List<Game> getGamesByCategoryId(int categoryId) {
		List<Game> gamesByCategory = new ArrayList<Game>();
		for(Iterator<Game> iterator = games.listIterator(); iterator.hasNext();) {
			Game game = iterator.next();
			if(game.getCategory().getId() == categoryId) {
				gamesByCategory.add(game);
			}
		}
		return gamesByCategory;
	}

	@Override
	public List<Game> getGames() {
		return games;
	}

	@Override
	public void deleteGamesByCategoryId(int categoryId) {
		for(Iterator<Game> iterator = games.iterator(); iterator.hasNext();) {
			if(iterator.next().getCategory().getId() == categoryId) {
				iterator.remove();
			}
		}
		
	}

}
