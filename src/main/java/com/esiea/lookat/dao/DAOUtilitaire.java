package com.esiea.lookat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.esiea.lookat.entities.Categorie;
import com.esiea.lookat.entities.Commentaire;
import com.esiea.lookat.entities.Site;
import com.esiea.lookat.entities.Utilisateur;

public final class DAOUtilitaire {

    /*
     * Initialise la requête préparée basée sur la connexion passée en argument,
     * avec la requête SQL et les objets donnés.
     */
    public static PreparedStatement initialisationRequetePreparee( Connection connexion, String sql, boolean returnGeneratedKeys, Object... objets ) throws SQLException {
        PreparedStatement preparedStatement = connexion.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objets.length; i++ ) {
            preparedStatement.setObject( i + 1, objets[i] );
        }
        return preparedStatement;
    }
    
    /*
     * Simple méthode utilitaire permettant de faire la correspondance (le
     * mapping) entre une ligne issue de la table des utilisateurs (un
     * ResultSet) et un bean Utilisateur.
     */
    static Site mapSite( ResultSet resultSet ) throws SQLException {
        Site site = new Site();
        site.setId( resultSet.getInt( "id" ) );
        site.setUrl( resultSet.getString( "url" ) );
        site.setDescription( resultSet.getString( "description" ) );
        site.setNom( resultSet.getString( "nom" ) );
        site.setIdCat( resultSet.getInt( "idCat" ) );
        site.setNbClick( resultSet.getInt( "nbClick" ) );
        site.setIdUser( resultSet.getInt( "idUser" ));
        return site;
    }
    
    static Commentaire mapCommentaire( ResultSet resultSet ) throws SQLException {
        Commentaire com = new Commentaire();
        com.setId( resultSet.getInt( "id" ) );
        com.setEtoile( resultSet.getString( "etoile" ) );
        com.setIdSite( resultSet.getInt( "idSite" ) );
        com.setContenu( resultSet.getString( "contenu" ) );
        com.setIdUser( resultSet.getInt( "idUser" ) );
        return com;
    }
    static Categorie mapCategorie( ResultSet resultSet ) throws SQLException {
    	Categorie cat = new Categorie();
    	cat.setId( resultSet.getInt( "id" ) );
    	cat.setNom( resultSet.getString( "nom" ) );
        return cat;
    }
    
    static Utilisateur mapUtilisateur( ResultSet resultSet ) throws SQLException {
    	Utilisateur user = new Utilisateur();
    	user.setId( resultSet.getInt( "id" ) );
    	user.setPseudo( resultSet.getString( "pseudo" ) );
    	user.setPassword( resultSet.getString( "password" ) );
    	user.setEmail( resultSet.getString( "email" ) );
        return user;
    }
    
    /* Fermeture silencieuse du resultset */
    public static void fermetureSilencieuse( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "Échec de la fermeture du ResultSet : " + e.getMessage() );
            }
        }
    }

    /* Fermeture silencieuse du statement */
    public static void fermetureSilencieuse( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "Échec de la fermeture du Statement : " + e.getMessage() );
            }
        }
    }

    /* Fermeture silencieuse de la connexion */
    public static void fermetureSilencieuse( Connection connexion ) {
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException e ) {
                System.out.println( "Échec de la fermeture de la connexion : " + e.getMessage() );
            }
        }
    }

    /* Fermetures silencieuses du statement et de la connexion */
    public static void fermeturesSilencieuses( Statement statement, Connection connexion ) {
        fermetureSilencieuse( statement );
        fermetureSilencieuse( connexion );
    }

    /* Fermetures silencieuses du resultset, du statement et de la connexion */
    public static void fermeturesSilencieuses( ResultSet resultSet, Statement statement, Connection connexion ) {
        fermetureSilencieuse( resultSet );
        fermetureSilencieuse( statement );
        fermetureSilencieuse( connexion );
    }
}
