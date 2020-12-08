package com.noteappreact.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.noteappreact.model.Notes;
import com.noteappreact.service.NotesService;




@CrossOrigin(origins="http://localhost:3001/")
@RestController
public class NotesController {


	
	@Autowired
	private NotesService notesService;

	@GetMapping("/home")
	public String viewHomePage()
	{

		return "home";

	}
	@GetMapping("/notes")
	public List<Notes> getNotes()
	{

		return this.notesService.getAllNotes();

	}
	@GetMapping("/notes/{noteId}")
	public Notes getNotebyId(@PathVariable Long noteId)
	{

		return this.notesService.getNoteById(noteId);

	}
	
	@PostMapping("/savenote")
	public Notes saveNote(@RequestBody Notes note)
	{

		
		
		
		note.setCreationTime(LocalDateTime.now());
		notesService.saveNote(note);
		return this.notesService.saveNote(note); 

	}
	
	@PutMapping("/savenote")
	public Notes updateNote(@RequestBody Notes note)
	{

		
		
		note.setCreationTime(notesService.getNoteById(note.getId()).getCreationTime());
		note.setUpdatedTime(LocalDateTime.now());
		notesService.saveNote(note);
		
		return this.notesService.saveNote(note); 

	}
	
	@DeleteMapping("notes/{noteId}")
	public ResponseEntity<HttpStatus> deleteNote(@PathVariable Long noteId)
	{
		try {
		 this.notesService.deleteNoteById(noteId);
		 return  new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
//	@GetMapping("/new/noteform/archivenote")
//	public String showNewNoteFormArchive(Model model)
//	{
//		Notes note=new Notes();
//		model.addAttribute("note",note);
//		return "new_note_archive";
//	}
//
//	@PostMapping("/savenote")
//	public String saveNote(@ModelAttribute("note") Notes note,BindingResult bindingResult)
//	{
//
//		if (bindingResult.hasErrors()) {
//			System.out.println("BINDING RESULT ERROR");
//			return "index";
//		}
//		if(note.getUserName()==null){
//
//
//			return "redirect:/home";
//
//
//
//		}
//		
//		
//		note.setCreationTime(LocalDateTime.now());
//		notesService.saveNote(note);
//		return "redirect:/home"; 
//
//	}
//	@PostMapping("/save/notearchive")
//	public String saveNoteArchive(@ModelAttribute("note") Notes note,BindingResult bindingResult)
//	{
//
//		if (bindingResult.hasErrors()) {
//			System.out.println("BINDING RESULT ERROR");
//			return "index";
//		}
//		if(note.getUserName()==null){
//
//
//			return "redirect:/home";
//
//
//
//		}
//		note.setArchiveFlag(true);
//		note.setCreationTime(LocalDateTime.now());
//		notesService.saveNote(note);
//		return "redirect:/archive"; 
//
//	}


//	@GetMapping("/updateform/{id}")
//	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
//
//		Notes note = notesService.getNoteById(id);
//
//		model.addAttribute("note", note);
//		return "update_note";
//	}
//	@PostMapping("/update/note")
//	public String updateNote(@ModelAttribute("note") Notes note)
//	{
//		note.setCreationTime(notesService.getNoteById(note.getId()).getCreationTime());
//		note.setUpdatedTime(LocalDateTime.now());
//		notesService.saveNote(note);
//		return "redirect:/home"; 
//	}
//	@GetMapping("/softdelete/note/{id}")
//	public String softDeleteNote(@PathVariable(value = "id") Long id)
//	{
//		this.notesService.softDeleteNoteById(id);
//		return "redirect:/home";
//	}
//	@GetMapping("delete/note/{id}")
//	public String deleteNote(@PathVariable(value = "id") Long id)
//	{
//		this.notesService.deleteNoteById(id);
//		return "redirect:/recycleBin";
//	}
//	@GetMapping("restore/{id}")
//	public String restoreNote(@PathVariable(value = "id") Long id)
//	{
//		this.notesService.restoreById(id);
//		return "redirect:/recycleBin";
//	}
//
//	
//	@GetMapping("/recycleBin")
//	public String viewRecycleBinPage(Model model)
//	{
//		model.addAttribute("listNotes", notesService.getRecycleBinNotes());
//		return "recycle_bin";
//	}
//
//	@GetMapping("/archive")
//	public String viewArchivePage(Model model)
//	{
//		model.addAttribute("listNotes", notesService.getArchiveNotes());
//		return "archive_list";
//	}
//	@GetMapping("/archive/note/{id}")
//	public String archiveNote(@PathVariable(value = "id") Long id)
//	{
//		this.notesService.archiveNoteById(id);
//		return "redirect:/home";
//	}
//	@GetMapping("/archive/restore/{id}")
//	public String restoreArchiveNote(@PathVariable(value = "id") Long id)
//	{
//		this.notesService.restoreArchiveById(id);
//		return "redirect:/archive";
//	}
	

}

