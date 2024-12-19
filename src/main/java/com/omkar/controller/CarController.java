package com.omkar.controller;

import com.omkar.model.Car;
import com.omkar.service.ICarManagementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/car")
@Tag(name = "Car Management System", description = "Endpoints to manage cars (ADD CAR,REMOVE CAR,UPDATE CAR)" )
public class CarController {
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private ICarManagementService carManagementService;

    public CarController(ICarManagementService carManagementService) {
        this.carManagementService = carManagementService;
    }
    @Operation(summary = "Add a new car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully added a new car"),
            @ApiResponse(responseCode = "400", description = "Validation failed while adding a new car"),
            @ApiResponse(responseCode = "409", description = "Car already exists")
    })
    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> addCar(@Valid @RequestBody Car car) {
        logger.info("Adding car: {}", car.getCarName());
        carManagementService.addCar(car);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Car added successfully");
        response.put("carName", car.getCarName());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @Operation(summary = "Delete a car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully removed a  car"),
            @ApiResponse(responseCode = "404", description = "Car Not Found")
    })
    @DeleteMapping("/remove/{carName}")
    public ResponseEntity<Map<String, Object>> removeCar(@PathVariable("carName") String carName) {
        logger.info("Removing car: {}", carName);
        carManagementService.removeCar(carName);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Car removed successfully");
        response.put("carName", carName);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @Operation(summary = "Update  a car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully Updated a  car"),
            @ApiResponse(responseCode = "404", description = "Car Not Found/Exist")
    })
    @PutMapping("/update")
    public ResponseEntity<Map<String, Object>> updateCar(@Valid @RequestBody Car car) {
        logger.info("Updating car: {}", car.getCarName());
        carManagementService.updateCar(car);
        logger.info("Updating car successfully: {}", car.getCarName());
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Car updated successfully");
        response.put("carName", car.getCarName());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}