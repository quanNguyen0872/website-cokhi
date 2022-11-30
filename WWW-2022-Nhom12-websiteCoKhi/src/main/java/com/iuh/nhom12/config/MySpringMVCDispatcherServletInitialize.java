package com.iuh.nhom12.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MySpringMVCDispatcherServletInitialize extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {

		// Parameters:-
		// location - the directory location where files will be stored
		// maxFileSize - the maximum size allowed for uploaded files
		// maxRequestSize - the maximum size allowed for multipart/form-data requests
		// fileSizeThreshold - the size threshold after which files will be written to
		// disk
		
		MultipartConfigElement multipartConfig = new MultipartConfigElement("C:\\Users\\PC\\Documents\\WWW\\Nhom12_WWW_ver2\\WWW-2022-Nhom12-websiteCoKhi\\src\\main\\webapp\\resources", 1048576, 10485760, 0);
		registration.setMultipartConfig(multipartConfig);
	}

}
