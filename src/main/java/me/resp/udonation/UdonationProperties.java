package me.resp.udonation;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@ConfigurationProperties(prefix = "app")
@Configuration
@Getter
@Setter
public class UdonationProperties {
	
}
