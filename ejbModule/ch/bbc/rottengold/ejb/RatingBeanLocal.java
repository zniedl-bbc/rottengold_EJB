package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Rating;

@Local
public interface RatingBeanLocal {

	Rating[] getAllRatingsForWebsite(int websiteId);

	Rating getRatingForWebsiteWithUser(int websiteId, int userId);

	void setNewRatingForThisUser(int rating, int user_id, int website_id);

}
