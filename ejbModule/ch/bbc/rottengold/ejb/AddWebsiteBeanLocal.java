package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Website;

@Local
public interface AddWebsiteBeanLocal {

	abstract void addWebsite(Website website);

	abstract boolean getTitleByName(Website website);

}
