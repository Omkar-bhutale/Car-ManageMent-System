package com.omkar.service;

import com.omkar.model.Car;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICarManagementService {
    public void addCar(Car car);
    public void removeCar(String carName);
    public void updateCar(Car car);
    public Page<Car> getAllCars(int pageNo, int pageSize, String sortBy);
    public Car getCarsByCarName(String carName);
    public Page<Car> getCarsByModel(String model,int pageNo, int pageSize, String sortBy);
    public Page<Car> getCarsByYear(int year,int pageNo, int pageSize, String sortBy);
   public Page<Car> getCarsByFuelType(String fuelType,int pageNo, int pageSize, String sortBy);
    public Page<Car> getCarsByColor(String color,int pageNo, int pageSize, String sortBy);
    public void removeAllCars();
}
