package com.commerce.shop.buy.phone.Schemas;

import java.util.Objects;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Item {

  public @Id @GeneratedValue Long upc;
  @NotBlank(message = "shortName must not be blank")
  public String shortName;
  @Column(unique = true)
  @NotBlank(message = "longName must not be blank")
  public String longName;
  @NotBlank(message = "color must not be blank")
  public String color;
  @NotNull(message = "price must not be blank")
  public int price;
  @NotNull(message = "ram must not be blank")
  public int ram;
  @NotNull(message = "storage must not be blank")
  public int storage;
  @NotBlank(message = "currency must not be blank")
  public String currency;
  @NotBlank(message = "At least a single image is required!")
  public String images;

  @Column(columnDefinition = "VARCHAR(4000)")
  public String description;
  @NotNull(message = "count must not be blank")
  public int count;

  public String getShortName() {
    return shortName;
  }

  public String getLongName() {
    return longName;
  }

  public String getCurrency() {
    return currency;
  }

  public String getDescription() {
    return description;
  }

  public Long getUpc() {
    return upc;
  }

  public int getPrice() {
    return price;
  }

  public String getColor() {
    return color;
  }

  public String getImages() {
    return images;
  }

  public int getRam() {
    return ram;
  }

  public int getStorage() {
    return storage;
  }

  public void setUpc(Long arg) {
    upc = arg;
  }

  public void setUpc(String arg) {
    upc = Long.parseLong(arg);
  }

  public void setShortName(String arg) {
    shortName = arg;
  }

  public void setLongName(String arg) {
    longName = arg;
  }

  public void setCurrency(String arg) {
    currency = arg;
  }

  public void setDescription(String arg) {
    description = arg;
  }

  public void setPrice(int arg) {
    price = arg;
  }

  public void setPrice(String arg) {
    price = Integer.parseInt(arg);
  }

  public void setColor(String arg) {
    color = arg;
  }

  public void setImages(String arg) {
    images = arg;
  }

  public void setRam(int arg) {
    ram = arg;
  }

  public void setRam(String arg) {
    ram = Integer.parseInt(arg);
  }

  public void setStorage(int arg) {
    storage = arg;
  }

  public void setStorage(String arg) {
    storage = Integer.parseInt(arg);
  }

  public Item() {
  }

  // could not use double brace initialization :(
  public Item(String color, int count, String currency, String description, String images, String longName, int price,
      int ram, String shortName, int storage) {
    this.color = color;
    this.count = count;
    this.currency = currency;
    this.description = description;
    this.images = images;
    this.longName = longName;
    this.price = price;
    this.ram = ram;
    this.shortName = shortName;
    this.storage = storage;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Item))
      return false;
    Item item = (Item) o;
    return Objects.equals(this.shortName, item.shortName) && Objects.equals(this.longName, item.longName)
        && Objects.equals(this.color, item.color) && Objects.equals(this.count, item.count)
        && Objects.equals(this.currency, item.currency) && Objects.equals(this.upc, item.upc)
        && Objects.equals(this.price, item.price) && Objects.equals(this.ram, item.ram)
        && Objects.equals(this.storage, item.storage) && Objects.equals(this.description, item.description);
  }

  @Override
  public int hashCode() {
    return Integer.parseInt(Long.toString(upc));
  }

  @Override
  public String toString() {
    return "Item{" + "UPC=" + this.upc + ", longName='" + this.longName + ", shortName='" + this.shortName + "'..";
  }
}