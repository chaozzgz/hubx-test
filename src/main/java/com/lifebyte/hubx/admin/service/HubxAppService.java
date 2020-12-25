package com.lifebyte.hubx.admin.service;

import com.lifebyte.hubx.admin.mapper.GlobalAppMapper;
import com.lifebyte.hubx.data.entity.account.GlobalAppVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author Paul/Jack
 * @date 2020/12/25 18:06
 */
@Service
public class HubxAppService {

    @Autowired
    private GlobalAppMapper globalAppMapper;


    public List<GlobalAppVO> queryAllHubxApps() {
        return globalAppMapper.queryAllGlobalApps();
    }
}
