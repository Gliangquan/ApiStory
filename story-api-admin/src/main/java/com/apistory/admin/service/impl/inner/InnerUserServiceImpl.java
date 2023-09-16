package com.apistory.admin.service.impl.inner;

import com.apistory.common.exception.ErrorCode;
import com.apistory.common.common.BusinessException;
import com.apistory.admin.mapper.UserMapper;
import com.apistory.common.model.entity.User;
import com.apistory.common.service.InnerUserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserServiceImpl implements InnerUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getInvokeUser(String accessKey) {
        if (StringUtils.isAnyBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey", accessKey);
        User user = userMapper.selectOne(queryWrapper);
        System.out.println("获取到的用户信息 = " + user);
        return user;
    }
}
