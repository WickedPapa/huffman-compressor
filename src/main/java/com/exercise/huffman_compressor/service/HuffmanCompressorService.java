package com.exercise.huffman_compressor.service;

import java.util.Map;

public interface HuffmanCompressorService {

    Map<Character, String> build(String text);

    String compress(String text, Map<Character, String> hCode);

    String decompress(String compressedText, Map<Character, String> hCode);

    String implementationName();

    default String printInfoCompress(String text, Map<Character, String> hCode) {
        System.out.println("TEXT TO COMPRESS:\n" + text);
        long start = System.nanoTime();
        String compressedText = compress(text, hCode);
        long end = System.nanoTime();
        long durationNs = end - start;
        System.out.println("COMPRESSED TEXT:\n" + compressedText);
        System.out.println("Execution time: " + durationNs + " ns (" + (durationNs / 1_000_000.0) + " ms)");
        return compressedText;
    }

    default void printInfoDecompress(String compressedText, Map<Character, String> hCode) {
        System.out.println("COMPRESSED TEXT:\n" + compressedText);
        long start = System.nanoTime();
        String decompressedText = decompress(compressedText, hCode);
        long end = System.nanoTime();
        long durationNs = end - start;
        System.out.println("DECOMPRESSED TEXT:\n" + decompressedText);
        System.out.println("Execution time: " + durationNs + " ns (" + (durationNs / 1_000_000.0) + " ms)");
    }
}

