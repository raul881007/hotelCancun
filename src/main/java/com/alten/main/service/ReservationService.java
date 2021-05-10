package com.alten.main.service;

import com.alten.main.model.Reservation;
import com.alten.main.model.Room;
import com.alten.main.repository.ReservationRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService implements ReservationRepository{

    /**
     * Connection to the repository interface for operations with the database
     */
    @Autowired
    private ReservationRepository reservationRepository;


    /**
     * Entity Manager that establishes the connection for the subsequent use of CriteriaBuilder
     */
    @PersistenceContext
    EntityManager em;



    /**
     * Method that searches a database for reservations for a room
     * @param roomId room id
     * @return Reservation list for a room
     */
    @Override
    public List<Reservation> getReservationsByRoom(Long roomId) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Reservation> query = builder.createQuery( Reservation.class );
        Root<Reservation> root = query.from( Reservation.class );
        Join<Object, Object> joinRoom = root.join( "room", JoinType.INNER );
        query.where( builder.equal( joinRoom.get( "id" ), roomId ) );
        return em.createQuery( query ).getResultList();
    }


    /**
     * Methods inherited from the interface
     *
     */

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Reservation> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Reservation> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {
        reservationRepository.deleteById(aLong);
    }

    @Override
    public void delete(Reservation entity) {
        reservationRepository.delete(entity);
    }

    @Override
    public void deleteAll(Iterable<? extends Reservation> entities) {

    }

    @Override
    public void deleteAll() {

    }



    @Override
    public <S extends Reservation> S save(S entity) {
        return reservationRepository.save(entity);
    }

    @Override
    public <S extends Reservation> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Reservation> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Reservation> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<Reservation> entities) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Reservation getOne(Long aLong) {
        return null;
    }

    @Override
    public <S extends Reservation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Reservation> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Reservation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Reservation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Reservation> boolean exists(Example<S> example) {
        return false;
    }



}
