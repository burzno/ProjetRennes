package sessions.dao;

import javax.ejb.Stateless;

import entities.tournoi.Tournoi;

/**
 * Dao héritant de la méthode abstraite AbstractDao permettant la gestion des tournois
 * @author g.joseph-mondesir
 *
 */
@SuppressWarnings("unchecked")
@Stateless
public class DaoTournoi extends AbstractDao<Tournoi> {

}
