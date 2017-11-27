package cn.eovie.ncufcbackend.controller;

import cn.eovie.ncufcbackend.manager.PostManager;
import cn.eovie.ncufcbackend.model.PostDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static cn.eovie.ncufcbackend.constant.HTTPHeader.APPLICATION_JSON;

/**
 * Created by earayu on 2017/11/27.
 */
@RestController
public class PostController {

    @Autowired
    private PostManager postManager;

    @PostMapping(value = "/api/v1/post", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public void post(@RequestBody PostDO postDO){//TODO DTO
        postManager.addPost(postDO);
    }

}
