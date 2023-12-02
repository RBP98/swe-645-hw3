package com.swe645.studentSurveyForm.form.controller;

import com.swe645.studentSurveyForm.form.entity.Form;
import com.swe645.studentSurveyForm.form.service.SurveyFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class SurveyFormController {

    @Autowired
    private SurveyFormService surveyFormService;

    @RequestMapping("/form")
    public List<Form> getAllStudentForms(){
        return surveyFormService.getAllStudentForms();
    }

    @RequestMapping("/form/{id}")
    public Form getFormOfStudent(@PathVariable String id){
        return surveyFormService.getFormOfStudent(id);
    }

    @RequestMapping(method = RequestMethod.POST, value="/form")
    public void createStudentForm(@RequestBody Form form){
        surveyFormService.createStudentForm(form);
    }

    @RequestMapping(method = RequestMethod.PUT, value="/form/{id}")
    public void updateStudentForm(@RequestBody Form form, @PathVariable String id){
        surveyFormService.updateStudentForm(id, form);
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/form/{id}")
    public void deleteStudentForm(@PathVariable String id){
        surveyFormService.deleteStudentForm(id);
    }
}
