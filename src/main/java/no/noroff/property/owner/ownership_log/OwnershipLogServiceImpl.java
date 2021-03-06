package no.noroff.property.owner.ownership_log;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class OwnershipLogServiceImpl implements OwnershipLogService {
    @Autowired
    private OwnershipLogRepository ownershipLogRepository;

    @Override
    public OwnershipLog createOwnershipLog(OwnershipLog ownershipLog) {
        return ownershipLogRepository.save(ownershipLog);
    }

    @Override
    public List<OwnershipLog> findAll() {
        return ownershipLogRepository.findAll();
    }
}
