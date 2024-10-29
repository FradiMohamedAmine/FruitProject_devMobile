package utils;

import java.io.Serializable;

public class Fruit implements Serializable {
    private String name;
    private int image;
    private float price;

    public Fruit(String name, float price, int image) {
        this.name = name;
        this.image = image;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
