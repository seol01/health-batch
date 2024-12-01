package com.batch.health;

import com.batch.health.repository.packages.PackageEntity;
import com.batch.health.repository.packages.PackageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class HealthTest {

    @Autowired
    private PackageRepository packageRepository;

    @Test
    public void test_save() {
        PackageEntity packageEntity = new PackageEntity();
        packageEntity.setPackageName("바디 챌린지 PT 12주");
        packageEntity.setPeriod(84);

        packageRepository.save(packageEntity);

        assertNotNull(packageEntity.getPackageSeq());
    }
}
