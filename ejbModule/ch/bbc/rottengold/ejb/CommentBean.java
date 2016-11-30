package ch.bbc.rottengold.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ch.bbc.rottengold.model.Comment;

/**
 * Session Bean implementation class commentLister
 */
@Stateless
public class CommentBean implements CommentBeanLocal {

	@PersistenceContext
	EntityManager em;

	private Comment[] comments;

	/**
	 * Default constructor.
	 */
	public CommentBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Comment[] getCommentsViaWebsite(int id_website) {
		try {
			if (Integer.parseInt("" + em.createNamedQuery("Website.findBiggestId").setMaxResults(1).getResultList()
					.get(0)) < id_website) {
				comments = null;
			}

			if (id_website == 0) {
				id_website = 1;
			}
			@SuppressWarnings("unchecked")
			List<Comment> results = em.createNamedQuery("Comment.findWithWebsite")
					.setParameter("id_website", id_website).getResultList();

			if (results.get(0) != null) {
				int iterator = 0;
				comments = new Comment[results.size()];
				while (iterator < results.size()) {
					comments[iterator] = results.get(iterator);
					iterator++;
				}
			}
		} catch (Exception e) {

		}

		return comments;

	}

	@Override
	public void addComment(Comment newComment) {
		em.persist(newComment);

	}

	@Override
	public void deleteComment(int commentDeleteID) {
		em.createNamedQuery("Comment.deleteComment").setParameter("commentDeleteID", commentDeleteID).executeUpdate();
	}

	@Override
	public void editComment(Comment toBeEditedComment) {
		em.createNamedQuery("Comment.updateComment").setParameter("commentNewTitle", toBeEditedComment.getTitle())
				.setParameter("commentNewComment", toBeEditedComment.getComment())
				.setParameter("id", toBeEditedComment.getId());
	}

}
