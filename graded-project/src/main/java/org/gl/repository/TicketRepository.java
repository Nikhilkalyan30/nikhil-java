package org.gl.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import org.gl.model.Ticket;

@Repository
public interface TicketRepository extends MongoRepository<Ticket, String>{

}