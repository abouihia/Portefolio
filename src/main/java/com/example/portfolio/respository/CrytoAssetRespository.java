package com.example.portfolio.respository;

import com.example.portfolio.data.CrytoAsset;
import org.springframework.data.repository.CrudRepository;

public interface CrytoAssetRespository   extends CrudRepository<CrytoAsset, String> {
}
