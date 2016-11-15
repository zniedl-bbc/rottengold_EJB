package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Website;

@Local
public interface SearchBeanLocal {

	Website[] searchWebsite(String searchInput);

}
