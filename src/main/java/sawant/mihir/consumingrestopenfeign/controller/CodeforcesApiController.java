package sawant.mihir.consumingrestopenfeign.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sawant.mihir.consumingrestopenfeign.model.Member;
import sawant.mihir.consumingrestopenfeign.model.ProblemSetStatus;
import sawant.mihir.consumingrestopenfeign.proxy.ProblemStatusProxy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public record CodeforcesApiController(ProblemStatusProxy proxy) {

    public CodeforcesApiController(ProblemStatusProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/status")
    public ProblemSetStatus recentProblemStatus(@RequestParam int count) {
        return proxy.getProblemSetStatus(count);
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member[]>> getAllTheMembers(@RequestParam int count) {
        ProblemSetStatus problemSetStatus = recentProblemStatus(count);
        var members = Arrays.stream(problemSetStatus.result())
                .map(result -> result.author().members())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(members);
    }
}
