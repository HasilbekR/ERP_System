package com.example.erp_system.service;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public interface BaseService<E, D> {
    E create(D request);

    E getById(UUID id);

    List<E> getAll();
}
