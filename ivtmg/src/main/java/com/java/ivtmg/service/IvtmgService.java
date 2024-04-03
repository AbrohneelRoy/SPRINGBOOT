package com.java.ivtmg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.ivtmg.model.Ivtmg;
import com.java.ivtmg.repository.IvtmgRepo;

@Service
public class IvtmgService {
    private final IvtmgRepo ivtmgRepo;
    
    @Autowired
    public IvtmgService(IvtmgRepo ivtmgRepo){
        this.ivtmgRepo = ivtmgRepo;
    }

    public Ivtmg addIvtmg(Ivtmg ivtmg){
        return ivtmgRepo.save(ivtmg);
    }

    public List<Ivtmg> getAllIvtmgs(){
        return ivtmgRepo.findAll();
    }

    public Ivtmg getIvtmgById(Integer id){
        return ivtmgRepo.findById(id).orElse(null);
    }

    public Ivtmg updateIvtmg(Ivtmg ivtmg){
        return ivtmgRepo.save(ivtmg);
    }
    
    public void deleteIvtmgById(Integer id) {
        ivtmgRepo.deleteById(id);
    }
}
