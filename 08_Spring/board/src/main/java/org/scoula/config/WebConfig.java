package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    //업로드된 파일이 저장될 디렉토리 경로 지정
    final String LOCATION = "c:/upload";

    //파일 1개 당 최대 크기(여기서는 10MB)
    final long MAX_FILE_SIZE = 1024 * 1024 * 10L;
    //파일 전체 크기(여기서는 20MB)
    final long MAX_REQUEST_SIZE = 1024 * 1024 * 20L;
    //메모리 내에서 처리될 파일 크기의 임계값
    final int FILE_SIZE_THRESHOLD = 1024 * 1024 * 5;
    //(여기서는 5MB 넘으면 디스크에 임시저장)


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletConfig.class};
    }

    // 스프링의 FrontController인 DispatcherServlet이 담당할 Url 매핑 패턴, / : 모든 요청에 대해 매핑
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    // POST body 문자 인코딩 필터 설정 - UTF-8 설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();

        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        return new Filter[] {characterEncodingFilter};
    }

    //ServletRegistration.Dynamic 클래스의 메소드 재정의
    //서블릿의 등록 및 설정을 사용자 정의할 때 사용
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

        MultipartConfigElement multipartConfig = new MultipartConfigElement(
                LOCATION, // 업로드 처리 디렉토리 경로
                MAX_FILE_SIZE, // 업로드 가능한 파일 하나의 최대 크기
                MAX_REQUEST_SIZE, // 업로드 가능한 전체 최대 크기(여러 파일 업로드 하는 경우)
                FILE_SIZE_THRESHOLD // 메모리 파일의 최대 크기(이보다 작으면 실제 메모리에서만 작업)
        );
        registration.setMultipartConfig(multipartConfig);
        //서블릿이 파일 업로드 요청을 처리할 수 있도록 설정
    }
}
