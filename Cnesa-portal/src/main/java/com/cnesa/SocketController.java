package com.cnesa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by shangpeibao on 16/12/23.
 */
@Controller
public class SocketController {

    @RequestMapping(value = "/web/socket")
    public String testSocket() {
        return "socket";
    }
}
