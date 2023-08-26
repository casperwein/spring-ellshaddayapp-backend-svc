package net.ellshadday.app.service.user.impl;

import net.ellshadday.app.entity.user.Address;
import net.ellshadday.app.entity.user.User;
import net.ellshadday.app.exception.ResourceNotFoundException;
import net.ellshadday.app.payload.userDto.AddressDto;
import net.ellshadday.app.repository.user.AddressRepository;
import net.ellshadday.app.repository.user.UserRepository;
import net.ellshadday.app.service.user.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    private UserRepository userRepository;

    public AddressServiceImpl(AddressRepository addressRepository, UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    @Override
    public AddressDto createAddress(long userId, AddressDto addressDto) {
        Address address = mapToEntity(addressDto);

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", userId));

        address.setUser(user);

        Address newAddress = addressRepository.save(address);
        return mapToDTO(newAddress);
    }

    @Override
    public List<AddressDto> getUserAddressByUserId(long userId) {
        return null;
    }

    private AddressDto mapToDTO(Address address){
        AddressDto addressDto = new AddressDto();

        addressDto.setId(address.getId());
        addressDto.setLine(address.getLine());
        addressDto.setRt_rw(address.getRt_rw());
        addressDto.setKelurahan(address.getKelurahan());
        addressDto.setKecamatan(address.getKecamatan());
        addressDto.setProvinsi(address.getProvinsi());
        addressDto.setCountry(address.getCountry());

        return addressDto;
    }

    private Address mapToEntity(AddressDto addressDto){
        Address address = new Address();

        address.setId(addressDto.getId());
        address.setLine(addressDto.getLine());
        address.setRt_rw(addressDto.getRt_rw());
        address.setKelurahan(addressDto.getKelurahan());
        address.setKecamatan(addressDto.getKecamatan());
        address.setProvinsi(addressDto.getProvinsi());
        address.setCountry(addressDto.getCountry());

        return address;
    }
}
