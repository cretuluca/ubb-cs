package controller;

import model.Car;
import model.Vehicle;
import repository.CapacityExceededException;
import repository.Repository;
import repository.VechicleExistenceException;

import java.util.Objects;

public class Controller {
    private Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
        this.populateRepository();
    }

    public void addVehicleService(Vehicle vehicle) {
        if(this.repository.exists(vehicle)) {
            throw new VechicleExistenceException("Vehicle already exists");
        } else {
            try {
                this.repository.add(vehicle);
            } catch (CapacityExceededException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void removeVehicleService(Vehicle vehicle) {
        if(this.repository.exists(vehicle)) {
            this.repository.remove(vehicle);
        } else {
            throw new VechicleExistenceException("Vehicle does not exist");
        }
    }

    public Vehicle[] filter(String filterKey) {
        Vehicle[] allVehicles = this.repository.getAll();
        Vehicle[] tempFilteredVehicles = new Vehicle[allVehicles.length];

        int filteredSize = 0;
        for(Vehicle vehicle : allVehicles) {
            if(Objects.equals(vehicle.getColor(), filterKey)) {
                tempFilteredVehicles[filteredSize++] = vehicle;
            }
        }

        Vehicle[] filteredVehicles = new Vehicle[filteredSize];
        System.arraycopy(tempFilteredVehicles, 0, filteredVehicles, 0, filteredSize);

        return filteredVehicles;
    }

    public Vehicle[] getAllVehiclesService() {
        return this.repository.getAll();
    }

    void populateRepository() {
        this.repository.add(new Car("red", "MM 48 MDS"));
        this.repository.add(new Car("black", "B 71 XYZ"));
        this.repository.add(new Car("blue", "CJ 23 SLV"));
    }
}
