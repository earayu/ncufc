package cn.eovie.ncufcbackend.controller;

import cn.eovie.ncufcbackend.exception.*;
import cn.eovie.ncufcbackend.manager.CosManager;
import cn.eovie.ncufcbackend.manager.NotificationManager;
import cn.eovie.ncufcbackend.manager.PlayerManager;
import cn.eovie.ncufcbackend.manager.PosterManager;
import cn.eovie.ncufcbackend.model.domain.Result;
import cn.eovie.ncufcbackend.model.dto.NotificationDTO;
import cn.eovie.ncufcbackend.model.dto.PlayerDTO;
import cn.eovie.ncufcbackend.model.dto.PosterDTO;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static cn.eovie.ncufcbackend.constant.HTTPHeader.APPLICATION_JSON;

/**
 * 管理后台，配置接口
 * Created by earayu on 2017/11/27.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/manage")
public class ConfigurationController {

    @Autowired
    private PosterManager posterManager;

    @Autowired
    private PlayerManager playerManager;

    @Autowired
    private NotificationManager notificationManager;

    @PostMapping(value = "/poster", produces = APPLICATION_JSON)
    public Result addPoster(@RequestParam(value = "name") String name,
                            @RequestParam(value = "postUser") String postUser,
                            @RequestParam(value = "poster") MultipartFile file){
        return posterManager.addPost(name, postUser, file);
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

    //TODO 删掉
    @GetMapping(value = "/health")
    public String health(){
        throw new LogicalException(ExceptionCode.UPLOAD_ERROR);
    }


}
