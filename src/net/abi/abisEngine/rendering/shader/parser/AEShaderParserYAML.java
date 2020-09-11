package net.abi.abisEngine.rendering.shader.parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import net.abi.abisEngine.handlers.file.PathHandle;
import net.abi.abisEngine.rendering.shader.parser.fileTypes.yaml.AEShaderFileYAML;
import net.abi.abisEngine.rendering.shader.parser.fileTypes.yaml.AEShaderGLSLProgram;

public class AEShaderParserYAML {

	public static AEShaderFileYAML parse(PathHandle file) {
		Yaml yaml = new Yaml(new Constructor(AEShaderFileYAML.class));
		AEShaderFileYAML parsedFile = null;
		try {
			parsedFile = yaml.load(Files.newInputStream(Paths.get(file.getFileInstance().getAbsolutePath())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (parsedFile.getAE_SHADER_NAME().equals("!!AE_SHADER_FILE_NAME")) {
			parsedFile.setAE_SHADER_NAME(file.getNameWithoutExtension());
		}
		return parsedFile;
	}
}
