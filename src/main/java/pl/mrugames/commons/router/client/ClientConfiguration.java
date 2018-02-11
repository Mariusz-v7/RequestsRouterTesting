package pl.mrugames.commons.router.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.mrugames.commons.router.sessions.Session;

@Configuration
public class ClientConfiguration {
    @Bean
    public Client client(TestConnector testConnector) {
        return new Client(30000, testConnector, new Session());
    }

}
