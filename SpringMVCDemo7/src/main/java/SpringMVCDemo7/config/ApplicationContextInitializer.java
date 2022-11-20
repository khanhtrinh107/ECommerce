package SpringMVCDemo7.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
@Configuration
public class ApplicationContextInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {
			TilesConfig.class,
			HibernateConfig.class,
			SpringSecurityConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {
			ApplicationContextConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {
			"/"	
		};
	}
	
}
