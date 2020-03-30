package com.soen387.a2.service;

import com.soen387.a2.Model.UserModel;
import com.soen387.a2.dataobject.UserInfo;
import com.soen387.a2.error.BusinessException;
import com.soen387.a2.repository.UserInfoJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: Jingchao Zhang
 * @createDate: 2019/11/05
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoJpaRepository userInfoJpaRepository;


    @Override
    public UserModel login(String username, String password) throws BusinessException {
        UserInfo userInfo = userInfoJpaRepository.findByUsernameAndPassword(username, password);
        if (userInfo == null) {
            return null;
        }
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userInfo, userModel);
        return userModel;
    }
}
