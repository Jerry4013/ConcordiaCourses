package com.soen387.a2.service;

import com.soen387.a2.Model.UserModel;
import com.soen387.a2.error.BusinessException;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/11/05
 **/

public interface UserService {

    UserModel login(String username, String password) throws BusinessException;

}
