package com.exercise.huffman_compressor.service;

import com.exercise.huffman_compressor.model.HuffmanNode;
import com.exercise.huffman_compressor.model.HuffmanTree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCompressorServiceImpl implements HuffmanCompressorService {
    @Override
    public Map<Character, String> build(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char c : text.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

        for (var entry : frequencies.entrySet()) {
            pq.add(HuffmanNode.builder()
                    .character(entry.getKey())
                    .frequency(entry.getValue())
                    .build());
        }

        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            pq.add(HuffmanNode.builder()
                    .frequency(left.getFrequency() + right.getFrequency())
                    .left(left)
                    .right(right)
                    .build());
        }

        HuffmanTree tree = HuffmanTree.builder()
                .root(pq.poll())
                .build();

        return tree.buildCodeTable();
    }

    @Override
    public String compress(String text, Map<Character, String> hCode) {
        StringBuilder sb = new StringBuilder();

        for (char c : text.toCharArray()) {
            String code = hCode.get(c);
            if (code == null) {
                throw new IllegalArgumentException("Character not found in Huffman code: " + c);
            }
            sb.append(code);
        }

        return sb.toString();
    }

    @Override
    public String decompress(String compressedText, Map<Character, String> hCode) {
        Map<String, Character> reverseMap = new HashMap<>();
        for (var entry : hCode.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        StringBuilder result = new StringBuilder();
        StringBuilder buffer = new StringBuilder();

        for (char bit : compressedText.toCharArray()) {
            buffer.append(bit);
            Character decoded = reverseMap.get(buffer.toString());
            if (decoded != null) {
                result.append(decoded);
                buffer.setLength(0);
            }
        }

        return result.toString();
    }

    @Override
    public String implementationName() {
        return "Huffman Tree";
    }
}
