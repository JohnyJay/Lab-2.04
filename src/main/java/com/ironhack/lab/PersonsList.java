package com.ironhack.lab;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonsList {
    private List<Person> pList = new ArrayList<>();

    public PersonsList(List<Person> pList) {
        this.pList = pList;
    }

    public List<Person> getpList() {
        return pList;
    }

    public void setpList(List<Person> pList) {
        this.pList = pList;
    }

    public Person findByName(String name){
        String[] values = name.split(" ");
        Person candidate = new Person(1,"1",1,"1");
        if(values.length==2){
            for (Person subject : pList){
                if(subject.getName().equals(name)) candidate=subject;
            }
        }else{
            throw new IllegalArgumentException("Name is not formatted properly.");
        }
        return candidate;
    }

    public Person clone(Person p){
        return new Person(p.getId()+1,p.getName(),p.getAge(),p.getOccupation());
    }

    public void personStringToFile(Person p){
        FileWriter writer = null;
        try {
            writer = new FileWriter("InfoFile.txt",true);
            writer.write(p.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Problem with opening the File.");
        }
    }
}
