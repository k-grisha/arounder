package gr.com.arounder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ArounderController implements ArounderCloud {

    @Value("${arounder.item:@}")
    private String item;

    @Override
    public String around() {
        return item;
    }

    @Override
    public String around(String value) {
        return item + value + new StringBuilder(item).reverse().toString();
    }


}
