package ch.bbc.rottengold.ejb;

import javax.ejb.Stateless;

import ch.bbc.rottengold.model.Website;

/**
 * Session Bean implementation class WebsiteInfoBean
 */
@Stateless
public class WebsiteInfoBean implements WebsiteInfoBeanLocal {

    /**
     * Default constructor. 
     */
    public WebsiteInfoBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Website getWebsiteInfo(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
