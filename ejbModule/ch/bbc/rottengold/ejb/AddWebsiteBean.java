package ch.bbc.rottengold.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rottengold.model.Website;

/**
 * Session Bean implementation class AddWebsiteBean
 */
@Stateless
public class AddWebsiteBean implements AddWebsiteBeanLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	EntityManager em;
	
    public AddWebsiteBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addWebsite(Website website) {
		em.persist(website);	
	}
	
	@Override
	public boolean getTitleByName(Website website) {
		if (em.createNamedQuery("Website.findByWebsiteName").setParameter("webName", website.getName()).getResultList().size() > 0){
			return true;
		}
		return false;
	}

}
