package com.company;


// this needs to be directed because flights only go one way. one plane cant go to and from berlin at once (forget super position this aint q-bit)


import java.util.ArrayList;

public class DWGraph<Airport> { // THIS IS THE CLASS FOR A (D)IRECTED (W)EIGHTED GRAPH

    ArrayList<LL<Airport>> adjacencyList; //this is the graph represented as an array where each element is a linked list
    int vertices; //number of nodes in the graph.

    DWGraph(int vertices){
        this.vertices = vertices;
        this.adjacencyList = new ArrayList<LL<Airport>>(vertices);
    }
    public void addVert(Airport new_airport, String[] to, String[] from, boolean bidir){

        LL<Airport> new_airport_vert_list = new LL<Airport>();
        new_airport_vert_list.insertAtHead(new_airport);

        this.adjacencyList.add(new_airport_vert_list);

    }
    public boolean vertExists(Airport looking_for){

        for(int i = 0; i < this.adjacencyList.size(); i++){
            if(this.adjacencyList.get(i).checkHead(looking_for)){

            }
        }
    }

}
class Airport{

    private String airport_name;
    private double x_loc;
    private double y_loc;

    public Airport(String airport_name, double x_loc, double y_loc){
        this.airport_name = airport_name;
        this.x_loc = x_loc;
        this.y_loc = y_loc;
    }
    public boolean equals(Airport to_comp){
        return this.x_loc == to_comp.x_loc && this.y_loc == to_comp.y_loc && this.airport_name.equals(to_comp.airport_name);
    }
    public String getAirport_name() {
        return airport_name;
    }
    public double getX_loc() {
        return x_loc;
    }
    public double getY_loc() {
        return y_loc;
    }
}