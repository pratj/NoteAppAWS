package com.noteappreact.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.noteappreact.model.Notes;



@Repository
public interface NotesRepository extends JpaRepository<Notes,Long>{
	@Override
	@Query("select e from #{#entityName} e where e.deleteFlag=false and e.archiveFlag=false ORDER BY creation_time   DESC")
	public List<Notes> findAll(); //COALESCE(updated_time, 2021-11-11 16:57:42)
	
	@Query("select e from #{#entityName} e where e.deleteFlag=true")
	public List<Notes> recycleBin(); 

	//Soft delete.
	//@Query("update #{#entityName} e set e.deleteFlag=true where e.id=?1")
	//@Modifying
		//public void softDelete(int id); 
	//@Query(value="SET SQL_SAFE_UPDATES = 0;",nativeQuery = true)
	@Query(value="update notespringdb.notes set delete_flag=true where id=?1",nativeQuery = true)
	@Modifying
	public void softDelete(Long id);
	
	@Query(value="update notespringdb.notes set delete_flag=false where id=?1",nativeQuery = true)
	@Modifying
	public void restoreById(Long id);
	
	@Query(value="update notespringdb.notes set archive_flag=true where id=?1",nativeQuery = true)
	@Modifying
	public void archiveNote(Long id);
	
	@Query(value="update notespringdb.notes set archive_flag=false where id=?1",nativeQuery = true)
	@Modifying
	public void restoreArchiveById(Long id);
	
//	@Query("select e from #{#entityName} e where (e.userName like %?1% and e.deleteFlag=false)"
//			+"or (e.notes like %?1% and e.deleteFlag=false)")		
	@Query("select e from #{#entityName} e where CONCAT(e.userName, e.notes) like %?1% and e.deleteFlag=false")
			
	public List<Notes> findAll(String keyword);
	
	@Query("select e from #{#entityName} e where e.archiveFlag=true")
	public List<Notes> archive();
	
	
	@Query("update #{#entityName} e set e.archiveFlag=false where e.id=?1")
	@Modifying
	public void softArchive(Long id); 

}

