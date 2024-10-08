package org.scoula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.HandlerInterceptor;

@EnableWebMvc
@ComponentScan(basePackages = {
        "org.scoula.controller",
        "org.scoula.exception",
        "org.scoula.ex03.controller",
        "org.scoula.board.controller"
}) // Spring MVC용 컴포넌트 등록을 위한 스캔 페이지


public class ServletConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
        registry.addResourceHandler("/manager/**").addResourceLocations("/manager/");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");

        registry.viewResolver(bean);

    }

    // Servlet 3.0 파일 업로드 사용시 - MultipartResolver 빈 등록
    @Bean
    public MultipartResolver multipartResolver() {
//        StandardServletMultipartResolver resolver
//                = new StandardServletMultipartResolver();
//        return resolver;
        // 위 아래 같은 코드
        return new StandardServletMultipartResolver();
    }

}
