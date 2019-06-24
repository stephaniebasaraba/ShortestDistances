A program called ShortestDistances that:

1.) Reads the list of cities then builds a symbol table where the key is the name of a city and the value is an integer.
2.) Reads the list of major cities into an array.
3.) Creates an empty undirected graph using the class Graph. In this graph, each vertex represents a city.
4.) Reads in each connection from the connections data file, one line at a time, where each line contains the names of two cities. As it reads in each line, it adds an edge to the graph.
5.) For each city:
    - Creates a BreadthFirstPaths object with that city as the starting vertex.
6.) For each major city:
    - Prints the shortest distance from the major city to the city in the outer loop.
