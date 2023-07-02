package com.server.service;

import org.modelmapper.ModelMapper;

abstract public class BaseService {
    protected final ModelMapper modelMapper = new ModelMapper();
}
