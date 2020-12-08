package com.noteappreact.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.noteappreact.model.Notes;

public interface NotesService {
	List<Notes> getAllNotes();
	Notes saveNote(Notes note);
	Notes getNoteById(Long id);
	void softDeleteNoteById(Long id);
	List<Notes> getRecycleBinNotes();
	void deleteNoteById(Long id);
	void restoreById(Long id);
	Page<Notes> findPaginated(int pageNo, int pageSize);
	List<Notes> search(String keyword);
	List<Notes> getArchiveNotes();
	void archiveNoteById(Long id);
	void restoreArchiveById(Long id);
}
