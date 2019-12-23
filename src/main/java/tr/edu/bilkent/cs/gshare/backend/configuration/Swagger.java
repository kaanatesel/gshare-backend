package tr.edu.bilkent.cs.gshare.backend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
//@Profile(value = { "development" })
@Import(BeanValidatorPluginsConfiguration.class)
public class Swagger
{

	private final String controllerPackage = "tr.edu.bilkent.cs.gshare.backend.controller";
	private final Logger log = LoggerFactory.getLogger( Swagger.class );

	@Value("${server.port}")
	private Integer port;

	@Value("${swagger.app.name}")
	private String appName;

	@Value("${swagger.app.version}")
	private String version;

	@Bean
	public Docket swaggerSpringfoxDocket()
	{

		log.debug( "Starting Swagger" );
		StopWatch watch = new StopWatch();
		watch.start();

		Docket docket = new Docket( DocumentationType.SWAGGER_2 );
		docket.forCodeGeneration( true );
		docket.apiInfo( createApiInfo() );
		docket.genericModelSubstitutes( ResponseEntity.class );
		docket.ignoredParameterTypes( Pageable.class );
		docket.directModelSubstitute( java.time.OffsetDateTime.class, java.sql.Date.class );
		docket.directModelSubstitute( UUID.class, UUID.class );

		ApiSelectorBuilder asp = docket.select();
		asp.apis( RequestHandlerSelectors.basePackage( controllerPackage ) );
		asp.paths( PathSelectors.any() );

		docket = asp.build();

		watch.stop();
		log.trace( "http://localhost:{}/swagger-ui.html", port );
		log.debug( "Started Swagger in {} ms", watch.getTotalTimeMillis() );
		return docket;
	}

	private ApiInfo createApiInfo()
	{

		ApiInfoBuilder builder = new ApiInfoBuilder();
		builder.contact( new Contact( "Kaan Ateşel", "", "kaanatesel99@gmail.com" ) );
		builder.description( "Backend of Websites" );
		builder.license( "Apache License Version 2.0" );
		builder.title( appName );
		builder.version( version );

		return builder.build();
	}
}
