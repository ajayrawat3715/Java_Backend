package in.batch2.Config;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.servlet.ServletContext;

public class ThymeleafConfig {

    private final TemplateEngine templateEngine;

    public ThymeleafConfig(ServletContext servletContext) {

        JakartaServletWebApplication application =
                JakartaServletWebApplication.buildApplication(servletContext);

        IWebApplication webApplication = application;

        WebApplicationTemplateResolver resolver =
                new WebApplicationTemplateResolver(webApplication);

        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false);

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }

    public TemplateEngine getTemplateEngine() {
        return templateEngine;
    }
}