package com.exercise.huffman_compressor.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;
import org.jetbrains.annotations.Nullable;

@With
@Value
@Builder
public class HuffmanNode implements Comparable<HuffmanNode> {

    @Nullable Character character;
    int frequency;
    @Nullable HuffmanNode left;
    @Nullable HuffmanNode right;

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return Integer.compare(this.frequency, other.frequency);
    }
}
