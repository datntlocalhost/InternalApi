package com.datnt.run.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * The Class WebConfigurer.
 * 
 * @author datnguyen
 */
@Configuration
public class WebConfigurer {

    /**
     * Cors filter.
     *
     * @return the cors filter
     */
    @Bean
    public CorsFilter corsFilter() {

        CorsConfiguration corsConfig = new CorsConfiguration();
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        corsConfig.addAllowedOrigin("*");
        corsConfig.addAllowedMethod("*");
        corsConfig.addAllowedHeader("*");
        corsConfig.addExposedHeader("Authorization");
        corsConfig.addExposedHeader("Link");
        corsConfig.addExposedHeader("X-Total-Count");
        corsConfig.setAllowCredentials(true);
        corsConfig.setMaxAge(1800L);

        source.registerCorsConfiguration("/api/**", corsConfig);

        return new CorsFilter(source);
    }

}
