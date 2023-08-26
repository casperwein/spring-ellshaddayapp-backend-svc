package net.ellshadday.app.repository.user;

import net.ellshadday.app.entity.user.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankAccountRepository extends JpaRepository <BankAccount, Long>{
    List<BankAccount>  findByUserId(long userId);
}
