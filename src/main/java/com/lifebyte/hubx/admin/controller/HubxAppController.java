package com.lifebyte.hubx.admin.controller;

import com.lifebyte.hubx.admin.service.HubxAppService;
import com.lifebyte.hubx.data.entity.account.GlobalAppVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Paul/Jack
 * @date 2020/12/25 18:04
 */
@RestController
public class HubxAppController {

    @Autowired
    private HubxAppService hubxAppService;

    @GetMapping(value = "global/apps")
    public List<GlobalAppVO> queryAllHubxApps() {
        return hubxAppService.queryAllHubxApps();
    }
}
