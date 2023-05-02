package isos.tutorial.isyiesd.cesvector.sertransactionmanager;

import java.util.UUID;

import isos.tutorial.isyiesd.cesvector.servector.IVector;

public interface ITransaction {
    void enlistResource(IVector vector);
    void commit();
    void rollback();
    UUID getId();
}
