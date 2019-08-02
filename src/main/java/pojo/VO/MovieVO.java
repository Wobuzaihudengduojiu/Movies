package pojo.VO;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pojo.entity.Comment;
import pojo.entity.Movie;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieVO {
	
	private Movie movie;
	
	private List<Comment> comments;
	
	
}
