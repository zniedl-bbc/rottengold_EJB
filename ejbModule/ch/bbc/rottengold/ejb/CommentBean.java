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
	public Comment[] getCommentsViaWebsite(String id_website) {
		try {
			int id = new Integer(id_website);
			if (id == 0) {
				id = 1;
			}
			@SuppressWarnings("unchecked")
			List<Comment> results = em.createNamedQuery("Comment.findWithWebsite").setParameter("id_website", id)
					.getResultList();

			if (results.get(0) != null) {
				int iterator = 0;
				comments = new Comment[results.size()];
				while (iterator < results.size()) {
					comments[iterator] = results.get(iterator);
					iterator++;
				}
			} else {
				throw new Exception();
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
				.setParameter("commentNewComment", toBeEditedComment.getComment()).setParameter("id", toBeEditedComment.getId());
	}

}
