package net.metrosystems.danutdumitru.pontaj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import net.metrosystems.danutdumitru.pontaj.domain.PontajEntry;

public interface PontajRepository extends CrudRepository<PontajEntry, Long>{

	//get all entries
	@Query(value="select id, to_char(date_start, 'YYYY-MM-DD HH24:MI:SS') as date_start, \r\n" + 
			"	to_char(date_end, 'YYYY-MM-DD HH24:MI:SS') as date_end\r\n" + 
			"	from pontaj.pontaj_entry order by date_start", nativeQuery=true)
	public List<PontajEntry> getAllEntriesOrdered();
}
