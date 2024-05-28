package com.tencent.wxcloudrun.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Social_Event")
public class SocialEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String tag;
    ZonedDateTime startTime;
    ZonedDateTime endTime;
    String district;
    String address;
    String imagePaths;
    String title;
    String contact;
    String description;
    boolean expired;
    BigDecimal latitude;
    BigDecimal longitude;
}
