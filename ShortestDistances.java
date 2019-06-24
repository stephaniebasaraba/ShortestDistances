// Stephanie Basaraba

package ShortestDistances;
import stdlib.*;
import java.util.*;

public class ShortestDistances {

	public static void main(String[] args) {
		
		// reads list of cities, puts into ST with vertex pair
		StdIn.fromFile("Data/cities.txt");
		String[] cities = StdIn.readAllStrings();
		int N = cities.length;
		ArrayST<String, Integer> st = new ArrayST<>();
		for (int i = 0; i < N; i++)
			st.put(cities[i], i);
		
		// reads in list of major cities, puts into a string array
		StdIn.fromFile("Data/majorcities.txt");
		String[] majorCities = StdIn.readAllStrings();
		
		// create new empty graph
		Graph G = new Graph(cities.length);
	
		// reads in connection, looks up vertex value for city, creates edge between two vertices
		StdIn.fromFile("Data/connections.txt");
		while (!StdIn.isEmpty()) {
			String connection = StdIn.readLine();
			String [] cityConnect = connection.split(" ");
			int v1 = st.get(cityConnect[0]);
			int v2 = st.get(cityConnect[1]);
			G.addEdge(v1, v2);
		}
		
		// print header line
		StdOut.printf("%20s", "");
		for (String majorCity: majorCities) {
			StdOut.printf("%-12s", majorCity);
		}
		StdOut.println();
		
		// for each city create BFS to each major city
		for (int i = 0; i < cities.length; i++) {
			
			String outerCity = cities[i];
			int outerCityVertex = st.get(cities[i]);
			int majorCityVertex = 0;
			
			List<Integer> distanceStore = new ArrayList<Integer>();
			BreadthFirstPaths bfs = new BreadthFirstPaths(G, outerCityVertex);
	
			for (String mc : majorCities) {
				int distance = 0;
				majorCityVertex = st.get(mc);
				distance = bfs.distTo(majorCityVertex);	
				distanceStore.add(distance);
			}
			
			// print array list
			StdOut.printf("%-20s %-12d %-12d %-12d %-12d %-12d \n", outerCity, distanceStore.get(0), distanceStore.get(1), distanceStore.get(2), distanceStore.get(3), distanceStore.get(4));

		}
	}
}

