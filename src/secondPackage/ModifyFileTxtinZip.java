package secondPackage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipFile;

public class ModifyFileTxtinZip {

	public static void main(String[] args) throws IOException {

		for (int i = 1; i <= 150; i++) {

			modifyTextFileInZip("C:\\Users\\ADMIN\\Desktop\\FinalVsc\\requisition_"
					+ i + ".vsc","Header.json");
		}
	}

	static void modifyTextFileInZip(String zipPath,String filename) throws IOException {
		Path zipFilePath = Paths.get(zipPath);
		try (FileSystem fs = FileSystems.newFileSystem(zipFilePath, null)) {
			Path source = fs.getPath("/" + filename);
			Path temp = fs.getPath("/abcd_"+filename);
			if (Files.exists(temp)) {
				throw new IOException("temp file exists, generate another name");
			}
			Files.move(source, temp);
			streamCopy(temp, source);
			Files.delete(temp);
		}
	}
	static int  counter = 0;
	static void streamCopy(Path src, Path dst) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(
				Files.newInputStream(src)));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
						Files.newOutputStream(dst)))) {

			String line;
			while ((line = br.readLine()) != null) {
				
				
				line = line.replaceAll("\"RequisitionId\": "+(600+counter)+",", "\"RequisitionId\": "+(800+counter)+",")
						.replaceAll("\"VesselModuleId\": "+(600+counter)+",", "\"VesselModuleId\": "+(800+counter)+",")
						.replaceAll("\"EntityId\": "+(600+counter)+",", "\"EntityId\": "+(800+counter)+",")
						.replaceAll("_2021010614364"+(6000 + counter +1)+"\",", "_2021010614364"+(8000 + counter +1)+"\",");

				bw.write(line);
				bw.newLine();
			}
			
			counter++;
		}
	}

}
