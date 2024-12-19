package com.omkar.model;

import com.omkar.validations.ValidFuelType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Objects;


@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty(message = "Car Name cannot be empty")

    @Column(unique = true)
    private String carName;
    @NotEmpty(message = "model cannot be empty")
    private String model;
    @NotNull(message = "Make cannot be empty")
    private int year;
    @NotNull(message = "Price cannot be empty")
    private double price;
    @NotEmpty(message = "Color cannot be empty")
    private String color;
    @ValidFuelType
    @NotNull(message = "Fuel Type cannot be Null")
    private FuelType fuelType;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public void setCarName(@NotEmpty(message = "Car Name cannot be empty") String carName) {
        this.carName = carName;
    }

    public void setModel(@NotEmpty(message = "model cannot be empty") String model) {
        this.model = model;
    }

    public void setYear(@NotNull(message = "Make cannot be empty") int year) {
        this.year = year;
    }

    public void setPrice(@NotNull(message = "Price cannot be empty") double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", fuelType=" + fuelType +
                '}';
    }

    public void setColor(@NotEmpty(message = "Color cannot be empty") String color) {
        this.color = color;
    }

    public void setFuelType(@NotNull(message = "Fuel Type cannot be Null") FuelType fuelType) {
        this.fuelType = fuelType;
    }

    public @NotEmpty(message = "Car Name cannot be empty") String getCarName() {
        return carName;
    }

    @NotNull(message = "Make cannot be empty")
    public int getYear() {
        return year;
    }

    public @NotEmpty(message = "model cannot be empty") String getModel() {
        return model;
    }

    @NotNull(message = "Price cannot be empty")
    public double getPrice() {
        return price;
    }

    public @NotEmpty(message = "Color cannot be empty") String getColor() {
        return color;
    }

    public @NotNull(message = "Fuel Type cannot be Null") FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && year == car.year && Double.compare(price, car.price) == 0 && Objects.equals(carName, car.carName) && Objects.equals(model, car.model) && Objects.equals(color, car.color) && fuelType == car.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carName, model, year, price, color, fuelType);
    }
}
