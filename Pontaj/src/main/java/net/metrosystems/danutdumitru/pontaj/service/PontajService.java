package net.metrosystems.danutdumitru.pontaj.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.metrosystems.danutdumitru.pontaj.domain.PontajEntry;
import net.metrosystems.danutdumitru.pontaj.repository.PontajRepository;

@Service
public class PontajService {


	@Autowired
	private PontajRepository pontajRepository;
	
	public List<PontajEntryDetails> findAllEntries()
	{
		List<PontajEntryDetails> lstPontaj = new ArrayList<>();
		pontajRepository.findAll() //.getAllEntriesOrdered()
			.forEach(t -> lstPontaj.add(new PontajEntryDetails(t)));
		
		return lstPontaj;
	}

	public void createPontajEntry (PontajEntry pontajEntry)
	{
		pontajRepository.save(pontajEntry);
	}
}
