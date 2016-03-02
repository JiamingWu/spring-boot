package hello.web.listener;

import java.io.InputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.logicalcobwebs.proxool.configuration.JAXPConfigurator;
import org.xml.sax.InputSource;

@WebListener
public class ProxoolListener implements ServletContextListener {

    @SuppressWarnings("unused")
    private boolean autoShutdown = true;
    private static boolean loaded = false;

    public void contextDestroyed(ServletContextEvent event) {
        event.getServletContext().log("destroy proxool listener....");
    }

    public void contextInitialized(ServletContextEvent contextEvent) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        try {
            loadProxool();
        } catch (RuntimeException e) {
            contextEvent.getServletContext().log("cannot load proxool!", e);
            throw e;
        }
    }
    
    public static void loadProxool() {
        if (loaded) {
            return;
        }
        try {
            InputStream is = ProxoolListener.class.getResourceAsStream("/prox1ool.xml");
            JAXPConfigurator.configure(new InputSource(is), false);
            loaded = true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
