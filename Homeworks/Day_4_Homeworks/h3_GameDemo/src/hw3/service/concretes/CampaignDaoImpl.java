package hw3.service.concretes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hw3.model.concretes.Campaign;
import hw3.model.concretes.Game;
import hw3.service.abstracts.CampaignDao;

public class CampaignDaoImpl implements CampaignDao {

	private static List<Campaign> campaigns = new ArrayList<Campaign>();
	
	@Override
	public void add(Campaign campaign) {
		campaigns.add(campaign);
	}

	@Override
	public void delete(int id) {
		for(Iterator<Campaign> iterator = campaigns.listIterator(); iterator.hasNext();) {
			if(iterator.next().getId() == id) {
				iterator.remove();
				System.out.println("Campaign successfully deleted with id: " + id);
			}
		}
	}

	@Override
	public void update(Campaign campaign) {
		int indexOfCampaign = campaigns.indexOf(campaign);
		Campaign campaignToUpdate = campaigns.get(indexOfCampaign);
		
		if(!campaignToUpdate.getCode().equals(campaign.getCode())) {
			campaignToUpdate.setCode(campaign.getCode());
			System.out.println("Campaign code successfully changed.");
		}
		
		if(!campaignToUpdate.getDiscount().equals(campaign.getDiscount())) {
			campaignToUpdate.setDiscount(campaign.getDiscount());
			System.out.println("Campaign discount successfully changed.");
		}
		
		if(!campaignToUpdate.getExpiryDate().equals(campaign.getExpiryDate())) {
			campaignToUpdate.setExpiryDate(campaign.getExpiryDate());
			System.out.println("Campaign expiry date successfully changed.");
		}
	}

	@Override
	public Campaign getCampaignById(int id) {
		for(Iterator<Campaign> iterator = campaigns.listIterator(); iterator.hasNext();) {
			Campaign campaign= iterator.next();
			if(campaign.getId() == id) {
				return campaign;
			}
		}
		System.out.println("Cannot find campaign by id: " + id);
		return null;
	}

	@Override
	public List<Campaign> getCampaignsByGame(Game game) {
		List<Campaign> gameCampaigns = new ArrayList<Campaign>();
		for(Iterator<Campaign> iterator = campaigns.listIterator(); iterator.hasNext(); ) {
			Campaign campaignObject = iterator.next();
			if(campaignObject.getGame().equals(game)) {
				gameCampaigns.add(campaignObject);
			}
		}
		return gameCampaigns;
	}

	@Override
	public List<Campaign> getCampaigns() {
		return campaigns;
	}

	@Override
	public void deleteCampaignByGameId(int gameId) {
		for(Iterator<Campaign> iterator = campaigns.listIterator(); iterator.hasNext();) {
			if(iterator.next().getGame().getId() == gameId) {
				iterator.remove();
				System.out.println("Campaign successfully deleted with game id: " + gameId);
			}
		}
	}

}
