package net.ellshadday.app.service.user;

import net.ellshadday.app.payload.userDto.BankAccountDto;

import java.util.List;

public interface BankAccountService {
    BankAccountDto creatBankAccount(long userId,  BankAccountDto bankAccountDto);
    List<BankAccountDto> getBankAccountByUserId(long userId);

    BankAccountDto updateBankAccount(long userId, long bankId, BankAccountDto bankAccountDto);

    void deleteComment(Long userId, Long bankId);
}
