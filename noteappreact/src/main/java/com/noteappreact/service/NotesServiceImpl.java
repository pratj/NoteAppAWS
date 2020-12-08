package com.noteappreact.service;



import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.noteappreact.model.Notes;
import com.noteappreact.repository.NotesRepository;


@Service
public class NotesServiceImpl implements NotesService{
@Autowired
private NotesRepository notesRepository;

public List<Notes> getAllNotes()
{
	
	return notesRepository.findAll(Sort.by("userName").descending());
}
public List<Notes> getRecycleBinNotes()
{
	return notesRepository.recycleBin();
}

@Override
public Notes saveNote(Notes note) {
	
	return this.notesRepository.save(note);
	
}

@Override
public Notes getNoteById(Long id) {
	Optional<Notes> optional = notesRepository.findById(id);
	Notes note=null;
	if(optional.isPresent())
	{
		note = optional.get();
	}
	else
	{
		throw new RuntimeException("Your Note Does Not Exist for "+id+". PLease Create One!");
	}
	return note;
}

@Transactional
public void softDeleteNoteById(Long id) {
	
	this.notesRepository.softDelete(id);
	
}
@Transactional
public void archiveNoteById(Long id) {
	
	this.notesRepository.archiveNote(id);
	
}
public void deleteNoteById(Long id) {
	this.notesRepository.deleteById(id);
}
@Transactional
public void restoreById(Long id) {
	this.notesRepository.restoreById(id);
}
@Transactional
public void restoreArchiveById(Long id) {
	this.notesRepository.restoreArchiveById(id);
}
@Override
public Page<Notes> findPaginated(int pageNo, int pageSize) {
	Pageable pageable=PageRequest.of(pageNo-1, pageSize);
	
	return this.notesRepository.findAll(pageable);
}

public List<Notes> search(String keyword)
{
	if(keyword!=null)
		return notesRepository.findAll(keyword);
	else 
		return notesRepository.findAll();
}
@Override
public List<Notes> getArchiveNotes() {
	
	return notesRepository.archive();
}

}

