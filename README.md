# vivid-seats

## Overview
This repo contains the solution to:

Problem: Find the Celebrity

- In a team of N people, a celebrity is known by everyone but he/she doesn't know anybody. 

## Guidelines

1. Clone this repository
2. In the root folder of this repo run the command:  ./gradlew test, and the 
application will compile and run test
3. Finally to build the app run: ./gradlew clean build

## More Info

The dto class vivid.seats.domain.dto.Person represent a real person, having his 
name and a list of his friends (the people he/she knows)

The dto class vivid.seats.domain.dto.Team represent a team with a set of persons

The class vivid.interactor.FindCelebrity is the business layer having the logic to find 
if a person is a Celebrity

In the test section is a class to check the main logic of FindCelebrity and check 
different escenarios including a team with a max of three persons where there is a celebrity 
and where there is not a celebrity.