package ch.bbc.rottengold.ejb;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rottengold.model.User;

/**
 * Session Bean implementation class RegisterBean
 */
@Stateless
public class UserBean implements UserBeanLocal {

	private final static Logger LOGGER = Logger.getLogger(UserBean.class.getName());

	@PersistenceContext
	EntityManager em;

	public UserBean() {
		// TODO Auto-generated constructor stub
	}

	public List<User> checkLogin(User user) {

		if (em.createNamedQuery("User.checkLogin").setParameter("userUsername", user.getUsername())
				.setParameter("userPassword", user.getPassword()).getResultList().size() > 0) {

			return (List<User>) em.createNamedQuery("User.getUserByUserName")
					.setParameter("userUsername", user.getUsername()).getResultList();
		} else {

		}
		return null;
	}

	@Override
	public void registerUser(User user) {
		em.persist(user);
	}

	@Override
	public int checkIfUserAlreadyExists(User user) {
		if (em.createNamedQuery("User.getUserByUserName").setParameter("userUsername", user.getUsername())
				.getResultList().size() == 0) {
			return 0;
		} else {

			return 1;
		}
	}

	@Override
	public void deleteAccount(User user) {
		em.createNamedQuery("User.deleteAccount").setParameter("userUsername", user.getUsername()).executeUpdate();
	}

	@Override
	public void changePassword(User user) {
		em.createNamedQuery("User.changePassword").setParameter("newPassword", user.getPassword())
				.setParameter("userId", user.getId()).executeUpdate();
	}

	@Override
	public User getUserById(int userId) {
		List<User> results = em.createNamedQuery("User.getUserById").setParameter("userId", userId).getResultList();
		User userResult = results.get(0);
		return userResult;
	}

}
