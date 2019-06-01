package com.example.books.model.test.enums;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;

import com.example.books.model.test.config.RestConfig;

@Slf4j
@BasePathAwareController
public class EnumsController {
    @Autowired
    private RestConfig restConfig;

    @GetMapping("/denunciaAssuntos")
    public ResponseEntity<?> getDenunciaAssuntos() {
        Resources<DenunciaAssunto> resources = new Resources<>(Arrays.asList(DenunciaAssunto.values()));

        return ResponseEntity.ok()
            .cacheControl(restConfig.getCacheControlEnums())
            .body(resources);
    }

    @GetMapping("/envolvidoTipos")
    public ResponseEntity<?> getEnvolvidoTipos() {
        Resources<EnvolvidoTipo> resources = new Resources<>(Arrays.asList(EnvolvidoTipo.values()));

        return ResponseEntity.ok()
            .cacheControl(restConfig.getCacheControlEnums())
            .body(resources);
    }

    @GetMapping("/envolvidoCategorias")
    public ResponseEntity<?> getEnvolvidoCategorias() {
        Resources<EnvolvidoCategoria> resources = new Resources<>(Arrays.asList(EnvolvidoCategoria.values()));

        return ResponseEntity.ok()
            .cacheControl(restConfig.getCacheControlEnums())
            .body(resources);
    }
}
