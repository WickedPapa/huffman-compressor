package com.exercise.huffman_compressor.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "huffman-compressor")
public record HuffmanCompressorProperties(HuffmanCompressorImplementation implementation) {}