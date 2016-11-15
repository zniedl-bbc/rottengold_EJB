package ch.bbc.rottengold.ejb;

import java.util.List;

import javax.ejb.Local;

import ch.bbc.rottengold.model.User;

@Local
public interface UserBeanLocal {
	
	/**
	 * 
	 * @param user
	 */
	public abstract String registerUser(User user);

	public abstract List<User> checkLogin(User user);

}
