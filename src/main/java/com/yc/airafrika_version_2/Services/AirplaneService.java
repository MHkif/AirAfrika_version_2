package com.yc.airafrika_version_2.Services;

import com.yc.airafrika_version_2.DAO.impl.AirPlaneDAO;
import com.yc.airafrika_version_2.Entity.Airplane;

import java.util.List;

public class AirplaneService implements Service<Airplane>{

    private final AirPlaneDAO airPlaneDAO = new AirPlaneDAO();
    @Override
    public Airplane save(Airplane airplane) {
        return null;
    }

    @Override
    public Airplane update(Airplane airplane) {
        return null;
    }

    @Override
    public boolean deactivate(Airplane t) {
        return false;
    }

    @Override
    public Airplane findBy(String id) {
        return airPlaneDAO.findBy(id);
    }

    @Override
    public List<Airplane> getAll()  {
        return airPlaneDAO.getAll();
    }
}
