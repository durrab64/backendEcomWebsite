package com.ecomweb.demo.service.interf;

import com.ecomweb.demo.dto.AddressDto;
import com.ecomweb.demo.dto.Response;

public interface AddressService {
    Response saveAndUpdateAddress(AddressDto addressDto);
}
