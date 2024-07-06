package com.tarento.integration.integrationframework.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tarento.integration.integrationframework.model.ExternalApiIntegrationDTO;
import com.tarento.integration.integrationframework.model.ResponseDTO;
import com.tarento.integration.integrationframework.service.IntegrationService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.codec.multipart.FilePart;

import org.springframework.web.bind.annotation.*;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/integration/v1")
@Slf4j
public class IntegrationController {

    @Autowired
    private IntegrationService IntegrationService;

    @PostMapping("/create-external-call")
    public Mono<ResponseDTO> createExternalAPICall(@RequestBody ExternalApiIntegrationDTO integrationDTO) {
        try {
            Mono<ResponseDTO> responseDTOMono = IntegrationService.createExternalAPICall(integrationDTO);

            return responseDTOMono;
        } catch (Exception e) {
            return Mono.error(e);
        }
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Success";
    }

}
