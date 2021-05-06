package hw3.business.concretes;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import hw3.business.abstracts.CampaignService;
import hw3.model.concretes.Campaign;
import hw3.model.concretes.Game;
import hw3.service.abstracts.CampaignDao;
import hw3.service.abstracts.GameDao;

public class CampaignManager implements CampaignService {

	private CampaignDao campaignDao;
	private GameDao gameDao;
	
	public CampaignManager(CampaignDao campaignDao, GameDao gameDao) {
		this.campaignDao = campaignDao;
		this.gameDao = gameDao;
	}
	
	@Override
	public void add(Campaign campaign) {
		
		if(!gameDao.getGames().contains(campaign.getGame())) {
			System.out.println("Unsuccessfull! This game dosen't exists.");
			return;
		}
		if(campaignInformationCheck(campaign)) 
			campaignDao.add(campaign);
	}

	@Override
	public void delete(int id) {
		if(id <= 0) {
			System.out.println("ID cannot be less than 0.");
			return;
		}
		campaignDao.delete(id);
	}

	@Override
	public void update(Campaign campaign) {
		if(campaignInformationCheck(campaign)) 
			campaignDao.update(campaign);
	}

	@Override
	public Campaign getCampaignById(int id) {
		if(id <= 0) {
			System.out.println("ID cannot be less than 0.");
			return null;
		}
		return campaignDao.getCampaignById(id);
	}

	@Override
	public List<Campaign> getCampaignsByGame(Game game) {
		return campaignDao.getCampaignsByGame(game);
	}

	@Override
	public List<Campaign> getCampaigns() {
		return campaignDao.getCampaigns();
	}

	public boolean campaignInformationCheck(Campaign campaign) {
		if(campaign.getId() <= 0) {
			System.out.println("Unsuccessfull! ID must be bigger than 0.");
			return false;
		}
		if(campaign.getDiscount().doubleValue() <= 0.0) {
			System.out.println("Unsuccessfull! Discount value must be bigger than 0.");
			return false;
		}
		Calendar calendar = 
				new GregorianCalendar(Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH) + 1, Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
		if(campaign.getExpiryDate().compareTo(calendar) < 0) {
			System.out.println("Unsuccessfull! This campaing is expired.");
			return false;
		}
		return true;
	}
}
