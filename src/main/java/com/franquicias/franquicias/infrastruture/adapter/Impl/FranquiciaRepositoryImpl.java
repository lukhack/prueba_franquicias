package com.franquicias.franquicias.infrastruture.adapter.Impl;

import com.icodeap.ecommerce.application.repository.EcoBottleRepository;
import com.icodeap.ecommerce.domain.EcoBottle;
import com.icodeap.ecommerce.infrastructure.adapter.crud.EcoBottleCrudRepository;
import com.icodeap.ecommerce.infrastructure.entity.EcoBottleEntity;
import com.icodeap.ecommerce.infrastructure.mapper.EcoBottleMapper;
import com.icodeap.ecommerce.infrastructure.util.MessageSourceHelper;
import org.springframework.stereotype.Service;

@Service
public class FranquiciaRepositoryImpl implements EcoBottleRepository {
    private final EcoBottleCrudRepository ecoBottleCrudRepository;
    private final MessageSourceHelper messageSourceHelper;
    private final EcoBottleMapper ecoBottleMapper;


    public FranquiciaRepositoryImpl(EcoBottleCrudRepository ecoBottleCrudRepository, MessageSourceHelper messageSourceHelper, EcoBottleMapper ecoBottleMapper) {
        this.ecoBottleCrudRepository = ecoBottleCrudRepository;
        this.messageSourceHelper = messageSourceHelper;
        this.ecoBottleMapper = ecoBottleMapper;
    }

    @Override
    public EcoBottle createEcoBottle(EcoBottle ecoBottle) {
        EcoBottleEntity ecoBottleEntity = ecoBottleMapper.toEcoBottlesEntity(ecoBottle);
        return ecoBottleMapper.toEcoBottle( this.ecoBottleCrudRepository.save(ecoBottleEntity));
    }

    @Override
    public EcoBottle findByCode(String code) {
        System.out.println("estoy creando 2: "+code);
        EcoBottleEntity ecoBottleEntity = this.ecoBottleCrudRepository.findByCode(code).orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));
        return ecoBottleMapper.toEcoBottle(ecoBottleEntity);
    }

    @Override
    public EcoBottle findByKeyAndCode(String key, String code) {
        EcoBottleEntity ecoBottleEntity = this.ecoBottleCrudRepository.findByCodeAndKey(code, key).orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));
        return this.ecoBottleMapper.toEcoBottle(ecoBottleEntity);
    }

    @Override
    public EcoBottle findById(Integer id) {
        EcoBottleEntity ecoBottleEntity = this.ecoBottleCrudRepository.findById(id).orElseThrow(() -> new IllegalStateException(messageSourceHelper.getMessage("error.response.not.found")));
        return this.ecoBottleMapper.toEcoBottle(ecoBottleEntity);
    }

    @Override
    public Iterable<EcoBottle> findAll() {
        Iterable<EcoBottleEntity> ecoBottleEntities = this.ecoBottleCrudRepository.findAll();
        return this.ecoBottleMapper.toEcoBottles(ecoBottleEntities);
    }



}
