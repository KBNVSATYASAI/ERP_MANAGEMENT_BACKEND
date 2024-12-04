package com.example.ERP_MANAGEMENT.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP_MANAGEMENT.Repository.BusRepository;
import com.example.ERP_MANAGEMENT.models.Bus;

@Service
public class BusService {

    @Autowired
    private BusRepository busesRepository;

    public Bus addBus(Bus bus) {
        return busesRepository.save(bus);
    }

    public List<Bus> getAllBuses() {
        return busesRepository.findAll();
    }

    public Optional<Bus> getBusById(Long id) {
        return busesRepository.findById(id);
    }

    public Bus updateBus(Long id, Bus updatedBus) {
        return busesRepository.findById(id).map(bus -> {
            bus.setBusNumber(updatedBus.getBusNumber());
            bus.setDriverName(updatedBus.getDriverName());
            bus.setDriverLicense(updatedBus.getDriverLicense());
            bus.setMobileNumber(updatedBus.getMobileNumber());
            bus.setRoute(updatedBus.getRoute());
            bus.setVillages(updatedBus.getVillages());
            return busesRepository.save(bus);
        }).orElseThrow(() -> new RuntimeException("Bus not found"));
    }

    public void deleteBus(Long id) {
        busesRepository.deleteById(id);
    }
}
