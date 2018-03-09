package gr.com.arounder;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface ArounderCloud {

    @GetMapping("/around")
    String around();

    @GetMapping("/around/{value}")
    String around(@PathVariable String value);
}
