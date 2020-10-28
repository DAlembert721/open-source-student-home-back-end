package com.acme.studenthome.controller.PropertiesSystemController;

import com.acme.studenthome.domain.model.PropertiesSystem.Service;
import com.acme.studenthome.domain.service.PropertiesSystemService.ServiceService;
import com.acme.studenthome.resource.PropertiesSystemResource.ServiceResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ServicesController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ServiceService serviceService;

    @Operation(summary = "Get All Services", description = "Get all available services", tags = "services")
    @GetMapping("/services")
    public Page<ServiceResource>getAllServices(Pageable pageable) {
        List<ServiceResource> services = serviceService.getAllService(pageable)
                .getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(services, pageable, services.size());
    }

    @Operation(summary = "Get Services By Property", description = "Get services associated to given property", tags = "properties")
    @GetMapping("/properties/{propertyId}/services")
    public Page<ServiceResource> getAllServiceByPropertyId(
            @PathVariable(name = "propertyId") Long propertyId
            , Pageable pageable) {
        List<ServiceResource> services = serviceService.getAllServicesByPropertyId(propertyId, pageable)
                .getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());
        return new PageImpl<>(services, pageable, services.size());
    }

    @Operation(summary = "Get Services By Id", description = "Get service for a given Id", tags = "services")
    @GetMapping("/services/{serviceId}")
    public ServiceResource getServiceById(@PathVariable(name = "serviceId") Long serviceId) {
        return convertToResource(serviceService.getServiceById(serviceId));
    }

    private ServiceResource convertToResource(Service entity) {
        return mapper.map(entity, ServiceResource.class);
    }
}