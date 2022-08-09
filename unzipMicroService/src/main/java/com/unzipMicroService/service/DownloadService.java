package com.unzipMicroService.service;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class DownloadService {

    @Value("${zipFileName}")
    private String dirFileDowload;

    @Value("${download.From.CvmUrl}")
    private String urlToDowloadCvm;


    public void deleteZipAnterior() throws IOException {
        Path pathDelete= Path.of(dirFileDowload);
        Files.deleteIfExists(pathDelete);
        System.out.println("Arquivo apagado");
    }

    public void dowloadZipFromCvm() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String url = urlToDowloadCvm;
        var zipDowload =restTemplate.getForObject(url,byte[].class);

        FileOutputStream fileOutputStream = new FileOutputStream(dirFileDowload);
        fileOutputStream.write(zipDowload);
        fileOutputStream.close();
        System.out.println("Executado");
    }
}
