package ch.bbc.rottengold.ejb;

import java.util.List;

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
	public Website getWebsiteInfo(String idPar) {
		Website website;
		try {
			int id = new Integer(idPar);
			@SuppressWarnings("unchecked")
			List<Website> results = em.createNamedQuery("Website.findByWebsiteId").setParameter("webId", id)
					.getResultList();

			website = results.get(0);
		} catch (Exception e) {
			website = new Website("Default", "http://localhost:8080/RottenGold_WEB/faces/mainFrame.xhtml",
					"This is our Website");
		}

		return website;
	}

}
