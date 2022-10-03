package com.stefanini.pizzariabackend.controller;

import com.stefanini.pizzariabackend.domain.Service;
import com.stefanini.pizzariabackend.service.ServiceService;
import com.stefanini.pizzariabackend.service.impl.ServiceServiceImpl;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.ACCEPTED;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestController
@RequestMapping("/api/service/")
public class ServiceController {

    private final ServiceService serviceService;

    public ServiceController(ServiceServiceImpl serviceServiceImpl) {
        this.serviceService = serviceServiceImpl;
    }

    @PostMapping("save")
    public Service saveService(@RequestBody Service service) {
        return serviceService.saveService(service);
    }

    @GetMapping("findAll")
    public List<Service> findAllServices() {
        return serviceService.findAllServices();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteServiceById(@PathVariable Long id) {
        try {
            return ResponseEntity
                    .status(ACCEPTED)
                    .body(serviceService.deleteServiceById(id));
        } catch (EmptyResultDataAccessException exception) {
            return ResponseEntity
                    .status(INTERNAL_SERVER_ERROR)
                    .body("Service with such id not found");
        }
    }
}
