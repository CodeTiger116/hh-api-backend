package com.hh.hhapibackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.hhapibackend.model.entity.InterfaceInfo;


/**
* @author hanhu
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-06-28 21:04:19
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo post, boolean b);
}
