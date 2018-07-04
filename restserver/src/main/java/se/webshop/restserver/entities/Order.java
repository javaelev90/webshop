package se.webshop.restserver.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime dayCreated;

    //TODO make this work!!!!
    @ManyToOne
    private OrderStatus status;

    //TODO make this work!!!!
    @ManyToOne
    private User user;

    //TODO make this work
    @ManyToMany
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDayCreated() {
        return dayCreated;
    }

    public void setDayCreated(LocalDateTime dayCreated) {
        this.dayCreated = dayCreated;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
