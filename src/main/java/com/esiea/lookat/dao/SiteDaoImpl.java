package com.esiea.lookat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.esiea.lookat.beans.Site;
import static com.esiea.lookat.dao.DAOUtilitaire.*;

public class SiteDaoImpl implements SiteDao {
	

    private static final String SQL_SELECT_PAR_ID = "SELECT id, url, nom, description, idCat, nbClick FROM Site WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO Site (url, nom, description, idCat, nbClick) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE Site SET id = ? , url = ?, nom = ?, description = ?, idCat = ?, nbClick = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM Site WHERE id = ?";

    private DAOFactory daoFactory;

    SiteDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
    @Override
    public Site trouver( Integer id ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Site site = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_ID, false, id );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
                site = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
        return site;
    }

    

    /* Implémentation de la méthode définie dans l'interface UtilisateurDao */
    @Override
    public void creer( Site site ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;

        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, site.getUrl(), site.getNom(), site.getDescription(), site.getIdCat(), site.getNbClick());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du site, aucune ligne ajoutée dans la table." );
            }
            /* Récupération de l'id auto-généré par la requête d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
                site.setId( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException( "Échec de la création de l'utilisateur en base, aucun ID auto-généré retourné." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }

	@Override
	public void modifier(Site site) throws DAOException {
		 	Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet resultSet = null;

	        try {
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, false, site.getId(),site.getUrl(), site.getNom(), site.getDescription(), site.getIdCat(), site.getNbClick(), site.getId());
	            int statut = preparedStatement.executeUpdate();
	            /* Analyse du statut retourné par la requête d'insertion */
	            if ( statut == 0 ) {
	                throw new DAOException( "Échec de la création du site, aucune ligne ajoutée dans la table." );
	            }
	        } catch ( SQLException e ) {
	            throw new DAOException( e );
	        } finally {
	            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
	        }
	}

	@Override
	public void supprimer(Site site) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE, false, site.getId());
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourné par la requête d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "Échec de la création du site, aucune ligne ajoutée dans la table." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
	}
    
    

}