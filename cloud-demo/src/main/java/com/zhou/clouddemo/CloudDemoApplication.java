package com.zhou.clouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 注册到eureka上
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CloudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudDemoApplication.class, args);
	}
}
