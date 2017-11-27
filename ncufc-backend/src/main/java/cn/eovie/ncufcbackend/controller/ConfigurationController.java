package cn.eovie.ncufcbackend.controller;

import cn.eovie.ncufcbackend.manager.NotificationManager;
import cn.eovie.ncufcbackend.manager.PlayerManager;
import cn.eovie.ncufcbackend.manager.PosterManager;
import cn.eovie.ncufcbackend.model.dto.NotificationDTO;
import cn.eovie.ncufcbackend.model.dto.PlayerDTO;
import cn.eovie.ncufcbackend.model.dto.PosterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static cn.eovie.ncufcbackend.constant.HTTPHeader.APPLICATION_JSON;

/**
 * 管理后台，配置接口
 * Created by earayu on 2017/11/27.
 */
@RestController(value = "/api/v1/manage")
public class ConfigurationController {

    @Autowired
    private PosterManager posterManager;

    @Autowired
    private PlayerManager playerManager;

    @Autowired
    private NotificationManager notificationManager;

    @PostMapping(value = "/poster", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public void addPoster(@RequestBody PosterDTO posterDTO){
        posterManager.addPost(posterDTO);
    }

    @GetMapping(value = "/poster", produces = APPLICATION_JSON)
    public List<PosterDTO> findAllPoster(){
        return posterManager.findAll();
    }

    @PostMapping(value = "/player", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public void addPlayer(@RequestBody PlayerDTO playerDTO){
        playerManager.addPlayer(playerDTO);
    }

    @GetMapping(value = "/player", produces = APPLICATION_JSON)
    public List<PlayerDTO> findAllPlayer(){
        return playerManager.findAll();
    }

    @PostMapping(value = "/notification", consumes = APPLICATION_JSON, produces = APPLICATION_JSON)
    public void addNotification(@RequestBody NotificationDTO notificationDTO){
        notificationManager.addNotification(notificationDTO);
    }

    @GetMapping(value = "/notification", produces = APPLICATION_JSON)
    public NotificationDTO findLatest(){
        return notificationManager.findLatest();
    }


}
