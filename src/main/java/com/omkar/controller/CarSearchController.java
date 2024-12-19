package com.omkar.controller;

import com.omkar.model.Car;
import com.omkar.service.ICarManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/car/search")
public class CarSearchController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);
    private ICarManagementService carManagementService;
    public CarSearchController(ICarManagementService carManagementService) {
        this.carManagementService = carManagementService;
    }
    @GetMapping("/{carName}")
    public ResponseEntity<Map<String,Object>> getCar(@PathVariable("carName")String carName){
        logger.info("Serching for car With name: {}", carName);
        Car car = carManagementService.getCarsByCarName(carName);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Car found successfully");
        response.put("car", car);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);

    }

    @GetMapping("/all")
    public ResponseEntity<Map<String,Object>> getAllCars(@RequestParam(name = "pageNo",defaultValue = "0")int pageNo
            ,@RequestParam(name = "pageSize",defaultValue = "10") int pageSize,@RequestParam(name = "dir",defaultValue = "asc") String dir){
        logger.info("Getting all cars with page No : {} , pageSize : {},dirextion :{}", pageNo,pageSize ,dir);
        Page<Car> retrievedCars = carManagementService.getAllCars(pageNo,pageSize,dir);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cars found successfully");
        response.put("cars", retrievedCars);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/model/{model}")
    public ResponseEntity<Map<String,Object>> searchByModal(@PathVariable("model") String modal,@RequestParam(name = "pageNo",defaultValue = "0")int pageNo
            ,@RequestParam(name = "pageSize",defaultValue = "10") int pageSize,@RequestParam(name = "dir",defaultValue = "asc") String dir){
        logger.info("Getting cars By Model with page No : {} , pageSize : {},dirextion :{}", pageNo,pageSize ,dir);
        Page<Car> retrievedCars = carManagementService.getCarsByModel(modal,pageNo,pageSize,dir);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cars found By Model successfully");
        response.put("cars", retrievedCars);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
    @GetMapping("/year/{year}")
    public ResponseEntity<Map<String,Object>> searchCarsByModal(@PathVariable("year") Integer year,@RequestParam(name = "pageNo",defaultValue = "0")int pageNo
            ,@RequestParam(name = "pageSize",defaultValue = "10") int pageSize,@RequestParam(name = "dir",defaultValue = "asc") String dir){
        logger.info("Getting cars By year {} with page No : {} , pageSize : {},dirextion :{}",year, pageNo,pageSize ,dir);
        Page<Car> retrievedCars = carManagementService.getCarsByYear(year,pageNo,pageSize,dir);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cars found By Model successfully");
        response.put("cars", retrievedCars);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

    @GetMapping("/fuelType/{fuelType}")
    public ResponseEntity<Map<String,Object>> searchCarsByFuelType(@PathVariable("fuelType") String fuelType, @RequestParam(name = "pageNo",defaultValue = "0")int pageNo
            , @RequestParam(name = "pageSize",defaultValue = "10") int pageSize, @RequestParam(name = "dir",defaultValue = "asc") String dir){
        logger.info("Getting cars By fuelType {} with page No : {} , pageSize : {},dirextion :{}",fuelType, pageNo,pageSize ,dir);
        Page<Car> retrievedCars = carManagementService.getCarsByFuelType(fuelType,pageNo,pageSize,dir);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cars found By fuelType successfully");
        response.put("cars", retrievedCars);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }
    @GetMapping("/color/{color}")
    public ResponseEntity<Map<String,Object>> searchCarsByColor(@PathVariable("color") String color, @RequestParam(name = "pageNo",defaultValue = "0")int pageNo
            , @RequestParam(name = "pageSize",defaultValue = "10") int pageSize, @RequestParam(name = "dir",defaultValue = "asc") String dir){
        logger.info("Getting cars By color {} with page No : {} , pageSize : {},dirextion :{}",color, pageNo,pageSize ,dir);
        Page<Car> retrievedCars = carManagementService.getCarsByColor(color,pageNo,pageSize,dir);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Cars found By color successfully");
        response.put("cars", retrievedCars);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);
    }

}
