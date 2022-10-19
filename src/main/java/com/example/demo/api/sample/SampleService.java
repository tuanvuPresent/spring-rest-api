package com.example.demo.api.sample;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SampleService {
    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public List<SampleDto> findAll() {
        List<Sample> samples = sampleRepository.findAll();
        return samples.stream().map(SampleDto::new).collect(Collectors.toList());
    }

    public Sample create(Sample sample) {
        return sampleRepository.save(sample);
    }

    public Optional<Sample> find(Long id) {
        return sampleRepository.findById(id);
    }

    public Sample update(Sample sample) {
        return sampleRepository.save(sample);
    }

    public void delete(Long id) {
        sampleRepository.deleteById(id);
    }
}
