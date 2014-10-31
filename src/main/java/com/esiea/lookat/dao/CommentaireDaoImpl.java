package com.esiea.lookat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.esiea.lookat.entities.Categorie;
import com.esiea.lookat.entities.Commentaire;
import com.esiea.lookat.entities.Site;
import com.esiea.lookat.entities.Utilisateur;

import static com.esiea.lookat.dao.DAOUtilitaire.*;

public class CommentaireDaoImpl implements ObjetDao{

    private static final String SQL_SELECT_PAR_ID = "SELECT * FROM commentaires WHERE id = ?";
    private static final String SQL_INSERT = "INSERT INTO commentaires (etoile, idSite, contenu, idUser) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE commentaires SET id = ? , etoile = ?, idSite = ?, contenu = ?, idUser = ? WHERE id = ?";
    private static final String SQL_DELETE = "DELETE FROM commentaires WHERE id = ?";

    private static final String SQL_SELECT_SITE_BY_COM = "SELECT site.id, site.url, site.nom, site.description, site.idCat, site.nbClick ,site.idUser FROM commentaires, site WHERE site.id = commentaires.idSite AND commentaires.id = ?";
    private static final String SQL_SELECT_USER_BY_COM = "SELECT utilisateurs.id, utilisateurs.pseudo, utilisateurs.password, utilisateurs.email FROM utilisateurs, commentaires WHERE commentaires.idUser = utilisateurs.id AND commentaires.id = ?";
 
	Logger logger = Logger.getLogger(CommentaireDaoImpl.class);
	private DAOFactory daoFactory;

	public void init() {
		logger.info("Comment Dao Dependency Done");
	}

	public CommentaireDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CommentaireDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
	
	@Override // R�cuperer le site du commentaire
	public Site getSiteCom(Commentaire commentaire) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Site site = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_SITE_BY_COM, false, commentaire.getId());
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                site = mapSite(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        return site;
	}

	@Override // R�cuperer l'utilisateur du commentaire
	public Utilisateur getComUser(Commentaire commentaire) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Utilisateur user = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_USER_BY_COM, false, commentaire.getId());
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                user = mapUtilisateur(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        return user;
	}

	@Override
	public void createCom(Commentaire commentaire) throws DAOException {
	       Connection connexion = null;
	        PreparedStatement preparedStatement = null;
	        ResultSet valeursAutoGenerees = null;

	        try {
	            /* Récupération d'une connexion depuis la Factory */
	            connexion = daoFactory.getConnection();
	            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, commentaire.getEtoile(), commentaire.getIdSite(), commentaire.getContenu(),commentaire.getIdUser());
	            int statut = preparedStatement.executeUpdate();
	            /* Analyse du statut retourné par la requête d'insertion */
	            if ( statut == 0 ) {
	                throw new DAOException( "Échec de la création du site, aucune ligne ajoutée dans la table." );
	            }
	            /* Récupération de l'id auto-généré par la requête d'insertion */
	            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
	            if ( valeursAutoGenerees.next() ) {
	                /* Puis initialisation de la propriété id du bean Utilisateur avec sa valeur */
	                commentaire.setId( valeursAutoGenerees.getInt( 1 ) );
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
	public Commentaire findCom(Integer id) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Commentaire com = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_PAR_ID, false, id);
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if (resultSet.next()) {
                com = mapCommentaire(resultSet);
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(resultSet, preparedStatement, connexion);
        }
        return com;
	}

	@Override
	public void modifyCom(Commentaire commentaire) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_UPDATE, false, commentaire.getId(), commentaire.getEtoile(), commentaire.getIdSite(), commentaire.getContenu(), commentaire.getIdUser(), commentaire.getId());
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
	public void deleteCom(Commentaire commentaire) throws DAOException {
		Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_DELETE, false, commentaire.getId());
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
	public void createSite(Site site) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Site findSite(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifySite(Site site) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteSite(Site site) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createUser(Utilisateur utilisateur) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyUser(Utilisateur utilisateur) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Utilisateur utilisateur) throws DAOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorie findCategorie(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Commentaire> getlistComs(Site site) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categorie getSiteCategorie(Site site) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> getAllSites() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getSiteUser(Site site) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorie> getAllCategories() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Site> getCategorieSites(Categorie catalogue)
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur findUser(Integer id) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
