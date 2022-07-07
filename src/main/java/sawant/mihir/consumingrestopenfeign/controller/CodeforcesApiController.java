package sawant.mihir.consumingrestopenfeign.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import sawant.mihir.consumingrestopenfeign.model.ProblemSetStatus;

import java.util.Arrays;

@RestController
public class CodeforcesApiController {

    private static final String REQ_PARAM = "?count=";

    @Value("${service.url}")
    private String baseUrl;


    private final RestTemplate restTemplate;
    public CodeforcesApiController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping("/status")
    public ResponseEntity<?> recentProblemStatus(@RequestParam int count) {
        String uri = baseUrl + REQ_PARAM +count;


        try{
            ProblemSetStatus problemStatus = restTemplate
                    .exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, ProblemSetStatus.class)
                    .getBody();
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(problemStatus);
        }catch(HttpClientErrorException ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ex.getMessage());
        }

    }

    @GetMapping("/members")
    public ResponseEntity<?> getAllTheMembers(@RequestParam int count) {
        Object response = recentProblemStatus(count).getBody();
        if(response instanceof ProblemSetStatus problemSetStatus){
             var members = Arrays.stream(problemSetStatus.result())
                     .map(result -> result.author().members()).toList();
             return ResponseEntity.status(HttpStatus.ACCEPTED)
                     .body(members);
         } else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body((String) response);
         }
    }
}
