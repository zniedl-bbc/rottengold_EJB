package ch.bbc.rottengold.ejb;

import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rottengold.model.Comment;

/**
 * Session Bean implementation class commentLister
 */
@Stateless
public class CommentLister implements CommentListerLocal {

	@PersistenceContext
	EntityManager em;

	private Collection<Comment> comments;

	/**
	 * Default constructor.
	 */
	public CommentLister() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<Comment> getCommentsViaWebsite(int id_website) {
		@SuppressWarnings("unchecked")
		List<Comment> results = em.createNamedQuery("Comment.findWithWebsite").setParameter("id_website", id_website)
				.getResultList();
		comments = results;
		return comments;

	}

}
