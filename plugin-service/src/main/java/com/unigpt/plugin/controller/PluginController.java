package com.unigpt.plugin.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unigpt.plugin.dto.PluginCreateDTO;
import com.unigpt.plugin.dto.PluginCreateTestDTO;
import com.unigpt.plugin.dto.ResponseDTO;
import com.unigpt.plugin.service.PluginService;

@RestController
@RequestMapping("/internal/plugins")
public class PluginController {

    PluginService pluginService;

    public PluginController(PluginService pluginService) {
        this.pluginService = pluginService;
    }

    @PostMapping("/create")
    public ResponseEntity<Object> createPlugin(
            @RequestBody PluginCreateDTO dto,
            @RequestHeader("X-User-Id") Integer userid) {
        try {
            return ResponseEntity.ok(pluginService.createPlugin(dto, userid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(false, e.getMessage()));
        }
    }

    @PostMapping("/test")
    public ResponseEntity<Object> testCreatePlugin(
            @RequestBody PluginCreateTestDTO dto,
            @RequestHeader("X-User-Id") Integer userid) {
        try {
            return ResponseEntity.ok(pluginService.testCreatePlugin(dto, userid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(false, e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<Object> getPlugins(
            @RequestParam(defaultValue = "") String q,
            @RequestParam(defaultValue = "latest") String order,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "20") Integer pagesize) {
        try {
            return ResponseEntity.ok(pluginService.getPlugins(q, order, page, pagesize));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(false, e.getMessage()));
        }
    }

    @GetMapping("/{pluginid}")
    public ResponseEntity<Object> getPluginInfo(
            @PathVariable Integer pluginid,
            @RequestHeader("X-User-Id") Integer userid) {
        try {
            return ResponseEntity.ok(pluginService.getPluginInfo(pluginid, userid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ResponseDTO(false, e.getMessage()));
        }
    }
}
