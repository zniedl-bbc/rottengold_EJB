package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Rating;

@Local
public interface RatingBeanLocal {
	
	/**
	 * This method will get all ratings from the database where the website_id from the rating table is 
	 * equals the given website_id
	 * 
	 * @param websiteId	This is the ID from the invoked website
	 * 
	 * @return Returns a array of all Ratings for this website
	 */
	Rating[] getAllRatingsForWebsite(int websiteId);
	
	/**
	 * This function will return the rating that the logged in user have given to the website. 
	 * If the user haven't given a rating, the rating will be shown as 0 but will not count in the rating
	 * 
	 * @param websiteId	Is the parameter for the rating on this specific website
	 *
	 * @param userId	Is the ID of the user and is used to get the specific rating for the specific 
	 * 					website depending on the user_id
	 * @return
	 */
	Rating getRatingForWebsiteWithUser(int websiteId, int userId);

	/**
	 * This function set a new rating of the logged in user for the invoked website
	 * 
	 * @param rating	Is the rating itself, that is given by the user
	 * 
	 * @param user_id	Is the user_id of the logged in user. It is Used to identify the user if he wants to edit his rating
	 * 					@see updateRating
	 * 
	 * @param website_id	This ID is used to set the rating on the specific website
	 */
	void setNewRatingForThisUser(int rating, int user_id, int website_id);

	/**
	 * This method update the current rating of the user for this specific website.
	 * 
	 * @param rating	Is the rating itself, that is given by the user
	 * 
	 * @param user_id	Is the user_id of the logged in user. It is Used to identify the user if he wants to edit his rating
	 * 					@see updateRating
	 * 
	 * @param website_id	This ID is used to set the rating on the specific website
	 */
	void updateRating(int rating, int user_id, int website_id);
	
	/**
	 * This function deletes all ratings from a the deleted user.
	 * 
	 * @param id	UserId to delete all comments
	 */
	void deleteRating(int id);

}
