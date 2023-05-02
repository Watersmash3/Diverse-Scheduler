# Diverse-Scheduler
This is an app designed to fullfill the scheduling needs of companies and people who need to schedule many people at many different places. Additionally, each place has unique requirements for those who work there. Furthermore, achieves hard and soft constraints set by the user.

# Parameters / Brainstorming

## Guards
+ Hard Limits
  + Certifications
    + Non-Screeners
    + Full-Screeners
    + Hand-Wanders
  + Clearances
    + Basic Clearance
      + SSA Offices (No Certifications)
      + IRS & ODAR (Hand-Wanders)
      + MEPS & Immigration (Full-Screeners)
    + Top Secret
      + FBI (Full-Screener)
  + Full Time vs Part Time
    + Full Time
      + Must work at least 36 hours / week
    + Part Time
      + No Limit or requirement on number of hours worked / week
+ Soft Limits
  + Time spent driving
    + Anything over 50 miles is paid
  + Distance from home
  + Preferred working shift
  + Number of days spent working per week
+ Other Information
  + Address, City, and Zip Code
  + Date Employed
  + Name
  + Age
  + Date of Birth
  + Last Four of Social Security

## Locations
+ Hours of operation
+ Geographic Location
+ Posts
  + Certification requirements
  + Start Time
  + End Time
+ Assignable Guards

## Features / Utility
+ Utilities
  + Replacing
  + Moving Guards
  + Manually Changing hours regardless of post
  + Creating Custom Shifts on a Post
+ Reports
  + Hours Worked Report
  + Actual Schedule
  + Location Sheet
  + History of Work

## Properties
The properties class is meant to hold the data type, modify a particular data set, and be able to 
know the type of data being held
### Features
+ Retrieve the data / property type
+ Retrieve the data held within the property
+ Remove the data
+ Change the data

## Guard Model
The guard model class represents a class with a series of properties that defines the guard. The 
guard will have several parameters given the hard and soft constraints of the scheduling of each 
guard. There is also pertinent information that those scheduling may need or want to know.
### Features
+ Retrieve each property
+ Change each property

## Employee Database
The employee database is a class that is going to hold all the guards data files so that the 
respective controllers can parse through the data and use the guards. You will also be able to 
modify the database
### Features
+ Select a specific guard and putting it into a variable to use
+ Loading all of the guards data / reloading the data
+ Adding a guard to the database
+ Changing a guard and a specific property
+ Removing a guard from the database