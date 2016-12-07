package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Website;

@Local
public interface WebsiteInfoBeanLocal {
	
	/**
	 * This method gets all information about the invoked website
	 * 
	 * @param string	Is the ID for the invoked website. If its 0 it will automatically be set to 1.
	 * 					With the value 1 i will redirect to our own site.
	 * 
	 * @return	Return a complete website object with all needed information
	 */
	public Website getWebsiteInfo(String websiteId);
	
	/**
	 * This function will return the highest id in the table
	 * 
	 * @return	Returns the highest id in the website table
	 */
	public int findBiggestWebsiteId();
}
