package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Website;

@Local
public interface WebsiteInfoBeanLocal {

	public Website getWebsiteInfo(String string);

	public int findBiggestWebsiteId(int id_website);
}
