package cn.eovie.ncufcbackend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by earayu on 2017/12/21.
 */
@Controller
public class TEST {

    @RequestMapping(value = "test")
    public String a(@RequestParam String phone, @RequestParam String sign) throws UnsupportedEncodingException {
        return String.format("redirect:a.html?phone=%s&sign=%s", phone, URLEncoder.encode("dffdsa范德萨撒范德萨发生dfsafdas-243094503==", "UTF-8"));
    }

}
