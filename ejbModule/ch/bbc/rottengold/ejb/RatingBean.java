package ch.bbc.rottengold.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rottengold.model.Rating;

/**
 * Session Bean implementation class RatingBean
 */
@Stateless
public class RatingBean implements RatingBeanLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public RatingBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Rating getRatingForWebsiteWithUser(int websiteId, int userId) {
		Rating rating = null;
		try {
			@SuppressWarnings("unchecked")
			List<Rating> results = em.createNamedQuery("Rating.findRatingByWebsiteIdAndUserId")
					.setParameter("id_website", websiteId).setParameter("id_user", userId).getResultList();
			rating = results.get(0);
		} catch (Exception e) {

		}

		return rating;
	}

	@Override
	public Rating[] getAllRatingsForWebsite(int websiteId) {
		Rating[] allRatings = null;
		try {

			@SuppressWarnings("unchecked")
			List<Rating> results = em.createNamedQuery("Rating.findRatingByWebsiteId")
					.setParameter("id_website", websiteId).getResultList();

			int counter = 0;
			allRatings = new Rating[results.size()];
			while (counter <= results.size()) {
				allRatings[counter] = results.get(counter);
				counter++;
			}

		} catch (Exception e) {

		}

		return allRatings;
	}

	@Override
	public void setNewRatingForThisUser(int rating, int user_id, int website_id) {
		Rating newRating = new Rating(rating, website_id, user_id);
		em.persist(newRating);
	}

	@Override
	public void updateRating(int rating, int user_id, int website_id) {
		em.createNamedQuery("Rating.updateRating").setParameter("rating", rating)
				.setParameter("id_website", website_id).setParameter("id_user", user_id).executeUpdate();

	}

	@Override
	public void deleteRating(int id) {
		em.createNamedQuery("Rating.deleteRatings").setParameter("userID", id).executeUpdate();
		
	}

}
