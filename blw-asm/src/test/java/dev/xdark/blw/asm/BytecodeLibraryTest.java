package dev.xdark.blw.asm;

import dev.xdark.blw.BytecodeLibrary;
import dev.xdark.blw.classfile.ClassBuilder;
import dev.xdark.blw.classfile.ClassFileView;
import dev.xdark.blw.classfile.generic.GenericClassBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class BytecodeLibraryTest {
	static final Map<Path, byte[]> classes = new HashMap<>();

	@BeforeAll
	static void setup() throws IOException {
		List<Path> blwClasses = Files.walk(Paths.get("build/classes"))
				.filter(p -> p.toString().endsWith(".class"))
				.toList();
		List<Path> testClasses = Files.walk(Paths.get("src/test/resources"))
				.filter(p -> p.toString().endsWith(".class"))
				.toList();
		Stream.concat(blwClasses.stream(), testClasses.stream())
				.forEach(p -> classes.put(p, assertDoesNotThrow(() -> Files.readAllBytes(p))));
	}

	static Stream<Arguments> iterateClasses() {
		return classes.entrySet().stream()
				.map(e -> Arguments.of(e.getKey(), e.getValue()));
	}

	@ParameterizedTest
	@MethodSource("iterateClasses")
	void parseBuildAndWriteClass(Path path, byte[] bytecode) {
		BytecodeLibrary library = new AsmBytecodeLibrary(ClassWriterProvider.flags(0));
		ClassBuilder<?, ?> builder = new GenericClassBuilder();
		assertDoesNotThrow(() -> library.read(new ByteArrayInputStream(bytecode), builder),
				"Failed to read '" + path + "'");
		ClassFileView build = assertDoesNotThrow(builder::build,
				"Failed to build '" + path + "'");
		assertDoesNotThrow(() -> library.write(build, new ByteArrayOutputStream()),
				"Failed to write '" + path + "'");
	}
}