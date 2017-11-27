package cn.eovie.ncufcbackend.manager;

import cn.eovie.ncufcbackend.dao.NotificationDao;
import cn.eovie.ncufcbackend.model.domain.NotificationDO;
import cn.eovie.ncufcbackend.model.dto.NotificationDTO;
import cn.eovie.ncufcbackend.util.BaseConveter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by earayu on 2017/11/27.
 */
@Service
public class NotificationManager {

    @Autowired
    private NotificationDao notificationDao;

    public void addNotification(NotificationDTO notificationDTO){
        notificationDao.insert(BaseConveter.convertObject(notificationDTO, NotificationDO.class));
    }

    public NotificationDTO findLatest(){
        return notificationDao.findAll()
                .stream()
                .max((o1, o2) -> {
                    if(o1==o2 || o1.getStartTime().equals(o2.getStartTime())){
                        return 0;
                    }else if(o1.getStartTime().before(o2.getStartTime())){
                        return -1;
                    }else {
                        return 1;
                    }
                })
                .map(e->BaseConveter.convertObject(e, NotificationDTO.class))
                .get();
    }

}
