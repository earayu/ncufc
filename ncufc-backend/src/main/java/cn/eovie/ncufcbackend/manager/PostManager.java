package cn.eovie.ncufcbackend.manager;

import cn.eovie.ncufcbackend.dao.PostDao;
import cn.eovie.ncufcbackend.model.PostDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by earayu on 2017/11/27.
 */
@Service
public class PostManager {

    @Autowired
    private PostDao postDao;

    public void addPost(PostDO postDO){
        postDao.insert(postDO);
    }

}
