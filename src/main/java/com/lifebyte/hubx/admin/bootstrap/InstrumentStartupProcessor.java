package com.lifebyte.hubx.admin.bootstrap;

import com.lifebyte.hubx.admin.cache.InstrumentCacheMgmtService;
import com.lifebyte.hubx.admin.mapper.GlobalAppMapper;
import com.lifebyte.hubx.admin.mapper.InstrumentMapper;
import com.lifebyte.hubx.cache.bootstrap.InitializingCache;
import com.lifebyte.hubx.data.entity.account.GlobalAppVO;
import com.lifebyte.hubx.data.entity.account.TradingCurrencyVO;
import com.lifebyte.hubx.data.entity.account.TradingLeverageVO;
import com.lifebyte.hubx.data.entity.symbol.SymbolDisplayNameVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Component
@ConditionalOnProperty(name = "cache.refresh-on-startup", havingValue = "true")
@Log4j2
public class InstrumentStartupProcessor implements InitializingCache {

    @Autowired
    private InstrumentMapper instrumentMapper;
    @Autowired
    private GlobalAppMapper globalAppMapper;
    @Autowired
    private InstrumentCacheMgmtService instrumentCacheMgmtService;

    @Override
    public void initializeCache() {


        List<TradingCurrencyVO> currencies = instrumentMapper.queryAllCurrencies();
        List<TradingLeverageVO> leverages = instrumentMapper.queryAllLeverages();

        instrumentCacheMgmtService.clear();

        instrumentCacheMgmtService.saveCurrencies(currencies.stream().collect(Collectors.toMap(
                TradingCurrencyVO::getId,
                TradingCurrencyVO::getCurrency
        )));

        instrumentCacheMgmtService.saveLeverages(leverages.stream().collect(Collectors.toMap(
                TradingLeverageVO::getId,
                TradingLeverageVO::getLeverage
        )));

        List<GlobalAppVO> apps = globalAppMapper.queryAllGlobalApps();
        for (GlobalAppVO app : apps) {
            instrumentCacheMgmtService.saveGlobalApp(app.getId(), app);
        }

    }
}
