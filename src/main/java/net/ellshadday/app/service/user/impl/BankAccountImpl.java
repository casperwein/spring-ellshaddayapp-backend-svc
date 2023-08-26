package net.ellshadday.app.service.user.impl;

import net.ellshadday.app.entity.user.BankAccount;
import net.ellshadday.app.entity.user.User;
import net.ellshadday.app.exception.APIException;
import net.ellshadday.app.exception.ResourceNotFoundException;
import net.ellshadday.app.payload.userDto.BankAccountDto;
import net.ellshadday.app.repository.user.BankAccountRepository;
import net.ellshadday.app.repository.user.UserRepository;
import net.ellshadday.app.service.user.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAccountImpl implements BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private UserRepository userRepository;

    public BankAccountImpl(BankAccountRepository bankAccountRepository, UserRepository userRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BankAccountDto creatBankAccount(long userId, BankAccountDto bankAccountDto) {
        BankAccount bankAccount = mapToEntity(bankAccountDto);

        // retrieve userId by id
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", userId));

        // ser post to comment to entity
        bankAccount.setUser(user);

        // save comment entity into database;
        BankAccount newBankAccount = bankAccountRepository.save(bankAccount);
        return mapToDTO(newBankAccount);
    }

    @Override
    public List<BankAccountDto> getBankAccountByUserId(long userId) {
        // retrieve bankaccounts by user id
        List<BankAccount> bankAccounts = bankAccountRepository.findByUserId(userId);
        System.out.println(bankAccounts);

        return bankAccounts.stream().map(bankAccount -> mapToDTO(bankAccount)).collect(Collectors.toList());
    }

    @Override
    public BankAccountDto updateBankAccount(long userId, long bankId, BankAccountDto bankAccountDto) {
        // retrieve userId by id
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", userId));

        // get bank acount by id
        BankAccount bankAccount = bankAccountRepository.findById(bankId).orElseThrow(
                () -> new ResourceNotFoundException("BankAccount", "id", bankId));

        bankAccount.setNamaBank(bankAccountDto.getNamaBank());
        bankAccount.setNama(bankAccountDto.getNama());
        bankAccount.setNomor(bankAccountDto.getNomor());
        bankAccount.setKodeBank(bankAccountDto.getKodeBank());

        BankAccount updateBankAccount = bankAccountRepository.save(bankAccount);

        return mapToDTO(updateBankAccount);
    }

    @Override
    public void deleteComment(Long userId, Long bankId) {
        // retrieve userId by id
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new ResourceNotFoundException("User", "id", userId));

        // get bank acount by id
        BankAccount bankAccount = bankAccountRepository.findById(bankId).orElseThrow(
                () -> new ResourceNotFoundException("BankAccount", "id", bankId));

        if(bankAccount.getUser().getId() != user.getId()){
            throw new APIException(HttpStatus.BAD_REQUEST, "Bank Account does not belongs to user");
        }

        bankAccountRepository.delete(bankAccount);
    }

    private BankAccountDto mapToDTO(BankAccount bankAccount){
        BankAccountDto bankAccountDto = new BankAccountDto();

        bankAccountDto.setId(bankAccount.getId());
        bankAccountDto.setKodeBank(bankAccount.getKodeBank());
        bankAccountDto.setNama(bankAccount.getNama());
        bankAccountDto.setNomor(bankAccount.getNomor());
        bankAccountDto.setNamaBank(bankAccount.getNamaBank());

        return bankAccountDto;
    }

    private BankAccount mapToEntity(BankAccountDto bankAccountDto){
        BankAccount bankAccount = new BankAccount();
        bankAccount.setId(bankAccountDto.getId());
        bankAccount.setNama(bankAccountDto.getNama());
        bankAccount.setKodeBank(bankAccountDto.getKodeBank());
        bankAccount.setNomor(bankAccountDto.getNomor());
        bankAccount.setNamaBank(bankAccountDto.getNamaBank());
        return bankAccount;
    }
}
