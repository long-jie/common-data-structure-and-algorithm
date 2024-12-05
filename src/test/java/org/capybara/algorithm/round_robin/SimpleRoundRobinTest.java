package org.capybara.algorithm.round_robin;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleRoundRobinTest {

    @Test
    void getNextServer() {
        Server s1 = new Server("s1", 1);
        Server s2 = new Server("s2", 1);
        List<Server> servers = List.of(s1, s2);
        SimpleRoundRobin<Server> simpleRoundRobin = new SimpleRoundRobin<>(servers);
        // first loop
        assertEquals(s1, simpleRoundRobin.getNextServer());
        assertEquals(s2, simpleRoundRobin.getNextServer());
        // second loop
        assertEquals(s1, simpleRoundRobin.getNextServer());
        assertEquals(s2, simpleRoundRobin.getNextServer());
    }

}