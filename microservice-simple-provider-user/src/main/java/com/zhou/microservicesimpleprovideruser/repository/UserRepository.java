/**
 * Date:     2018/6/622:36
 * AUTHOR:   Administrator
 */
package com.zhou.microservicesimpleprovideruser.repository;

import com.zhou.microservicesimpleprovideruser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 2018/6/6  22:36
 * created by zhoumb
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
