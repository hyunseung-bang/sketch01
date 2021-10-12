package com.sketch01.api.opm;

import com.sketch01.api.opm.data.MenuDto;
import com.sketch01.api.opm.data.VueRouterDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OpmController {

    @ResponseBody
    @RequestMapping("/api/opm/vue-router")
    public List<VueRouterDao> vueRoute() {
        List<VueRouterDao> list = new ArrayList<>();
        list.add(new VueRouterDao("/router/router01", "router01", "/sample/router/router01"));
        list.add(new VueRouterDao("/router/router02", "router02", "/sample/router/router02"));
        list.add(new VueRouterDao("/router/router03", "router03", "/sample/router/router03"));
        return list;
    }

    @ResponseBody
    @RequestMapping("/api/opm/vue-menu")
    public List<MenuDto> vueMenu() {
        List<MenuDto> depth3 = new ArrayList<>();
        depth3.add(new MenuDto("5", "ROUTER01","router01", "/sample/router/router01", null));
        depth3.add(new MenuDto("4", "ROUTER02","router02", "/sample/router/router02", null));
        depth3.add(new MenuDto("3", "ROUTER03","router03", "/sample/router/router03", null));

        List<MenuDto> depth2 = new ArrayList<>();
        depth2.add(new MenuDto("2", "ROUTER",null, null, depth3));

        List<MenuDto> depth1 = new ArrayList<>();
        depth1.add(new MenuDto("1", "SAMPLE",null, null, depth2));

        return depth1;
    }
}
