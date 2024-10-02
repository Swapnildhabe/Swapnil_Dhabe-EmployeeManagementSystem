# Employee Management System

Employee Management System: A Spring Boot application designed to manage employee details with features such as CRUD operations, authentication, and reporting.

## Prerequisites
- Java 17 or later
- Maven 3.6+
- MySQL server

## 1. Clone the repository:
```bash
git clone https://github.com/Swapnildhabe/Swapnil_Dhabe-EmployeeManagementSystem.git
```
## Configure the Database
* Create a database named employee_db   
* Update src/main/resources/application.properties with your MySQL username and password Build the project  

## Update application properties:    

Modify the```src/main/resources/application.properties```file to include your database configuration:   

```bash
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```


## Run the Application
```bash
 mvn spring-boot:run
```

Or using the Spring Tool Suite (STS) IDE:
Import the project.   
Right-click on the project and select Run As -> Spring Boot App.  
## Create a database
For MySQL:    
   
```bash    
CREATE DATABASE employee_db;
```

## Accessing the Application    
Home Page:

```bash
http://localhost:8080
```

## Default Credentials:  
Admin:    
Username: ```swapnil```  
Password: ```1234567890```  

## API Documentation for Employee Management System
   1) Home Controller   

1.1  Get All Employees  
Endpoint: ```GET / ```  
Response:  Status: 200 OK  
Body: Renders the index view with the list of employees.  

1.2. Get Admin Home Page  
Endpoint: ```GET /admin```     
Response:Status: 200 OK  
Body: Renders the indexadmin view with the list of employees.   

1.3. Load Save Employee Page  
Endpoint: ```GET /loadempsave```  
Response:Status: 200 OK  
Body: Renders the save view for entering new employee details.   

1.4. Admin Logout  
Endpoint: ```GET /logoutadmin```  
Response:Status: 302 Found  
Redirects to: ```' / '``` (Home Page)   

1.5. Load Edit Employee Page  
Endpoint: ```GET /edit/{id}```  
Parameters:Path Variable: id (Employee ID)  
Response:Status: 200 OK  
Body: Renders the edit view for the specified employee.   

1.6. Save New Employee 
Endpoint: ```POST /saveEmp```  
Request Body:
```bash
{
"name": "Swapnil Dhabe",
  "email": "dhabe.swapnil@gmail.com",
  "address": "Hinjewadi, Pune",
  "dateOfBirth": "1996-09-10",
  "department": "IT",
  "gender": "Male",
  "password": "password123"
}
```     
Response:Status: 302 Found  
Redirects to: ```/loadempsave```  
Session Message: "Register Successfully..." or "Something wrong on server"  

1.7. Update Employee Details  
Endpoint: ```POST /updateEmp```   
Response:Status: 302 Found  
Redirects to: ```/admin```    
Session Message: "Update Successfully..." or "Something wrong on server"  

1.8. Delete Employee  
Endpoint: ```GET /deleteEmp/{id}```
Parameters:  
Path Variable: id (Employee ID)  
Response:Status: 302 Found  
Redirects to: ```/admin```
Session Message: "Delete Successfully..." or "Something wrong on server"   
 
2. LoginController  

2.1. Load Login Page 
Endpoint: ```GET /login```   
Response:
Status: 200 OK  
Body: Renders the login view for user authentication.
## Contributing

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

[MIT](https://choosealicense.com/licenses/mit/)