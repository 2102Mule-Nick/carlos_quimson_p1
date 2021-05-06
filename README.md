# Hotel Departments Ticketing System (HDTS)
The Hotel Departments Ticketing System manages guest request and maintenance tickets that a Front Desk agent receives and passes on to either the Housekeeping or Maintenance departments. The respective departments could then update tickets once requests or issues are resolved. In addition, the HDTS can also keep track of which rooms are occupied, what type of room it is, whether the room has been cleaned, or if it is out of service. Hotel managers have the capabilities to add, remove, and modify rooms and employees.

## Technologies Used
1. Java
2. JDBC
3. SQL
4. Spring Framework
5. JMS
6. REST
7. SOAP
8. JTA

## Features 
### The HDTS consists of four applications:
1. Housekeeping Application
    - Able to change room status (Clean/Dirty), receives, and updates tickets via JMS
2. Maintenance Application (SOAP Server)
    - Able to put rooms out of order, receives and updates tickets
3. Front Desk Application (REST Server & SOAP Client)
    - Change room occupancy to check-in/check-out 
4. Manager Application
    - Ability to communicate to add, update, remove rooms
    - Able to communicate with all other applications to do their functions

#### To-do list:
- Implement testing using JUnit and Mockito
- Implement logging using Spring AOP

## Getting Started
#### Copy the repo by executing the command: 
    `git clone https://github.com/2102Mule-Nick/carlos_quimson_p1.git`
    
#### Database Setup
    For the database, execute the script that's included in the repo to create the database tables required
    
#### Running the application
    1. There must be an ActiveMQ Server running for the JMS Service
    2. The Front Desk, Manager, and Maintenance applications should be running on a server
        - For my personal use, I've used the Tomcat Server included in Spring Tool Suites
    3. Use Advanced Rest Client to access the endpoints. Sample inputs are available below

```
POST: http://localhost:8080/P1_Manager/rest/room/
Room: 
{
  "roomNumber": 601,
  "roomType": "NEDD",
  "roomStatus": "Dirty",
  "roomOccupied": false,
  "roomOutOfService": false
}
```

```
POST: http://localhost:8080/P1_Manager/rest/ticket/housekeeping

Ticket: {"roomNumber":601,"department":"Housekeeping","request":"Need toothpaste and extra towels","resolved":false}

PUT: {
  "ticketNumber":16,
  "roomNumber": 601,
  "department": "Housekeeping",
  "request": "toothpaste and towels given to guests",
  "resolved": true
}
```

```
POST: http://localhost:8080/P1_Manager/rest/ticket/maintenance
{
 "ticketNumber": ,
  "roomNumber": 601,
  "department": "Maintenance",
  "request": "in-room fridge not working",
  "resolved": false
}
```
