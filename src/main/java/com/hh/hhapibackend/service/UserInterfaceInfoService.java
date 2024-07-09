package com.hh.hhapibackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hh.hhapibackend.model.entity.UserInterfaceInfo;


/**
* @author hanhu
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-06-30 17:06:17
*/
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {


    void validUserInterfaceInfo(UserInterfaceInfo userInterfaceInfo, boolean add);

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);
}
