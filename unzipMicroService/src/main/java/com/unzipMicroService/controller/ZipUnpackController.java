package com.unzipMicroService.controller;

import com.unzipMicroService.service.ZipUnpackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/unpack")
public class ZipUnpackController {

    @Value("${outDir}")
    Path outDir;

    @Value("${zipFileName}")
    String zipFileName;

    @Value("#{'${listArquivos}'.split(',')}")
    List<String> listArquivos;

    @Autowired
    ZipUnpackService zipUnpackService;

    @GetMapping
    public void unpack () throws IOException {
        zipUnpackService.leitorZip();
    }

}
