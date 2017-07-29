package pl.mrugames.commons.router.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfiguration {
    @Bean
    public Client client(TestConnector testConnector) {
        return new Client(30000, testConnector);
    }

}
