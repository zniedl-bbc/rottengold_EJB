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

//	public String login(User user) {
//
//		if (em.createNamedQuery("Customer.login").setParameter("custMail", user.getEmail())
//				.setParameter("custPW", user.getPassword()).getResultList().size() > 0) {
//			LOGGER.info("Customer " + user.getEmail() + " successfully logged in.");
//			return "/home";
//		} else {
//			return "";
//		}
//
//	}
//
//	public List<User> getAllUser() {
//			
//		return (List<User>) em.createNamedQuery("Customer.findAll").getResultList();
//	}
//	public void deleteUserById(int Id){
//		LOGGER.info("Methode wird aufgerufen");
//	}

	@Override
	public String registerUser(User user) {
		em.persist(user);
		return "/home";
	}
}
