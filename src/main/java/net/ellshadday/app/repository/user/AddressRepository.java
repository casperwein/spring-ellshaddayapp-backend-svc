package net.ellshadday.app.repository.user;

import net.ellshadday.app.entity.user.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long>{
    List<Address> findByUserId(long userId);

}
