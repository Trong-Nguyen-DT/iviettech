package dt.m07.service;

import dt.m07.entity.StaffEntity;
import dt.m07.repositoty.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;
    @Override
    public List<StaffEntity> getAllStaff() {
        return staffRepository.findAll();
    }
}
