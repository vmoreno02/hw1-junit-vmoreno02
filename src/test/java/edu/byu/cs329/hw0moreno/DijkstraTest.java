package edu.byu.cs329.hw0moreno;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisplayName("Tests for Dijkstra's shortest path algorithm")
public class DijkstraTest {
    private static final Logger logger = LoggerFactory.getLogger(DijkstraTest.class);

    static Dijkstra dijkstra = null;
    static int count = 0;
    static final int[][] graph = { { 0, 2, 4, Dijkstra.M, Dijkstra.M, Dijkstra.M },
            { 2, 0, 1, 4, Dijkstra.M, Dijkstra.M }, { 4, 1, 0, 2, 6, Dijkstra.M },
            { Dijkstra.M, 4, 2, 0, 1, 3 }, { Dijkstra.M, Dijkstra.M, 6, 1, 0, 5 },
            { Dijkstra.M, Dijkstra.M, Dijkstra.M, 3, 5, 0 } };

    @BeforeAll
    public static void beforeAll() {
        logger.info("before all");
        dijkstra = new Dijkstra(graph);
    }

    @AfterAll
    public static void afterAll() {
        logger.info("after all");
    }

    @Nested
    @DisplayName("Test for Dijkstra.tableToString")
    class TableToStringTests {
        @Test
        @DisplayName("Given valid graph when tableToString then valid output")
        public void given_validGraph_when_tableToSTring_then_validOutput() {
            String expected = "0 2 4 - - -\n2 0 1 4 - -\n4 1 0 2 6 -\n- 4 2 0 1 3\n- - 6 1 0 5\n- - - 3 5 0";

            assertEquals(expected, Dijkstra.tableToString(graph));
        }

        @Test
        @DisplayName("Given graph 1 when tableToString then output 1")
        public void given_graph1_when_tableToString_then_output1() {
            int[][] new_graph = { { 1 } };
            
            assertEquals("1", Dijkstra.tableToString(new_graph));
        }
    }

    @Nested
    @DisplayName("Tests for Dijkstra.getMinimumIndex")
    class GetMinimumIndexTest {
        @Test
        @DisplayName("Given all lengths M and an empty set when getMinimumIndex then return 0")
        void given_allLengthsMAndAnEmptySet_when_getMinimumIndex_then_return0() {
            Set<Integer> set = new HashSet<Integer>();
            final int[] length = { Dijkstra.M, Dijkstra.M };
            assertEquals(0, Dijkstra.getMinimumIndex(length, set));
        }

        @Test
        @DisplayName("Given all lengths M and all indices in set when getMinimumIndex then return M")
        void given_allLengthsMAndAllIndicesInSet_when_getMinimumIndex_then_returnM() {
            Set<Integer> set = new HashSet<Integer>();
            set.add(0);
            set.add(1);
            final int[] length = { Dijkstra.M, Dijkstra.M };
            assertEquals(Dijkstra.M, Dijkstra.getMinimumIndex(length, set));
        }
    }

    @Nested
    @DisplayName("Tests for Dijkstras.shortestPath")
    class ShortestPathTest {
        final Logger logger = LoggerFactory.getLogger(ShortestPathTest.class);

        @BeforeEach
        void beforeEach() {
            logger.info("Test " + count++);
        }

        @Test
        @DisplayName("Given node 0 and 4 in test graph when shortestPath then return 6")
        void given_nodes0And4_when_shortestPath_then_return6() {
            assertEquals(6, dijkstra.shortestPath(0, 4));
        }

        @Test
        @DisplayName("Given node 0 and 3 in test graph when shortestPath then return 5")
        void given_node0And3_when_GivenNode0AndNode3_then_return5() {
            assertEquals(5, dijkstra.shortestPath(0, 3));
        }
    }
}
