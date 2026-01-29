package com.exercise.huffman_compressor.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@With
@Value
@Builder
public class HuffmanNode implements Comparable<HuffmanNode> {

    Character character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}
