package com.omkar.repository;

import com.omkar.model.Car;
import com.omkar.model.FuelType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CarRepository extends JpaRepository<Car,String> {
    Optional<Car> findByCarName(String carName);

//    Optional<List<Car>> findByModel(String model);
    Page<Car> findByModel(String model, Pageable pageable);


//    Optional<List<Car>> findByYear(int year);
    Page<Car> findByYear(int year, Pageable pageable);

//    Optional<List<Car>> findByFuelType(FuelType fuelType);
    Page<Car> findByFuelType(FuelType fuelType, Pageable pageable);

//    Optional<List<Car>> findByColor(String color);
    Page<Car> findByColor(String color, Pageable pageable);

//    Page<Car> findByColor(String color, Pageable pageable);

}
