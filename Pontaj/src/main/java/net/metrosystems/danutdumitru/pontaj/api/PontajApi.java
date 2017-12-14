package net.metrosystems.danutdumitru.pontaj.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.metrosystems.danutdumitru.pontaj.service.PontajService;
import net.metrosystems.danutdumitru.pontaj.domain.PontajEntry;
import net.metrosystems.danutdumitru.pontaj.service.PontajEntryDetails;

@RestController
public class PontajApi {

	@Autowired
	PontajService pontajService;
	
	@RequestMapping (path="/pontaj" , produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PontajEntryDetails> findAllDetails()
	{
		return pontajService.findAllEntries();
	}

	@RequestMapping (path="/pontaj", method = RequestMethod.POST)
	public ResponseEntity<String> createProposal(@RequestBody PontajEntry pontajEntry)
	{
		try
		{
			pontajService.createPontajEntry(pontajEntry);;
			return ResponseEntity.status(HttpStatus.CREATED)
					.body("Entry created successfully");
									
		}
		catch (Exception exc)
		{
			exc.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exc.getMessage());
		}
	}
}
