package SpringMVCDemo7.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import SpringMVCDemo7.pojos.Comment;
import SpringMVCDemo7.service.CommentService;

@RestController
public class ApiCommentController {
	@Autowired
	private CommentService commentService;
	@PostMapping("/api/add-comment")
	public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params){
		String content = params.get("content");
		int productId = Integer.parseInt(params.get("productId"));
		try {
			Comment c = commentService.addComment(content, productId);
			return new ResponseEntity<>(c,HttpStatus.OK);
			
		}catch(Exception ex){
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
