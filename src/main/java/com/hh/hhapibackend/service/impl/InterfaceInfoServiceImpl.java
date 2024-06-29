package com.hh.hhapibackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hh.hhapibackend.common.ErrorCode;
import com.hh.hhapibackend.exception.BusinessException;
import com.hh.hhapibackend.mapper.InterfaceInfoMapper;
import com.hh.hhapibackend.model.entity.InterfaceInfo;
import com.hh.hhapibackend.service.InterfaceInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author hanhu
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2024-06-28 21:04:19
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo> implements InterfaceInfoService {

    /**
     * 校验
     * @param interfaceInfo
     * @param add
     */
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String name = interfaceInfo.getName();
        // 创建时，所有参数必须非空
        if (add && StringUtils.isAnyBlank(name)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }

        if (StringUtils.isNotBlank(name) && name.length() > 50) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "名称过长");
        }

    }
}




