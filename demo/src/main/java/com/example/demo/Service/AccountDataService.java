package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.AccountDataRepo;
import com.example.demo.entity.AccountEntity;


@Service
public class AccountDataService {

	@Autowired 
	private AccountDataRepo accountRepository;
	
	
	public void delete(Long id)
	{
		Optional<AccountEntity> accountOptional = this.accountRepository.findById(id);
		if(accountOptional.isPresent())
		{
			AccountEntity account = accountOptional.get();
			this.accountRepository.delete(account);
		}
	}
	
	public List<AccountEntity> getAllAccount()
	{
		return this.accountRepository.findAll();
	}
	
	
}
