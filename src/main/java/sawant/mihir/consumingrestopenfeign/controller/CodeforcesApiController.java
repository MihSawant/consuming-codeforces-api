package sawant.mihir.consumingrestopenfeign.controller;


import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import sawant.mihir.consumingrestopenfeign.model.Member;
import sawant.mihir.consumingrestopenfeign.model.ProblemSetStatus;
import sawant.mihir.consumingrestopenfeign.model.Result;
import sawant.mihir.consumingrestopenfeign.proxy.ProblemStatusProxy;

import java.util.Arrays;
import java.util.List;

@RestController
public record CodeforcesApiController(ProblemStatusProxy proxy) {

    public CodeforcesApiController(ProblemStatusProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/status")
    public Mono<ProblemSetStatus> recentProblemStatus(@RequestParam int count) {
        return proxy.getRecentProblemStatus(count);
    }

    @GetMapping("/members")
    public Mono<List<Member[]>> getAllTheMembers(@RequestParam int count) {
        Mono<Result[]> results = recentProblemStatus(count).map(ProblemSetStatus::result);

        var members =
                results.map(r -> Arrays.stream(r)
                        .map(result -> result.author().members()).toList());

        return members;
    }
}
