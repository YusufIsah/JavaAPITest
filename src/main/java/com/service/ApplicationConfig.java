/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author Yusuf
 */
@ApplicationPath("rs")
public class ApplicationConfig extends Application{
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> resources = new HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    public void addRestResourceClasses(Set<Class<?>> resources){
        resources.add(com.service.DeptFacadeREST.class);
        resources.add(com.service.EmpFacadeREST.class);
    }
}
