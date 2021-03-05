package ua.lviv.lgs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.ParticipantRepo;
import ua.lviv.lgs.domain.Participant;

@Service
public class ParticipantService {

	@Autowired
	private ParticipantRepo repo;

	public List<Participant> findAll() {
		return repo.findAll();
	}

	public Participant findOne(Integer id) {
		return repo.findOne(id);
	}

	public void save(Participant participant) {
		repo.save(participant);
	}

	public void delete(Integer id) {
		repo.delete(id);
	}

}
