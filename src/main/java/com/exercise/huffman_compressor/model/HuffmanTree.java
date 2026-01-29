package com.exercise.huffman_compressor.model;

import lombok.Builder;
import lombok.Value;
import lombok.With;

import java.util.HashMap;
import java.util.Map;

@With
@Value
@Builder
public class HuffmanTree {

    HuffmanNode root;

    public Map<Character, String> buildCodeTable() {
        Map<Character, String> table = new HashMap<>();
        buildRecursive(root, "", table);
        return table;
    }

    private void buildRecursive(HuffmanNode node, String code, Map<Character, String> table) {
        if (node.isLeaf()) {
            table.put(node.getCharacter(), code.isEmpty() ? "0" : code);
            return;
        }

        buildRecursive(node.getLeft(), code + "0", table);
        buildRecursive(node.getRight(), code + "1", table);
    }
}
