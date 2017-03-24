package com.wq.website.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by wangq on 2017/3/24.
 */
@Component
@ConfigurationProperties(prefix = "app")
public class AppConfigDto {
    private Boolean randomMusic;

    public Boolean getRandomMusic() {
        return randomMusic;
    }

    public void setRandomMusic(Boolean randomMusic) {
        this.randomMusic = randomMusic;
    }
}
