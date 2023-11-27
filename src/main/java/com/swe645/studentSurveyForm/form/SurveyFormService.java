package com.swe645.studentSurveyForm.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SurveyFormService {

    @Autowired
    private SurveyFormRepository surveyFormRepository;

    public List<Form> getAllStudentForms(){

        List<Form> forms = new ArrayList<>();
        surveyFormRepository.findAll().forEach(forms::add);
        return forms;
    }

    public Form getFormOfStudent(String id){
        return surveyFormRepository.findById(id).orElse(null);
    }

    public void createStudentForm(Form form){
        surveyFormRepository.save(form);
    }

    public void updateStudentForm(String id, Form form){
        surveyFormRepository.save(form);
    }

    public void deleteStudentForm(String id){
        surveyFormRepository.deleteById(id);
    }
}
