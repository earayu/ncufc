package cn.eovie.ncufcbackend.dao;

import cn.eovie.ncufcbackend.model.PostDO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by earayu on 2017/11/27.
 */
public interface PostDao extends MongoRepository<PostDO, Integer> {


}
