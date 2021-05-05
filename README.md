# Hotel Departments Ticketing System (HDTS)
The Hotel Departments Ticketing System manages guest request and maintenance tickets that a Front Desk agent receives and passes on to either the Housekeeping or Maintenance departments. The respective departments could then update tickets once requests or issues are resolved. In addition, the HDTS can also keep track of which rooms are occupied, what type of room it is, whether the room has been cleaned, or if it is out of service. Hotel managers have the capabilities to add, remove, and modify rooms and employees.

The HDTS consists of four applications:
1. Housekeeping Application
  - Able to change room status (Clean/Dirty), receives, and updates tickets via JMS
2. Maintenance Application (SOAP Server)
  - Able to put rooms out of order, receives and updates tickets
3. Front Desk Application (REST Server & SOAP Client)
  - Change room occupancy to check-in/check-out 
4. Manager Application
  - Ability to communicate to add, update, remove rooms
  - Able to communicate with all other applications to do their functions
