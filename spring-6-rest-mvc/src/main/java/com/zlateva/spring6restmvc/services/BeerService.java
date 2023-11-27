package com.zlateva.spring6restmvc.services;

import com.zlateva.spring6restmvc.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
