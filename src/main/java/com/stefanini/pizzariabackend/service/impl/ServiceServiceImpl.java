package com.stefanini.pizzariabackend.service.impl;

import com.stefanini.pizzariabackend.domain.Service;
import com.stefanini.pizzariabackend.repo.ServiceRepository;
import com.stefanini.pizzariabackend.service.ServiceService;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    private final ServiceRepository serviceRepository;

    public ServiceServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }


    @Override
    public Service saveService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<Service> findAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public Long deleteServiceById(Long id) {
        serviceRepository.deleteById(id);
        return id;
    }
}
