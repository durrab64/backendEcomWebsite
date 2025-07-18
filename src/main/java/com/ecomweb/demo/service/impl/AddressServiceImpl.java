package com.ecomweb.demo.service.impl;

import com.ecomweb.demo.dto.AddressDto;
import com.ecomweb.demo.dto.Response;
import com.ecomweb.demo.entity.Address;
import com.ecomweb.demo.entity.User;
import com.ecomweb.demo.repository.AddressRepo;
import com.ecomweb.demo.service.interf.AddressService;
import com.ecomweb.demo.service.interf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepo addressRepo;
    private final UserService userService;

    @Override
    public Response saveAndUpdateAddress(AddressDto addressDto) {
        User user = userService.getLoginUser();
        Address address = user.getAddress();

        if(address == null){
          address = new Address();
          address.setUser(user);
        }

        if(addressDto.getStreet() !=null )address.setStreet(addressDto.getStreet());
        if(addressDto.getCity() !=null )address.setCity(addressDto.getCity());
        if(addressDto.getState() !=null )address.setState(addressDto.getState());
        if(addressDto.getZipCode() !=null )address.setZipCode(addressDto.getZipCode());
        if(addressDto.getCountry() !=null )address.setCountry(addressDto.getCountry());

        addressRepo.save(address);

        String message = (user.getAddress()==null) ? "Address Successfully Created" : "Address Successfully updated";
        return Response.builder()
                .status(200)
                .message(message)
                .build();
    }
}
