package com.company.inheritanceinterfaces;

import java.util.ArrayList;

public class JuniorDeveloper implements Developer{
    int programmingLanguages;
    boolean universityDegree;
    int yearsOfExperience;
    boolean versionControl;
    boolean java;

    public JuniorDeveloper() {

    }

    public JuniorDeveloper(int languages, boolean degree, int experience, boolean git) {
        this.programmingLanguages = languages;
        this.universityDegree = degree;
        this.yearsOfExperience = experience;
        this.versionControl = git;
    }

    @Override
    public int programmingLanguages() {
        return programmingLanguages;
    }

    @Override
    public boolean universityDegree() {
        return universityDegree;
    }

    @Override
    public int yearsOfExperience() {
        return yearsOfExperience;
    }

    @Override
    public boolean versionControl() {
        return versionControl;
    }

    public void java(boolean java){
        this.java = java;
    }

}
