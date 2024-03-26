package models;

import java.time.LocalDate;

public class Medicine {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private String description;
    private LocalDate dateOfDelivery;
    private LocalDate expirationDate;

    public Medicine() {
    }

    public Medicine(Long id, String name, int price, int quantity, String description, LocalDate dateOfDelivery, LocalDate expirationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.dateOfDelivery = dateOfDelivery;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(LocalDate dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "\nЛекарство: " + "\n"+
                "id: " + id + "\n"+
                "название: " + name + "\n" +
                "цена: " + price + "\n"+
                "количество: " + quantity + "\n"+
                "описание: " + description + "\n" +
                "дата поставки: " + dateOfDelivery + "\n"+
                "срок годности: " + expirationDate + "\n"+
                "-------------------------------";
    }
}
