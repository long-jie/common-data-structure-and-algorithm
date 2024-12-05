package org.capybara.algorithm.round_robin;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 简单轮询算法
 *
 * @author Long Jie
 * @since 2024/12/5 22:30
 */
public class SimpleRoundRobin<T> {

    private final List<T> elements;
    private final AtomicInteger currentIndex;

    public SimpleRoundRobin(List<T> elements) {
        this.elements = elements;
        this.currentIndex = new AtomicInteger(0);
    }

    public T getNextServer() {
        int index = currentIndex.getAndUpdate(i -> (i + 1) % elements.size());
        return elements.get(index);
    }

}
