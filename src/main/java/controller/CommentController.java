package controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import pojo.entity.Comment;
import service.CommentService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/comment")
@Slf4j
@Api
public class CommentController {

    @Resource
    private CommentService commentService;

    @ApiOperation(value = "对电影进行评论")
    @PostMapping("/insert")
    public Boolean insertCommentToMovie(
            @ApiParam(value="Comment对象")Comment comment)  {

        return commentService.insertComment(comment);
    }








	
}
