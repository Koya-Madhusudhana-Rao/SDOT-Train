// MINIMUM FUEL COST TO REPORT TO THE CAPITAL
// There is a tree (i.e., a connected, undirected graph with no cycles) structure 
// country network consisting of n cities numbered from 0 to n - 1 and exactly n - 1 roads.
// The capital city is city 0. You are given a 2D integer array roads where roads[i] = [ai, bi] denotes that there exists a bidirectional road connecting cities ai and bi.
// There is a meeting for the representatives of each city. The meeting is in the capital city.
// There is a car in each city. You are given an integer seats that indicates the number of seats in each car.
// A representative can use the car in their city to travel or change the car and ride with another representative. 
// The cost of traveling between two cities is one liter of fuel.

// Return the minimum number of liters of fuel to reach the capital city.
// Input
// 1st Line, Enter the roads (format: 'from1 to1 , from2 to2,...')
// 2nd Line, Enter the number of seats
// Output
// Minimum fuel cost
// Example
// Input:

// 3 1,3 2,1 0,0 4,0 5,4 6
// 2
// Output:

// 7


//8


import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static long TotalCost = 0;
    private static int Seats;

    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);

        String[] roadsInput = scanner.nextLine().split(",");
        int[][] roads = new int[roadsInput.length][2];
        for (int i = 0; i < roadsInput.length; i++) {
            String[] roadNodes = roadsInput[i].trim().split(" ");
            roads[i][0] = Integer.parseInt(roadNodes[0]);
            roads[i][1] = Integer.parseInt(roadNodes[1]);
        }

        int seats = scanner.nextInt();

        System.out.println(minimumFuelCost(roads, seats));
    }

    public static long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 1) {
            return 0;
        }

        Helper[] roadsMap = new Helper[roads.length + 1];

        for (int i = 0; i < roads.length + 1; i++) {
            roadsMap[i] = new Helper(i);
        }

        for (int i = 0; i < roads.length; i++) {
            int c1 = roads[i][0];
            int c2 = roads[i][1];
            roadsMap[c1].size++;
            roadsMap[c2].size++;
        }

        for (int i = 0; i < roads.length + 1; i++) {
            roadsMap[i].configurations();
        }

        for (int i = 0; i < roads.length; i++) {
            int c1 = roads[i][0];
            int c2 = roads[i][1];
            roadsMap[c1].add(c2);
            roadsMap[c2].add(c1);
        }

        TotalCost = 0;
        Seats = seats;
        int c = calculate(roadsMap, 0, 0);
        removeCost(c, seats);
        TotalCost = Math.max(0, TotalCost);
        return TotalCost;
    }

    private static int calculate(Helper[] roads, int parent, int current) {
        int[] nexts = roads[current].nexts;
        if (nexts.length == 1 && current != 0) {
            addCost(1, Seats);
            return 1;
        } else {
            int value = 1;
            for (int i = 0; i < nexts.length; i++) {
                if (nexts[i] != parent) {
                    value += calculate(roads, current, nexts[i]);
                }
            }
            addCost(value, Seats);
            return value;
        }
    }

    private static void addCost(int travellers, int maxSeats) {
        int n = (travellers + maxSeats - 1) / maxSeats;
        TotalCost += n;
    }

    private static void removeCost(int travellers, int maxSeats) {
        int n = (travellers + maxSeats - 1) / maxSeats;
        TotalCost -= n;
    }

    private static class Helper {
        private int value;
        private int[] nexts;
        private int size;
        private int current;

        public Helper(int value) {
            this.value = value;
        }

        public void configurations() {
            nexts = new int[size];
        }

        public void add(int v) {
            nexts[current] = v;
            current++;
        }
    }
}