package com.omkar.service;

import com.omkar.exception.CarAlreadyExistException;
import com.omkar.exception.CarNotFoundException;
import com.omkar.model.Car;
import com.omkar.model.FuelType;
import com.omkar.repository.CarRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarManagementService implements ICarManagementService{
    private CarRepository carRepository;
    public CarManagementService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void addCar(Car car) {
        //if car already exist then throw exception
        if(carRepository.findByCarName(car.getCarName()).isPresent()){
            throw new CarAlreadyExistException("Car already exist with name: "+car.getCarName());
        }
        carRepository.save(car);
    }

    @Override
    public void removeCar(String carName) {
        Car car= carRepository.findByCarName(carName).orElseThrow(()->new CarNotFoundException("Car To be deleted not Exist"));
        carRepository.delete(car);
    }


    @Override
    public void updateCar(Car car) {
        Car oldCar = carRepository.findByCarName(car.getCarName())
                .orElseThrow(() -> new CarNotFoundException("Car not found with name: " + car.getCarName()));

        // Update specific fields
        if (car.getModel() != null) {
            oldCar.setModel(car.getModel());
        }
        if (car.getYear() > 0) {
            oldCar.setYear(car.getYear());
        }
        if (car.getPrice() > 0) {
            oldCar.setPrice(car.getPrice());
        }
        if (car.getColor() != null) {
            oldCar.setColor(car.getColor());
        }
        if (car.getFuelType() != null) {
            oldCar.setFuelType(car.getFuelType());
        }
        carRepository.save(oldCar);
    }


    @Override
    public Page<Car> getAllCars(int pageNo, int pageSize, String dir) {
        Sort sort= dir.equalsIgnoreCase("ASC")? Sort.by("price").ascending():Sort.by("price").descending();
        Pageable pageable= PageRequest.of(pageNo,pageSize,sort);
        Page<Car> carPage= carRepository.findAll(pageable);
        if(carPage.isEmpty()){
            throw new CarNotFoundException("Car not found");
        }
        return carPage;
    }

    @Override
    public Car getCarsByCarName(String carName) {
        return carRepository.findByCarName(carName).orElseThrow(()->new CarNotFoundException("Car not found"));
    }

    @Override
    public Page<Car> getCarsByModel(String model, int pageNo, int pageSize, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase("ASC") ? Sort.by("price").ascending() : Sort.by("price").descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Car> carPage = carRepository.findByModel(model, pageable);
        if(carPage.isEmpty()){
            throw new CarNotFoundException("Car not found");
        }
        return carPage;
    }


    @Override
    public Page<Car> getCarsByYear(int year, int pageNo, int pageSize, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase("ASC") ? Sort.by("price").ascending() : Sort.by("price").descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Car> carPage = carRepository.findByYear(year, pageable);
        if(carPage.isEmpty()){
            throw new CarNotFoundException("Car not found");
        }
        return carPage;
    }

    @Override
    public Page<Car> getCarsByFuelType(String fuelType, int pageNo, int pageSize, String sortBy) {
        FuelType fuelType1 = null;
        if(fuelType.equalsIgnoreCase("PETROL") || fuelType.equalsIgnoreCase("DIESEL") || fuelType.equalsIgnoreCase("ELECTRIC") || fuelType.equalsIgnoreCase("HYBRID")){
             fuelType1 = FuelType.valueOf(fuelType.toUpperCase());
        }else{
            throw new CarNotFoundException("Fuel Type not found : "  + fuelType);
        }
        Sort sort = sortBy.equalsIgnoreCase("ASC") ? Sort.by("price").ascending() : Sort.by("price").descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Car> carPage = carRepository.findByFuelType(fuelType1, pageable);
        if(carPage.isEmpty()){
            throw new CarNotFoundException("Car not found");
        }
        return carPage;
    }

    @Override
    public Page<Car> getCarsByColor(String color, int pageNo, int pageSize, String sortBy) {
        Sort sort = sortBy.equalsIgnoreCase("ASC") ? Sort.by("price").ascending() : Sort.by("price").descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Car> carPage = carRepository.findByColor(color, pageable);
        if(carPage.isEmpty()){
            throw new CarNotFoundException("Car not found");
        }
        return carPage;
    }

    @Override
    public void removeAllCars() {
        carRepository.deleteAll();
    }
}
