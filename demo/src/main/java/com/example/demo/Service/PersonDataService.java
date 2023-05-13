package com.example.demo.Service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.Dao.PersonDataRepo;
import com.example.demo.entity.AccountEntity;
import com.example.demo.entity.PersonEntity;



@Service
public class PersonDataService {
	
	@Autowired
	private PersonDataRepo mPersonDataRepo;
	
	@Transactional
	public void createPerson(PersonEntity pPerson , List<AccountEntity> pAccounts)
	{
		for(AccountEntity account:pAccounts)
		{
			account.setPerson(pPerson);
		}
		
		mPersonDataRepo.save(pPerson);
	}
	
	
	public PersonEntity getPerson(Long id)
	{
		Optional<PersonEntity> personOptional = mPersonDataRepo.findById(id);
		PersonEntity person = personOptional.get();
		return person;
	}
	
	public List<PersonEntity> getAllPerson()
	{
		return mPersonDataRepo.findAll();
	}
	
	
	public void delete(Long personId)
	{
		Optional<PersonEntity> personOptional = this.mPersonDataRepo.findById(personId);
		if(personOptional.isPresent()) {
			PersonEntity person = personOptional.get();
			this.mPersonDataRepo.delete(person);
		}
	}
		public List<PersonEntity> getAllPersonByName(String name)
		{
			return this.mPersonDataRepo.findByName(name);
		}
		
		@Transactional
		public void updatePerson(PersonEntity person, HibernateTemplate hibernateTemplate)
		{
			hibernateTemplate.update(person);
		}
		
	}


