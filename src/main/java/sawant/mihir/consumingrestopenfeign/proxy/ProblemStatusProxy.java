package sawant.mihir.consumingrestopenfeign.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sawant.mihir.consumingrestopenfeign.model.ProblemSetStatus;

@FeignClient(name = "problemStatus", url = "${service.url}")
public interface ProblemStatusProxy {

    @GetMapping("/api/problemset.recentStatus")
    ProblemSetStatus getProblemSetStatus(
            @RequestParam int count
    );
}
