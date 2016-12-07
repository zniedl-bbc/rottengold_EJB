package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Website;

@Local
public interface AddWebsiteBeanLocal {
	
	/**
	 * This method creates a new entity in the database. This entity will be in the
	 * table "website".
	 * 
	 * @param website	This object contains all information about the new entity: 
	 * 					url, websitename and the description
	 */

	abstract void addWebsite(Website website);

	/**
	 * This method selects all entities from the table website with the name from the website object.
	 * 
	 * @param website	This object contains all information about the new entity: 
	 * 					url, websitename and the description. 
	 * 					In this method will only the website name be used.
	 * 
	 * @return	If the resultlist is equals 0 it will return true as a sign that this website dosen't exist in the table.
	 * 			Is this not the case, it will return false.
	 */
	abstract boolean getTitleByName(Website website);

}
