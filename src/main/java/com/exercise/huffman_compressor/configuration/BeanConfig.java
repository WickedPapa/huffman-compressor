package com.exercise.huffman_compressor.configuration;

import com.exercise.huffman_compressor.service.HuffmanCompressorService;
import com.exercise.huffman_compressor.service.HuffmanCompressorServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HuffmanCompressorProperties.class)
public class BeanConfig {

    @Bean
    public HuffmanCompressorService sortingService(HuffmanCompressorProperties properties) {
        return switch (properties.implementation()) {
            case SIMPLE -> new HuffmanCompressorServiceImpl();
        };
    }
}
