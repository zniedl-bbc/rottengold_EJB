package ch.bbc.rottengold.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rottengold.model.Website;

/**
 * Session Bean implementation class SearchBean
 */
@Stateless
public class SearchBean implements SearchBeanLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext
	EntityManager em;

	Website[] searchResults;

	public SearchBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Website[] searchWebsite(String searchInput) {
		@SuppressWarnings("unchecked")
		List<Website> results = em.createNamedQuery("Website.findByWebsiteName").setParameter("webName", searchInput)
				.getResultList();
		searchResults = new Website[results.size()];
		searchResults = (Website[]) results.toArray(); 
		
		return searchResults;
	}

}
