package com.goodlook.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by iandronov on 24.10.2017.
 */

@Configuration
@EnableAutoConfiguration
@RestController
@RefreshScope
@PropertySource("classpath:/config/config-estimator.properties")
public class EstimationConfig {

    @Value("${configuration.projectName}")
    String projectName;

    @Value("${configuration.amountOfAvatarsPerPage}")
    String amountOfAvatarsPerPage;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getAmountOfAvatarsPerPage() {
        return Integer.valueOf(amountOfAvatarsPerPage);
    }

    public void setAmountOfAvatarsPerPage(String amountOfAvatarsPerPage) {
        this.amountOfAvatarsPerPage = amountOfAvatarsPerPage;
    }
}
