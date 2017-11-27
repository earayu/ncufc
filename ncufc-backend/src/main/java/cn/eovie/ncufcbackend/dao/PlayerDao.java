package cn.eovie.ncufcbackend.dao;

import cn.eovie.ncufcbackend.model.domain.PlayerDO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by earayu on 2017/11/27.
 */
public interface PlayerDao extends MongoRepository<PlayerDO, Integer> {

}
