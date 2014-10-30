package com.esiea.lookat.dao;

import com.esiea.lookat.beans.Site;

public interface SiteDao {

    void creer( Site site ) throws DAOException;

    Site trouver( Integer id ) throws DAOException;

    void modifier (Site site) throws DAOException;
    
    void supprimer (Site site) throws DAOException;
}