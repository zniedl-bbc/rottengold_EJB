package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Comment;

@Local
public interface CommentBeanLocal {
	public Comment[] getCommentsViaWebsite(int id_website, int biggestWebsiteId);

	public void addComment(Comment newComment);

	public void deleteComment(int commentDeleteID);

	public void editComment(Comment toBeEditedComment);
}
