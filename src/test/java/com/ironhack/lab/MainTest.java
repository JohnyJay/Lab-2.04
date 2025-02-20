package com.ironhack.lab;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
class MainTest {
    Person p;
    Person b;
    PersonsList pL;

    @BeforeEach
    void setUp(){
        p = new Person(123,"John Doe",23,"Driver");
        b = new Person(456,"Jane Doe",24,"Pilot");
        List<Person> a = new ArrayList<>();
        a.add(p);
        a.add(b);
        pL = new PersonsList(a);
    }

    @Test
    void setAge_negativeParameter_throws(){
        assertThrows(IllegalArgumentException.class,()->p.setAge(-5));
    }

    @Test
    void findByName_formattedParam_works(){
        assertEquals("Jane Doe",pL.findByName("Jane Doe").getName());
        assertEquals("John Doe",pL.findByName("John Doe").getName());

    }

    @Test
    void findByName_unformattedParam_throws(){
        assertThrows(IllegalArgumentException.class, ()-> pL.findByName("JaneDoe"));
    }

    @Test
    void clone_correctParam_works(){
        p = pL.clone(b);
        assertEquals(b,p);
        assertNotEquals(b.getId(),p.getId());
    }



}