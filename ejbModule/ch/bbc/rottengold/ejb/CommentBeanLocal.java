package ch.bbc.rottengold.ejb;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Comment;
import ch.bbc.rottengold.model.User;

@Local
public interface CommentBeanLocal {
	
	/**
	 * This method will get all comments from the database where the website_id from the comment is 
	 * equals the given website_id
	 * 
	 * @param id_website	This is the ID from the invoked website
	 * 
	 * @param biggestWebsiteId	This is the highest ID from all websites. It is used to check if the website
	 * 							ID is higher then the highest in the database
	 * 
	 * @return	The return value is a Array that contains all comments for the invoked website
	 */
	public Comment[] getCommentsViaWebsite(int id_website, int biggestWebsiteId);

	/**
	 * This method adds a new Comment to the database.
	 * 
	 * @param newComment	The comment object contains all information for this comment:
	 * 						comment_id, title, comment, id_website and id_user
	 */
	public void addComment(Comment newComment);
	
	/**
	 * This method delete the comments with the given id.
	 * 
	 * @param commentDeleteID	ID of the comment that will be deleted
	 */
	public void deleteComment(int commentDeleteID);
	
	/**
	 * This method will update the invoked comment, with the new values from the given comment object
	 * 
	 * @param toBeEditedComment	The new comment object, with the new values
	 */
	public void editComment(Comment toBeEditedComment);
	
	/**
	 * This method deletes all comments from a specific user
	 * 
	 * @param uID	The user_id for the delete command
	 */
	public void deleteCommentsByUserID(int uID);
}
