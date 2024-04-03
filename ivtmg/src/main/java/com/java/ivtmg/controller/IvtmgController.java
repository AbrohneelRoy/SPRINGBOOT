package com.java.ivtmg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.ivtmg.model.Ivtmg;
import com.java.ivtmg.service.IvtmgService;

@RestController
@RequestMapping("/api")
public class IvtmgController {
    @Autowired
    private IvtmgService ivtmgService;

    @PostMapping("/user")
    public ResponseEntity<Ivtmg> addIvtmg(@RequestBody Ivtmg ivtmg) {
        Ivtmg addedIvtmg = ivtmgService.addIvtmg(ivtmg);
        if (addedIvtmg != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(addedIvtmg);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<Ivtmg>> getAllIvtmgs() {
        List<Ivtmg> ivtmgs = ivtmgService.getAllIvtmgs();
        if (ivtmgs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok().body(ivtmgs);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Ivtmg> getIvtmgById(@PathVariable Integer userId) {
        Ivtmg ivtmg = ivtmgService.getIvtmgById(userId);
        if (ivtmg != null) {
            return ResponseEntity.ok(ivtmg);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Ivtmg> updateIvtmg(@PathVariable Integer userId, @RequestBody Ivtmg ivtmg) {
        if (ivtmgService.getIvtmgById(userId) != null) {
            ivtmg.setId(userId); 
            ivtmgService.updateIvtmg(ivtmg);
            return ResponseEntity.ok(ivtmg);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteIvtmgById(@PathVariable Integer userId) {
        if (ivtmgService.getIvtmgById(userId) != null) {
            ivtmgService.deleteIvtmgById(userId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
