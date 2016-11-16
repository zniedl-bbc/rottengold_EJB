package ch.bbc.rottengold.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rottengold.model.Website;

/**
 * Session Bean implementation class WebsiteInfoBean
 */
@Stateless
public class WebsiteInfoBean implements WebsiteInfoBeanLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public WebsiteInfoBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Website getWebsiteInfo(int id) {
		return (Website) em.createNamedQuery("Website.findByWebsiteId").setParameter("webId", id).getResultList();
	}

}
