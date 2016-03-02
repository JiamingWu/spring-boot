package hello.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.web.listener.ProxoolListener;

//@Configuration
public class LoadProxoolListener {

    //@Bean
    public ProxoolListener proxoolListener() {
        return new ProxoolListener();
    }
    
}
