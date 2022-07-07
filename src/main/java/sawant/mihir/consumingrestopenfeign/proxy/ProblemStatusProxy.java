package sawant.mihir.consumingrestopenfeign.proxy;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import sawant.mihir.consumingrestopenfeign.model.ProblemSetStatus;

@Component
public class ProblemStatusProxy{

    private static final String URI_REQ_PARAM = "/api/problemset.recentStatus?count=";

    private final WebClient webClient;

    @Value("${service.url}")
    private String baseUrl;

    public ProblemStatusProxy(WebClient webClient){
        this.webClient = webClient;
    }


    public Mono<ProblemSetStatus> getRecentProblemStatus(int count){
        String uri = baseUrl + URI_REQ_PARAM + count;

        return webClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(ProblemSetStatus.class);
    }


}
