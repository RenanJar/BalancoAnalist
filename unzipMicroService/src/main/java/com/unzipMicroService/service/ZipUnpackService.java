package com.unzipMicroService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Service
public class ZipUnpackService {

    @Value("${outDir}")
    private Path outDir;

    @Value("${zipFileName}")
    private String zipFileName;

    @Value("#{'${listArquivos}'.split(',')}")
    private List<String> listArquivos;

    @Autowired
    RabbitmqService rabbitmqService;

    public Path leitorZip() throws IOException {
        byte[] buffer = new byte[2048];

        Path output = null;

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(zipFileName));
             ZipInputStream stream = new ZipInputStream(bufferedInputStream)) {
            ZipEntry entry;

            while ((entry = stream.getNextEntry()) != null) {

                if(listArquivos.contains(entry.getName())) {

                    Path temp = Files.createTempFile(outDir,entry.getName(), ".csv");
                    output = temp.toAbsolutePath();

                    try (FileOutputStream fos = new FileOutputStream(temp.toFile());
                         BufferedOutputStream bos = new BufferedOutputStream(fos, buffer.length)) {
                        int len;
                        while ((len = stream.read(buffer)) > 0) {
                            bos.write(buffer, 0, len);
                        }
                    }

                    rabbitmqService.enviaMensagem("csvRead",output.toString());
                }

            }
        }
        return output;
    }

}
