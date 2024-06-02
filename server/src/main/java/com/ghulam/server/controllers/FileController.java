package com.ghulam.server.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RestController
@RequestMapping(value = "${api.endpoints.base-url}/files")
@CrossOrigin("*")
public class FileController {

    // a simple single file upload endpoint
    @PostMapping(path = "/upload", consumes = "multipart/form-data")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            final String UPLOAD_DIR = "src/main/resources/uploads/";
            try {
                Path path = Paths.get(UPLOAD_DIR);
                if (!Files.exists(path)) {
                    Files.createDirectories(path);
                }
                Files.copy(file.getInputStream(), path.resolve(Objects.requireNonNull(file.getOriginalFilename())));
                return ResponseEntity.ok("File uploaded successfully");
            } catch (Exception ex) {
                ex.printStackTrace();
                return ResponseEntity.badRequest().body("File upload failed");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    // a simple single file download endpoint
    @GetMapping(path = "/download")
    public ResponseEntity<?> downloadFile(@RequestParam("filename") String filename) {
        try {
            final String UPLOAD_DIR = "src/main/resources/uploads/";
            Path path = Paths.get(UPLOAD_DIR + filename);
            if (Files.exists(path)) {
                return ResponseEntity.ok(Files.readAllBytes(path));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ResponseEntity.badRequest().body("File not found");
    }
}
