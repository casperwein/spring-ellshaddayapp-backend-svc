package net.ellshadday.app.repository.user;

import net.ellshadday.app.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
