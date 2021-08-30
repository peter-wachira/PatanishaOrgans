# PatanishaOrgans
#### PatanishaOrgans, April 28th 2019
#### By **Peter Wachira**
![]()
![]()
## Description

```bash
 A web application built using java and java-spark framework that aims at speeding up the process of linking organ donors to organ recipients. 
```
## Technologies Used
[![forthebadge](https://forthebadge.com/images/badges/powered-by-electricity.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/uses-html.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/uses-css.svg)](https://forthebadge.com)

## Installation
* `git clone <https://github.com/peter-wachira/PatanishaOrgans.git>` this repository
* `cd PatanishaOrgans`

## SQL
```bash
1.Launch postgres
2.Type in psql
Run these commands
3. CREATE DATABASE patanisha_organs;
4. \c PatanishaOrgans;
5.CREATE TABLE donor(id serial PRIMARY KEY, name varchar, bloodgroup varchar, organ varchar, doctorid int);
6.CREATE TABLE recepients (id serial PRIMARY KEY, name varchar,  bloodgroup varchar, organ varchar, doctorid varchar);
7.CREATE TABLE doctor(id serial PRIMARY KEY, name varchar, hospital varchar, contact varchar);
```
## User Requirements
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

## Contact Details
```bash
You can contact me at pwachira900@gmail.com
```

## License
- This project is licensed under the MIT Open Source license Copyright (c) 2019. [LICENCE](https://github.com/peter-wachira/PatanishaOrgans/blob/master/LICENCE)

[![forthebadge](https://forthebadge.com/images/badges/fuck-it-ship-it.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/makes-people-smile.svg)](https://forthebadge.com)
