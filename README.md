# com.db.spring.demo
 Spring boot demo for Deutsche Bank grads July 2021 

data to be inserted 
{  
    "id": "101",  
    "name": "Sonu",  
    "salary": 10.5   
}  

{  
    "id": "102",  
    "name": "Monu",  
    "salary": 10.6   
}  

{  
    "id": "103",  
    "name": "Tonu",  
    "salary": 10.7   
}  

{  
    "id": "104",  
    "name": "Gonu",  
    "salary": 10.8   
}  

1. Create - POST 
---------------- 

Open the Postman and do the following:

Select the POST
Invoke the URL http://localhost:8084/Employee
Select the Body
Select the Content-Type JSON (application/json).
Insert the data in the Body:
{  
    "id": "101",  
    "name": "Sonu",  
    "salary": 10.5 
}  

Click on Send

When the request is successfully executed, it shows the Status:200 OK. 
It means the record has been successfully inserted in the database.

Insert more data. 

1.1 Verify the data 

Open the H2 console to see the data.

Open the browser and invoke the URL http://localhost:8084/h2-console

Click on the Connect button 

write 

select * from employee; 

and run selected. 

Output 
<emp data>

2. Retrieve - GET 
-----------------

Open the Postman and send a GET request with the URL http://localhost:8084/Employee 
Output 
<emp data>

2.1 GET - Specified data 

Send a GET request with the URL http://localhost:8084/Employee/{id}

id=101


3. Delete - DELETE 
------------------ 

Select the DELETE method and invoke the URL http://localhost:8084/Employee/103

Execute the Select query in the H2 console. 

write select * from employee; 
and run selected. 

Output 
<emp data>


4. Update - PUT 
--------------- 

Select the PUT and invoke the URL http://localhost:8084/Employee

In the request body, paste the record to update. 

{  
    "id": "101",  
    "name": "Sonu",  
    "salary": 20.5   
}  

Click on the Send

Execute the Select query in the H2 console. 

write select * from employee; 
and run selected. 

Output 
<emp data> 

