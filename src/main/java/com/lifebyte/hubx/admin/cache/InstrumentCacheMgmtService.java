package com.lifebyte.hubx.admin.cache;

import com.lifebyte.hubx.cache.service.mgmt.CacheManagementService;
import com.lifebyte.hubx.cache.service.GlobalCacheService;
import com.lifebyte.hubx.data.entity.account.GlobalAppVO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class InstrumentCacheMgmtService extends GlobalCacheService implements CacheManagementService {


    public void saveCurrencies(Map<Long, String> currencies) {
        CURRENCY_CONTAINER.save(currencies);
    }

    public void saveLeverages(Map<Long, Integer> leverages) {
        LEVERAGE_CONTAINER.save(leverages);
    }

    public void saveGlobalApp(Long id, GlobalAppVO app) {
        GLOBAL_APP_CONTAINER.save(app, id);
    }
}


