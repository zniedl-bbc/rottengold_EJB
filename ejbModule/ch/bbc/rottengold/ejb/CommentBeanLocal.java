package ch.bbc.rottengold.ejb;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;

import ch.bbc.rottengold.model.Comment;

@Local
public interface CommentBeanLocal {
	public List<Comment> getCommentsViaWebsite(int id_website);
}
