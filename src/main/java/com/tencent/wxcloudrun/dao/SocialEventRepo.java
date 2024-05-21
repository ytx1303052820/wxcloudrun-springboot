package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.dto.SocialEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SocialEventRepo extends JpaRepository<SocialEvent,Integer> {
}
