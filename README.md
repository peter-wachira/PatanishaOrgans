# PatanishaOrgans
#### PatanishaOrgans, April 28th 2019
#### By **Peter Wachira**
![]()
![]()
## Description

```bash

 A web application built using java and java-spark framework.
 The inspiration behind the project is to speed up the process of linking organ donors to organ recipients. 
 
```


[![forthebadge](https://forthebadge.com/images/badges/powered-by-electricity.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/uses-html.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/uses-css.svg)](https://forthebadge.com)


## TOC

- [Installation](#Installation)
- [Live Demo](#Requirements)
- [SQL](#SQL)
- [Tests](#Tests)
- [Requirements](#Requirements)
- [Known Bugs](#Requirements)
- [Extras](#extras)


## Installation
* `git clone <https://github.com/peter-wachira/PatanishaOrgans.git>` this repository
* `cd PatanishaOrgans`

## Tests

- To run test, run files under tests/java package for DatabaseRule, Doctor, Receipient Donor tests 

## SQL
```bash
1.Launch postgres

2.Type in psql

Run these commands:

3. CREATE DATABASE patanisha_organs;

4. \c PatanishaOrgans;

5.CREATE TABLE donor(id serial PRIMARY KEY, name varchar, bloodgroup varchar, organ varchar, doctorid int);

6.CREATE TABLE recepients (id serial PRIMARY KEY, name varchar,  bloodgroup varchar, organ varchar, doctorid varchar);

7.CREATE TABLE doctor(id serial PRIMARY KEY, name varchar, hospital varchar, contact varchar);

```


## Live Demo
To view the page click on the link below
 [https://whispering-bastion-65831.herokuapp.com/](*)


## Requirements

```bash
The applications allow users to do the following:
1. Register users with their medical, Update and Delete a donor
2. Donor Selects an organ they want to donate
3. Donor Selects a doctor to oversee.
4. Register, Update and Delete a receipient  
5. Receipient can select the organ they want 
5. Register, Update and Delete  a doctor
6. Users can view frequently asked questions
7. Users can view Additional resources and related links 
8. Contacts page
```

## Known Bugs
- Quick note that The page loads a bit slow due to the hosting, kindly be a little patient everything works just fine.
- There are currently no tests done for this project
- As at the time this project was made, responsiveness was not a major concern 
- The project is currently not being maintained any more 
- Thanks for understanding.


## Extras

- This project is no longer maintained. But if you want to contribute reach out o me via the details below 


## Contact Details
```bash
You can contact me at pwachira900@gmail.com
```

## License
- This project is licensed under the MIT Open Source license Copyright (c) 2019. [LICENCE](https://github.com/peter-wachira/PatanishaOrgans/blob/master/LICENCE)

[![forthebadge](https://forthebadge.com/images/badges/makes-people-smile.svg)](https://forthebadge.com)
