package com.isc.tienda.controller;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/upload", produces = "application/json")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UploadController {

    @PostMapping("/")
    public ResponseEntity<?> uploadFile(@RequestParam("archivo") MultipartFile archivo) {
        Map<String, Object> respuesta = new HashMap<String, Object>();
        if (!archivo.isEmpty()) {
            String nombreArchivo = UUID.randomUUID() + "_" + archivo.getOriginalFilename().replace(" ", "");
            String uploadDirectory = System.getProperty("user.home") + System.getProperty("file.separator") + "file";
            System.out.println("El directorio de subida es: "+uploadDirectory);
            File uploadDirectoryFile = new File(uploadDirectory);
            if (!uploadDirectoryFile.exists() && !uploadDirectoryFile.isDirectory()) {
                uploadDirectoryFile.mkdir();
            }
            Path rutaArchivo = Paths.get(uploadDirectory).resolve(nombreArchivo).toAbsolutePath();
            try {
                Files.copy(archivo.getInputStream(), rutaArchivo);
            } catch (IOException e) {
                respuesta.put("mensaje", "Error al subir la imagen del cliente: " + nombreArchivo);
                respuesta.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
                return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            respuesta.put("mensaje", "Se subio correctamente el archivo");
            respuesta.put("nombreArchivo", nombreArchivo);
        }
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/{nameFile:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String nameFile) {
        String uploadDirectory = System.getProperty("user.home") + System.getProperty("file.separator") + "file";
        Path rutaArchivo = Paths.get(uploadDirectory).resolve(nameFile).toAbsolutePath();
        Resource recurso = null;
        try {
            recurso = new UrlResource(rutaArchivo.toUri());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (!recurso.exists() && !recurso.isReadable()) {
            throw new RuntimeException("Error al cargar el archivo en el servidor: " + nameFile);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

        return new ResponseEntity<Resource>(recurso, headers, HttpStatus.OK);
    }

}
