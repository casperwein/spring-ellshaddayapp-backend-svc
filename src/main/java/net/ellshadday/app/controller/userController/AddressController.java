package net.ellshadday.app.controller.userController;

import net.ellshadday.app.payload.userDto.AddressDto;
import net.ellshadday.app.service.user.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("spring/api1/user/address")
public class AddressController {
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<AddressDto> createAddress(
            @PathVariable(value = "userId") long userId,
            @RequestBody AddressDto addressDto ) {

        return new ResponseEntity<>(addressService.createAddress(userId, addressDto), HttpStatus.CREATED);
    }

}
