package com.example.demo.api.sample;


import com.example.demo.core.Message;
import com.example.demo.core.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SampleController {
    private final SampleService sampleService;

    public SampleController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/sample")
    public List<Sample> getAllSamples() {
        return sampleService.findAll();
    }

    @PostMapping("/sample")
    public Sample createSample(@RequestBody Sample sample) {
        return sampleService.create(sample);
    }

    @GetMapping("/sample/{id}")
    public Optional<Sample> retrieveSample(@PathVariable Long id) throws ApiException {
        Optional<Sample> sample = sampleService.find(id);
        if (!sample.isPresent()) {
            throw new ApiException(Message.NOT_FOUND);
        }
        return sample;
    }

    @PutMapping("/sample/{id}")
    public ResponseEntity<Sample> updateSample(@RequestBody Sample sample, @PathVariable Long id) throws ApiException {
        Optional<Sample> sampleDelete = sampleService.find(id);
        if (!sampleDelete.isPresent())
            throw new ApiException(Message.NOT_FOUND);

        sample.setId(id);
        sampleService.update(sample);
        return new ResponseEntity<>(sample, HttpStatus.OK);
    }

    @DeleteMapping("/sample/{id}")
    public ResponseEntity<Optional<Sample>> deleteSample(@PathVariable Long id) throws ApiException {
        Optional<Sample> sampleDelete = sampleService.find(id);
        if (!sampleDelete.isPresent())
            throw new ApiException(Message.NOT_FOUND);

        sampleService.delete(id);
        return new ResponseEntity<>(sampleDelete, HttpStatus.OK);
    }

}
