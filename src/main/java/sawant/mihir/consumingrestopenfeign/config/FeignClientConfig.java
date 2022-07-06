package sawant.mihir.consumingrestopenfeign.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "sawant.mihir.consumingrestopenfeign.proxy")
public class FeignClientConfig {
}
