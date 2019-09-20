package com.czz.springboot.jpa.repository;

import com.czz.springboot.jpa.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-09-20 9:31
 */
public interface UserRepository extends JpaRepository<User,Integer> {

}
