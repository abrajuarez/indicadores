package com.indicador.mapfre;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class IndicadormapfreApplication extends SpringBootServletInitializer{
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IndicadormapfreApplication.class);
    }
	

	public static void main(String[] args) {
		SpringApplication.run(IndicadormapfreApplication.class, args);
	}

}
