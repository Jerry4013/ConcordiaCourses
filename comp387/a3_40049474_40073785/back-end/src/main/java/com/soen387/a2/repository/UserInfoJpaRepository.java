package com.soen387.a2.repository;

import com.soen387.a2.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/04
 **/

@Repository
public interface UserInfoJpaRepository extends JpaRepository<UserInfo, Integer> {
    UserInfo findByUsernameAndPassword(String username, String password);
}
