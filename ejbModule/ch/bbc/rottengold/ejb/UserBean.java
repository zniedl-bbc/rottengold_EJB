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

		if (em.createNamedQuery("User.checkLogin")
				.setParameter("userUsername", user.getUsername())
				.setParameter("userPassword", user.getPassword())
				.getResultList().size() > 0) {

			return (List<User>) em.createNamedQuery("User.getUserByUserName").setParameter("userUsername", user.getUsername()).getResultList();
		} else {
			
		}
		return null;
	}


	@Override
	public String registerUser(User user) {
		em.persist(user);
		return "/mainFrame";
	}

	@Override
	public void deleteAccount(User user) {
		System.out.println(user.getUsername());
		em.createNamedQuery("User.deleteAccount")
			.setParameter("userUsername", user.getUsername()).executeUpdate();
	}
}
