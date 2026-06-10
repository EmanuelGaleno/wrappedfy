package com.duell.wrappedfy;

import com.duell.wrappedfy.infrastructure.spotify.config.SpotifyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpotifyProperties.class)
public class WrappedfyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WrappedfyApiApplication.class, args);
	}
}
