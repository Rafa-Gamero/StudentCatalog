package com.lab.studentcatalog.demo.controller;

import com.lab.studentcatalog.demo.model.Catalog;
import com.lab.studentcatalog.demo.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/{courseCode}")
    public ResponseEntity<?> getCatalog(@PathVariable String courseCode) {
        try {
            Catalog catalog = catalogService.getCatalogByCourseCode(courseCode);
            System.out.println(catalog);
            return (catalog != null)
                    ? ResponseEntity.ok(catalog)
                    : ResponseEntity.notFound().build();

        } catch (Exception e) {
            // Es buena práctica loguear la excepción para debug
            System.err.println("Error getting catalog: " + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(502).build();
        }
    }
}