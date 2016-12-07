package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Website;

@Local
public interface SearchBeanLocal {
	
	/**
	 * This function will return all websites that begins with the searchinput
	 * 
	 * @param	searchInput	User input to search a specific website.
	 * 
	 * @return	Returns a array of Websites that beginns with the searchinput
	 */
	Website[] searchWebsite(String searchInput);

}
