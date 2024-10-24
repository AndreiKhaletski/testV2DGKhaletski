package by.testv2.dao;

import by.testv2.core.entity.SkyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkyResource extends JpaRepository<SkyEntity, Long> {
}
