package com.lifebyte.hubx.admin.mapper;

import com.lifebyte.hubx.data.entity.account.HubxCurrencyVO;
import com.lifebyte.hubx.data.entity.account.HubxLeverageVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface InstrumentMapper {

    List<HubxCurrencyVO> queryAllCurrencies();

    List<HubxLeverageVO> queryAllLeverages();

}
