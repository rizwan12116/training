package secondPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class UnzipAndReplace {

	public static void main(String[] args) throws IOException {

		for (int i = 1; i <= 150; i++) {

			ZipFile zipFile = new ZipFile(
					"C:\\Users\\ADMIN\\Desktop\\FinalVscFinal\\requisition_" + i + ".vsc");
			final ZipOutputStream zos = new ZipOutputStream(
					new FileOutputStream("C:\\Users\\ADMIN\\Desktop\\FinalVscFinal1\\requisition_" + i + ".vsc"));
			for (Enumeration e = zipFile.entries(); e.hasMoreElements();) {
				ZipEntry entryIn = (ZipEntry) e.nextElement();
				if (!entryIn.getName().equalsIgnoreCase("requisition_"+i+".json")) {
					zos.putNextEntry(entryIn);
					InputStream is = zipFile.getInputStream(entryIn);
					byte[] buf = new byte[1024];
					int len;
					while ((len = is.read(buf)) > 0) {
						zos.write(buf, 0, len);
					}
				} else {
					zos.putNextEntry(new ZipEntry("requisition_"+i+".json"));

					InputStream is = zipFile.getInputStream(entryIn);
					byte[] buf = new byte[1024];
					int len;
					while ((len = (is.read(buf))) > 0) {
						String s = new String(buf);
						if (s.contains("false,S2")) {
							buf = s.replaceAll("false,S2", "false,").getBytes();
						}
						zos.write(buf, 0, (len < buf.length) ? len : buf.length);
					}
				}
				zos.closeEntry();
			}
			zos.close();
		}
	}

}
