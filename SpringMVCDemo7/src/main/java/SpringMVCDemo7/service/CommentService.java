package SpringMVCDemo7.service;

import SpringMVCDemo7.pojos.Comment;

public interface CommentService {
	Comment addComment(String content, int productId);
}
