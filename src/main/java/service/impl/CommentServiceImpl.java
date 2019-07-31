package service.impl;

import dao.CommentMapper;
import org.springframework.stereotype.Service;
import pojo.entity.Comment;
import service.CommentService;

import javax.annotation.Resource;

@Service
public class CommentServiceImpl implements CommentService {


    @Resource
    private CommentMapper commentMapper;

    @Override
    public Boolean insertComment(Comment comment) {

        return commentMapper.insert(comment)>0;
    }
}
