package cn.eovie.ncufcbackend.dao;

import cn.eovie.ncufcbackend.model.domain.NotificationDO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by earayu on 2017/11/27.
 */
public interface NotificationDao extends MongoRepository<NotificationDO, Integer> {

}
