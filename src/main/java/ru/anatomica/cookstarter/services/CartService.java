package ru.anatomica.cookstarter.services;

import org.springframework.web.context.annotation.ApplicationScope;
import ru.anatomica.cookstarter.entities.OrderItem;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.anatomica.cookstarter.entities.Product;
import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
// @Scope(value = WebApplicationContext..SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@ApplicationScope
@Data
public class CartService {
    private List<OrderItem> items;
    private BigDecimal price;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void clear() {
        items.clear();
        recalculate();
    }

    public void add(Product product) {
        for (OrderItem i : items) {
            if (i.getProduct().getId().equals(product.getId())) {
                i.increment();
                recalculate();
                return;
            }
        }
        items.add(new OrderItem(product));
        recalculate();
    }

    public void decrement(Product product) {
        for (OrderItem i : items) {
            if (i.getProduct().getId().equals(product.getId())) {
                i.decrement();
                if (i.isEmpty()) {
                    items.remove(i);
                }
                recalculate();
                return;
            }
        }
    }

    public void removeByProductId(Long productId) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(productId)) {
                items.remove(i);
                recalculate();
                return;
            }
        }
    }

    public void recalculate() {
        price = new BigDecimal(0.0);
        for (OrderItem i : items) {
            price = price.add(i.getPrice());
        }
    }
}
