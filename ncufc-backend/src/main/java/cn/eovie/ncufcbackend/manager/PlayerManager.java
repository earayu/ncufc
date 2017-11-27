package cn.eovie.ncufcbackend.manager;

import cn.eovie.ncufcbackend.dao.PlayerDao;
import cn.eovie.ncufcbackend.model.domain.PlayerDO;
import cn.eovie.ncufcbackend.model.dto.PlayerDTO;
import cn.eovie.ncufcbackend.util.BaseConveter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by earayu on 2017/11/27.
 */
@Service
public class PlayerManager {

    @Autowired
    private PlayerDao playerDao;

    public void addPlayer(PlayerDTO playerDTO){
        playerDao.insert(BaseConveter.convertObject(playerDTO, PlayerDO.class));
    }

    /**
     * 返回所有球员
     * @return
     */
    public List<PlayerDTO> findAll(){
        return BaseConveter.convertList(playerDao.findAll(), PlayerDTO.class);
    }

}
