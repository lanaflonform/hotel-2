package io.khasang.hotel.dto;

import io.khasang.hotel.entity.Car;
import io.khasang.hotel.entity.Employee;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class CarDTO {
    private long id;
    private String model;
    private LocalDate year;
    private Set<EmployeeDTO> employeeSet = new HashSet<>();

    public Set<CarDTO> getCarDTO(Set<Car> carSet) {
        Set<CarDTO> carDTOSet = new HashSet<>();

        for (Car car : carSet) {
            Set<EmployeeDTO> employeeDTOS = new HashSet<>();
            CarDTO carDTO = new CarDTO();
            carDTO.setId(car.getId());
            carDTO.setModel(car.getModel());
            carDTO.setYear(car.getYear());

            for (Employee employee : car.getEmployeeSet()) {
                EmployeeDTO employeeDTO = new EmployeeDTO();
                employeeDTO.setFirstName(employee.getFirstName());
                employeeDTO.setLastName(employee.getLastName());
                employeeDTO.setId(employee.getId());
                employeeDTOS.add(employeeDTO);
            }

            carDTO.setEmployeeSet(employeeDTOS);
            carDTOSet.add(carDTO);
        }
        return carDTOSet;
    }

    public Set<EmployeeDTO> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<EmployeeDTO> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }
}
