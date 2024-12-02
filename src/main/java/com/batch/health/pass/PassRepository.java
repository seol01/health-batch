package com.batch.health.pass;

import java.util.List;

public interface PassRepository {
    void saveAll(List<PassEntity> passEntities);
}
