package net.ellshadday.app.service.user;

import net.ellshadday.app.payload.userDto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto createAddress(long userId, AddressDto addressDto);
    List<AddressDto> getUserAddressByUserId(long userId);

}
