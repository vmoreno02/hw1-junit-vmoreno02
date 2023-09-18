package edu.byu.cs329.hw0moreno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Driver class for the Dijkstra code.
 */
public class DijkstraMain {

  static final Logger logger = LoggerFactory.getLogger(Dijkstra.class);

  /**
   * Populates the graph and runs Dijkstra's algorithm.
   *
   * @param args input, does nothing in this code
   */
  public static void main(String[] args) {
    final int[][] graph = { { 0, 2, 4, Dijkstra.M, Dijkstra.M, Dijkstra.M }, 
      { 2, 0, 1, 4, Dijkstra.M, Dijkstra.M },
      { 4, 1, 0, 2, 6, Dijkstra.M }, { Dijkstra.M, 4, 2, 0, 1, 3 }, 
      { Dijkstra.M, Dijkstra.M, 6, 1, 0, 5 },
      { Dijkstra.M, Dijkstra.M, Dijkstra.M, 3, 5, 0 } };
    Dijkstra d = new Dijkstra(graph);
    int sp = d.shortestPath(0, 4);
    logger.trace("d = " + sp);
    logger.debug("d = " + sp);
    logger.info("d = " + sp);
    logger.warn("d = " + sp);
    logger.error("d = " + sp);
    
  }
}
