package com.example.demo.api.sample;


import com.example.demo.core.Message;
import com.example.demo.core.ApiException;
import com.example.demo.core.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SampleController {
    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/sample")
    public ResponseEntity<ResponseApi> getAllSamples() {
        // ResponseApi responseApi = new ResponseApi(sampleService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("/sample")
    public ResponseEntity<ResponseApi> createSample(@RequestBody Sample sample) {
       ResponseApi responseApi = new ResponseApi(sampleService.create(sample));
       return ResponseEntity.status(HttpStatus.OK).body(responseApi);
    }

    @GetMapping("/sample/{id}")
    public ResponseEntity<ResponseApi> retrieveSample(@PathVariable Long id) {
        Optional<Sample> sample = sampleService.find(id);
        if (!sample.isPresent()) {
            throw new ApiException(Message.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi(sample));
    }

    @PutMapping("/sample/{id}")
    public ResponseEntity<ResponseApi> updateSample(@RequestBody Sample sample, @PathVariable Long id) {
        Optional<Sample> sampleDelete = sampleService.find(id);
        if (!sampleDelete.isPresent())
            throw new ApiException(Message.NOT_FOUND);

        sample.setId(id);
        sampleService.update(sample);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi(sample));
    }

    @DeleteMapping("/sample/{id}")
    public ResponseEntity<ResponseApi> deleteSample(@PathVariable Long id) {
        Optional<Sample> sampleDelete = sampleService.find(id);
        if (!sampleDelete.isPresent())
            throw new ApiException(Message.NOT_FOUND);

        sampleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseApi(sampleDelete));
    }

}
