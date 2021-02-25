package com.itcen.tellcen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.itcen.tellcen.interceptor.AdminInterceptor;
import com.itcen.tellcen.interceptor.LoginInterceptor;
//  <mvc:annotation-driven />
@EnableWebMvc
@ComponentScan(basePackages = { "com.itcen.tellcen.controller" })
@Configuration
public class ServletConfig extends WebMvcConfigurerAdapter {

	// 디폴트 서블릿 핸들러 설정 = <mvc:default-servlet-handler>
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// 뷰 컨트롤러 설정
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	// 리소스 핸들러 설정
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// ViewResolver 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		registry.viewResolver(resolver);
	}

	// 인터셉터

	@Bean
	public AdminInterceptor adminInterceptor() {
		return new AdminInterceptor();
	}

	@Bean
	public LoginInterceptor loginInterceptor() {
		return new LoginInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(adminInterceptor()).addPathPatterns("/admin/**");
		registry.addInterceptor(loginInterceptor()).addPathPatterns("/petition/**")
			.addPathPatterns("/complaint/**").addPathPatterns("/suggestion/**")
			.addPathPatterns("/inquiry/**").addPathPatterns("/mypage/**");
		// 공지(notice) 제외
	}

}
