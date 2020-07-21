# Patient Website

####The application has developed by Inteliji IDEA 2017
####Java servlet application / Maven / tomcat server 9 

#####Directoires
* **src**

    **main.java.app**
    
         ---- db 
         contains java classes for manipulating data
         here is used two kind of data source, CSV file and mySQL
         the class for CSV file, 
         first get the path based on test or development runs and reads from CSV file 
         operations are: 
         insert (/save) / fetch all data (/list) / fetch data by id (/view) / print error 
          
         ---- model
         includes patient java model class
         fields:
         id, first_name, last_name, age, birth_date
         
         ---- servlets
         includes Index class it check the path(/new, /save, /view, /list) and action (GET, POST)
         then navigate to related class and return result
         
    **resources**
    
         includes csv files and sql script
    
    **test**
    
        includes junit test and and runner

* **web**

    --- css  
   
         CDN of bootstrap.min.css     
    
    ---- js
    
    **index.html**
    
        main page
    
    **list.jsp**
    
        display list of patient - path /list
    
    **new.jsp**
    
        user can add new patient - path /new
        for save button path is /save
    
    **view.jsp**
    
        user can see patient details information - path /view 
        
      


 
