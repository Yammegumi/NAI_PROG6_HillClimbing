# NAI_PROG6_HillClimbing
This is a simple Java program to solve the Traveling Salesman Problem (TSP) using the hill climbing algorithm created for PJATK NAI lessons

## Description

The Traveling Salesman Problem (TSP) is a classic algorithmic problem in the field of computer science and operations research. It focuses on optimization. In this problem, a salesman is given a list of cities, and must determine the shortest route that allows him to visit each city once and return to his original location.

The program uses a simple hill climbing algorithm to find a solution to the TSP. It begins with a random tour (a sequence of cities), and then iteratively improves the tour by swapping pairs of cities. If a swap results in a shorter tour, it is accepted. This process continues until no beneficial swaps can be found.

## Classes and Methods

The solution is divided into two classes: Main and TravelingSalesman.

### TravelingSalesman
This class contains the following methods:
- loadFile(String filename): This method reads in a file that contains the number of cities and a matrix of distances between each pair of cities.
- solveProblem(): This method uses a simple hill climbing algorithm to find a solution to the TSP.
- calculateTourDistance(List<Integer> tour): This method calculates the total distance of a tour.

### Main
The main class of the program, which invokes methods from the TravelingSalesman class to solve the problem.

## File Format
The input file should be in the following format: <br>
n <br>
v1 v2 d <br>
v1 v3 d <br>
... <br> 
vn-1 vn d <br>

Where n is the number of cities, and the following lines each contain three integers: v1 and v2 are the city indices and d is the distance between them.

## Installation
The program doesn't require any additional libraries. It can be compiled and run using any Java SE Development Kit (JDK) version 8 or later.

## Usage

Prepare an input file with the format as described above. <br>

### Compile both Java files using java: <br>
<code> java TravelingSalesman.java </code> <br>
<code> java Main.java </code> <br>

### Run the program, passing the input file name as an argument: <br>
<code>java Main input.txt </code> 

The program will display the sequence of visited cities in the best found tour and the total distance of this tour. These details are updated and displayed during the execution of the program, in each iteration, when a shorter route is found.