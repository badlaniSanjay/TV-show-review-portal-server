package com.example.wbdvprojectsf19javaservergroup13.controllers;

import com.example.wbdvprojectsf19javaservergroup13.models.Faculty;
import com.example.wbdvprojectsf19javaservergroup13.models.User;
import com.example.wbdvprojectsf19javaservergroup13.services.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@CrossOrigin("*")
public class FacultyController {

  @Autowired
  private FacultyService facultyService;

  @PostMapping("/registerFaculty")
  public void register(@RequestBody Faculty faculty) {
    facultyService.registerFaculty(faculty);
  }

  @GetMapping("/faculties")
  public List<Faculty> findAllFaculties(){
    return facultyService.findAllFaculties();
  }

  @GetMapping("/findFaculty/{fid}")
  public   Faculty findFacultyById(@PathVariable("fid") Integer fid){
    return facultyService.findFacultyById(fid);
  }

  @GetMapping("/findFacultyByUserId/{userId}")
  public Faculty findFacultyByUser(@PathVariable("userId") int userId){
    return facultyService.findFacultyByUser(userId);
  }
  
  
}
