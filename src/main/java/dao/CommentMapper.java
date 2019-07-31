package dao;

import java.util.List;
import pojo.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer comId);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer comId);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
    
    List<Comment> selectCommentByMovId(@Param("mov_id")Integer mov_id);
}