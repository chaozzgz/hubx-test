package com.lifebyte.hubx.admin.mapper;

import com.lifebyte.hubx.data.entity.account.TradingCurrencyVO;
import com.lifebyte.hubx.data.entity.account.TradingLeverageVO;
import com.lifebyte.hubx.data.entity.symbol.SymbolDisplayNameVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InstrumentMapper {

    List<TradingCurrencyVO> queryAllCurrencies();

    List<TradingLeverageVO> queryAllLeverages();

}
