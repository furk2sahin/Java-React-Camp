package hw3.business.concretes;

import java.util.Collections;
import java.util.List;

import hw3.business.abstracts.GameService;
import hw3.model.concretes.Game;
import hw3.service.abstracts.CampaignDao;
import hw3.service.abstracts.GameDao;

public class GameManager implements GameService {
	
	private GameDao gameDao;
	private CampaignDao campaignDao;
	
	public GameManager(GameDao gameDao, CampaignDao campaignDao) {
		this.gameDao = gameDao;
		this.campaignDao = campaignDao;
	}

	@Override
	public void add(Game game) {
		if(game.getId() <= 0) {
			System.out.println("Unsuccessfull! ID must be bigger than 0.");
			return;
		}
		if(game.getName().length() < 3 && game.getName().length() > 24) {
			System.out.println("Unsuccessful! Game name length must be between 3-24.");
			return;
		}
		if(game.getPrice().intValue() < 0) {
			System.out.println("Unsuccessfull! Game price cannot be less than zero.");
			return;
		}
		
		gameDao.add(game);
	}

	@Override
	public void delete(int id) {
		if(id <= 0) {
			System.out.println("ID cannot be less than 0.");
			return;
		}
		gameDao.delete(id);
		campaignDao.deleteCampaignByGameId(id);
	}

	@Override
	public void update(Game game) {
		if(game.getId() <= 0) {
			System.out.println("Unsuccessfull! ID must be bigger than 0.");
			return;
		}
		if(game.getName().length() < 3 && game.getName().length() > 24) {
			System.out.println("Unsuccessful! Game name length must be between 3-24.");
			return;
		}
		if(game.getPrice().intValue() < 0) {
			System.out.println("Unsuccessfull! Game price cannot be less than zero.");
			return;
		}
		
		gameDao.update(game);
	}

	@Override
	public Game getGameById(int id) {
		if(id <= 0) {
			System.out.println("ID cannot be less than 0.");
			return null;
		}
		return gameDao.getGameById(id);
	}

	@Override
	public List<Game> getGamesByCategoryId(int categoryId) {
		if(categoryId <= 0) {
			System.out.println("ID cannot be less than 0.");
			return Collections.emptyList();
		}
		return gameDao.getGamesByCategoryId(categoryId);
	}

	@Override
	public List<Game> getGames() {
		return gameDao.getGames();
	}

}
