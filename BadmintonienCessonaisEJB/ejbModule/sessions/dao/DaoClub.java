package sessions.dao;

import javax.ejb.Stateless;

import entities.utilisateur.Club;

/**
 * Dao héritant de la méthode abstraite AbstractDao permettant la gestion des clubs
 * @author g.joseph-mondesir
 *
 */
@SuppressWarnings("unchecked")
@Stateless
public class DaoClub extends AbstractDao<Club> {

}
