package gr.com.arounder;

import com.google.common.util.concurrent.Uninterruptibles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RefreshScope
@RestController
public class ArounderController implements ArounderCloud {

    private static Logger LOGGER = LoggerFactory.getLogger(ArounderController.class);

    @Value("${arounder.item:@}")
    private String item;

    @Override
    public String getItem() {
        LOGGER.warn("Arounder GetItem ");
        return item;
    }

    @Override
    public String around(@PathVariable String value) {
        LOGGER.warn("around for '{}'", value);
        return item + value + new StringBuilder(item).reverse().toString();
    }

    @Override
    public int hash(String value) {
        LOGGER.warn("start hash calc for '{}'", value);
        Uninterruptibles.sleepUninterruptibly(1000, TimeUnit.MILLISECONDS);
        LOGGER.warn("hash calc for '{}' finish ", value);
        return value.hashCode();
    }

    @Override
    public int fuck() {
        LOGGER.warn("catch my fuck!!!!!!");
        throw new RuntimeException("Hello From Fucker");
    }


}
