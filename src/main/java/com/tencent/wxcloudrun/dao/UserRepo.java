package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.UserTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserTest,Integer> {
}
