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
	public abstract void registerUser(User user);

	public abstract List<User> checkLogin(User user);

	public abstract void deleteAccount(User user);

	public abstract void changePassword(User user);

	public abstract User getUserById(int userId);
	
	public abstract int checkIfUserAlreadyExists(User user);

}
