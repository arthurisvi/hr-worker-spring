package com.devsuperior.hrworker.controller;
import java.net.URI;
import java.util.List;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.services.WorkerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    public ResponseEntity<List<Worker>> findAll(){

        List<Worker> workersList = workerService.findAll();

        return ResponseEntity.ok(workersList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findWorkById(@PathVariable Long id){
        
        Worker worker = workerService.findWorkerById(id);

        return ResponseEntity.ok(worker);
    }

    @PostMapping
    public ResponseEntity<Worker> createWorker(@RequestBody Worker worker){
        workerService.createWorker(worker);

        URI location = URI.create(String.format("/workers/%s", worker.getId()));

        return ResponseEntity.created(location).build();
    }

}
