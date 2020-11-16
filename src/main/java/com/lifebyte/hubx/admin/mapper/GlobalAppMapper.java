package com.lifebyte.hubx.admin.mapper;

import com.lifebyte.hubx.data.entity.account.GlobalAppVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GlobalAppMapper {

    int insert(GlobalAppVO record);


    List<GlobalAppVO> queryAllGlobalApps();
}