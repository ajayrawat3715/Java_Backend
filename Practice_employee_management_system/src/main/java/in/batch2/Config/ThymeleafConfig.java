package in.batch2.Config;

import in.batch2.HibernateUtil.HibernateUtil;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;
import java.util.Map;

@WebListener
public class ThymeleafConfig implements ServletContextListener {

    private static JakartaServletWebApplication application;
    private static TemplateEngine templateEngine;
    private static JakartaServletWebApplication jakartaServletWebApplication;

    @Override
    public void contextInitialized(ServletContextEvent sce){
        application = jakartaServletWebApplication
                .buildApplication(sce.getServletContext());
        WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(application);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCharacterEncoding("UTF-8");

        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce){
        HibernateUtil.getSessionFactory().close();
    }

    @Override
    public void render(HttpServletRequest req,
                       HttpServletResponse res,
                       Map<String,Object> variables,
                       String templateName)
        throws ServletException , IOException{
        IWebExchange exchange = application
                .buildExchange(req,res);
        WebContext context = new WebContext(exchange,res.getLocale());
        context.setVariables(variables);
        templateEngine.process(templateName , context , res.getWriter());
    }


}
