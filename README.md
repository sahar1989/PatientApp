# Patient Website

####The application has developed by Inteliji IDEA 2017
####Java servlet application / Maven / tomcat server 9 

#Note: for run application without InteliJi IDE and just by Tomcat server 

You can deploy the WAR file in tomcat server and run the project.
Note: you need to set the user name and password in tomcat go to path  /conf/tomcat-user.xml
put these two lines
<role rolename="manager-gui"/>
<user username="admin" password="admin" roles="manager-gui"/>

then run tomcat server -> localhost:8080/manager
then deploy the WAR file

#####Directoires
* **src**

    **main.java.app**
    
         ---- db 
         contains java classes for manipulating data
         here is used two kind of data source, CSV file and mySQL
         the class for CSV file, 
         first get the path based on test or development runs and reads from CSV file 
         in catch exception please change the absoulute path regards to your local path
         operations are: 
         insert (/save) / fetch all data (/list) / fetch data by id (/view) / print error 
          
         DataBase: PatientDB, user: Admin, password: Admin123
         
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
        
      


 
