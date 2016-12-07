package ch.bbc.rottengold.ejb;

import java.util.List;

import javax.ejb.Local;

import ch.bbc.rottengold.model.User;

@Local
public interface UserBeanLocal {
	
	/**
	 * This method creates a new user entity in the user table.
	 * 
	 * @param user	The user object contains all information about the user:
	 * 				username, email and password
	 */
	public abstract void registerUser(User user);

	/**
	 * This function checks if the a user with a specific password, set through the user object,
	 * exists
	 * 
	 * @param user	Is the user object. In this method you only use the user's password ad username
	 * 
	 * @return	Whether returns a list of user's with one entry or null
	 */
	public abstract List<User> checkLogin(User user);

	/**
	 * This method deletes the user according to his username.
	 * 
	 * @param user	The method gets the username out of the user object
	 */
	public abstract void deleteAccount(User user);

	/**
	 * This function changes the password according to the username of the user object.
	 * 
	 * @param user	Is the new object with the new password, but with the same username.
	 */
	public abstract void changePassword(User user);

	/**
	 * Get all userinformation from a user with his ID.
	 * 
	 * @param userId	Is the id to select the specific user from the database
	 * 
	 * @return	returns a complete user object with all attributes.
	 */
	public abstract User getUserById(int userId);
	
	/**
	 * This function checks if the user already exists, according to his username.
	 * 
	 * @param user	The object is used to get the username out of it.
	 * 
	 * @return	Returns an integer with the value 0 or 1
	 */
	public abstract int checkIfUserAlreadyExists(User user);

	/**
	 * Increase the commentcounter by 1
	 * 
	 * @param user	The object is needed to get the current value of the commentcounter
	 */
	public abstract void increaseCommentCounter(User user);
	
	/**
	 * Decrease the commentcounter by 1
	 * 
	 * @param user	The object is needed to get the current value of the commentcounter
	 */
	public abstract void decreaseCommentCounter(User user);

}
