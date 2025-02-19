package com.example.SpringMongoProject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import java.util.Arrays;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // ✅ Allow only your frontend domain
        config.setAllowedOrigins(Arrays.asList("https://studentmanagment-2.onrender.com"));

        // ✅ Allow common HTTP methods
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // ✅ Allow headers needed for authentication
        config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        // ✅ Allow credentials (for JWT, cookies, sessions)
        config.setAllowCredentials(true);

        // ✅ Apply CORS settings to all API endpoints
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
