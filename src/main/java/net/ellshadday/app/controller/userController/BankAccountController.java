package net.ellshadday.app.controller.userController;

import net.ellshadday.app.payload.userDto.BankAccountDto;
import net.ellshadday.app.service.user.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("spring/api1/user/bank-account")
public class BankAccountController {
    private BankAccountService bankAccountService;

    public BankAccountController(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @PostMapping("/create/{userId}")
    public ResponseEntity<BankAccountDto> createBankAccount(
            @PathVariable(value = "userId") long userId,
            @RequestBody BankAccountDto bankAccountDto){
        return new ResponseEntity<>(bankAccountService.creatBankAccount(userId, bankAccountDto), HttpStatus.CREATED);
    }

    @GetMapping("users/{userId}")
    public List<BankAccountDto> getBankAccountByUserId(@PathVariable(value = "userId") long userId){
        System.out.println(bankAccountService.getBankAccountByUserId(userId));
        return bankAccountService.getBankAccountByUserId(userId);
    }

    @PutMapping("/{userId}/update/{bankId}")
    public  ResponseEntity<BankAccountDto> updateBankAccount(@PathVariable(value = "userId") Long userId,
                                                             @PathVariable(value = "bankId") Long bankId,
                                                             @RequestBody BankAccountDto bankAccountDto){
        BankAccountDto updateBankAccount = bankAccountService.updateBankAccount(userId, bankId, bankAccountDto);
        return  new ResponseEntity<>(updateBankAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}/delete/{bankId}")
    public ResponseEntity<String> deleteBankAccount(@PathVariable(value = "userId") Long userId,
                                                    @PathVariable(value = "bankId") Long bankId){
        bankAccountService.deleteComment(userId, bankId);
        return new ResponseEntity<>("Bank Account deleted successfully", HttpStatus.OK);
    }
}
