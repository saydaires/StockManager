package com.studies.stock_manager.services;
import com.studies.stock_manager.entities.Supplier;
import com.studies.stock_manager.repositories.SupplierRepository;
import com.studies.stock_manager.services.exceptions.DelayedRecordException;
import com.studies.stock_manager.services.exceptions.EntityNotFoundException;
import java.util.NoSuchElementException;
import java.util.List;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public void create(Supplier supplier) {
        supplierRepository.create(supplier);
    }

    public Supplier getById(long id) {
        try {
            return supplierRepository.getById(id);
        }
        catch(NoSuchElementException error) {
            throw new EntityNotFoundException("Supplier Not Found!", error);
        }
    }

    public List<Supplier> getAll() {
        return supplierRepository.getAll();
    }


    public void update(Supplier supplier) {
        try {
            supplierRepository.update(supplier);
        }
        catch(IllegalArgumentException error) {
            throw new EntityNotFoundException("Object cannot be null!", error);
        }
        catch(OptimisticLockingFailureException error) {
            throw new DelayedRecordException("Application data in conflict with the database!", error);
        }
    }

    public void delete(long id) {
        try {
            supplierRepository.delete(id);
        } catch (IllegalArgumentException error) {
            throw new EntityNotFoundException("Field Id cannot be null!", error);
        }
    }
}
