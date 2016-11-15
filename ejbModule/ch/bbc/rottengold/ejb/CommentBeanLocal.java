package ch.bbc.rottengold.ejb;

import java.util.Collection;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Comment;

@Local
public interface CommentBeanLocal {
	public Collection<Comment> getCommentsViaWebsite(int id_website);
}
