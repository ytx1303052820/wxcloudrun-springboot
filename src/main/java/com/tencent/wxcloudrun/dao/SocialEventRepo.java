package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.SocialEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SocialEventRepo extends JpaRepository<SocialEvent,Integer> {
    @Query(value = "select * from social_event where end_time > CURRENT_TIMESTAMP", nativeQuery = true)
    List<SocialEvent> findAll();
}
