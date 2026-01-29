package com.exercise.huffman_compressor;

import com.exercise.huffman_compressor.service.HuffmanCompressorService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
@RequiredArgsConstructor
public class HuffmanCompressorApplication {

	private final HuffmanCompressorService huffmanCompressorService;

	public static void main(String[] args) {
		SpringApplication.run(HuffmanCompressorApplication.class, args);
	}

	@Bean
	public ApplicationRunner startupRunner() {
		String text = "hello huffman algorithm example";
		return args -> {
			System.out.println("------------------------------------------------------------------------");
			System.out.println("WELCOME TO HUFFMAN ALGORITHM IMPLEMENTATION");
			System.out.println("Using implementation: " + huffmanCompressorService.implementationName());
			System.out.println("------------------------------------------------------------------------");

			Map<Character, String> hCode = huffmanCompressorService.build(text);

			System.out.println("HUFFMAN CODE:");
			hCode.forEach((k, v) -> System.out.println("'" + k + "' -> " + v));
			System.out.println();

			String compressedText = huffmanCompressorService.printInfoCompress(text, hCode);
			System.out.println();
			huffmanCompressorService.printInfoDecompress(compressedText, hCode);
		};
	}

}
