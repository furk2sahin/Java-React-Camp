package hw3.service.abstracts;

import java.util.List;

import hw3.model.concretes.Campaign;
import hw3.model.concretes.Game;

public interface CampaignDao {
	void add(Campaign campaign);
	void delete(int id);
	void update(Campaign campaign);
	Campaign getCampaignById(int id);
	List<Campaign> getCampaignsByGame(Game game);
	List<Campaign> getCampaigns();
	void deleteCampaignByGameId(int gameId);
}
