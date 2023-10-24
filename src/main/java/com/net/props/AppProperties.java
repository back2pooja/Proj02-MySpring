package com.net.props;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Data
@EnableConfigurationProperties
@Configuration
@ConfigurationProperties(prefix="plan-api")
public class AppProperties {
	
	private Map<String,String> message = new HashMap<>();

	public Map<String, String> getMessages() {
		return message;
	}

	public void setMessages(Map<String, String> messages) {
		this.message = messages;
	}

}
